package edu.osu.cse5234.business;

import java.util.Random;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.ws.WebServiceRef;

import com.chase.payment.CreditCardPayment;
import com.chase.payment.PaymentProcessorService;
import com.ups.shipping.client.ShippingInitiationClient;

import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.util.ServiceLocator;



/**
 * Session Bean implementation class OrderProcessingServiceBean
 */
@Stateless
@LocalBean
public class OrderProcessingServiceBean {
	
	@PersistenceContext(unitName="MyCap")
	EntityManager entityManager;
	
	@WebServiceRef(wsdlLocation="http://localhost:9080/ChaseBankApplication/PaymentProcessorService?wsdl")
	private PaymentProcessorService service;
	
	private static String shippingResourceURI = "http://localhost:9080/UPS/jaxrs";
	
    public OrderProcessingServiceBean() {
        // TODO Auto-generated constructor stub
    }
    
    public String processOrder (Order order) {
    	// update inventory
    	InventoryService invSer = ServiceLocator.getInventoryService();
    	if (invSer.validateQuantity(order.getItems()) == false) return null;
    	invSer.updateInventory(order.getItems());
    	
    	CreditCardPayment creditCardPayment = order.getPayment().toCreditCardPayment();
    	String paymentPort = service.getPaymentProcessorPort().processPayment(creditCardPayment);
    	int port = Integer.parseInt(paymentPort);
    	if (port < 0) {
    		return "-1";
    	}
    	System.out.println(paymentPort);
    	order.getPayment().setConfirmationNumber(paymentPort);
    	
    	// store order into DB
    	entityManager.persist(order);
    	entityManager.flush();
    	
    	ShippingInitiationClient shippingInitiationClient = new ShippingInitiationClient(shippingResourceURI);
    	JsonObject responseJson =  shippingInitiationClient.invokeInitiateShipping(shippingInfoToJson(order));
    	
    	System.out.println("UPS accepted request? " + responseJson.getBoolean("Accepted"));
    	System.out.println("Shipping Reference Number: " +  responseJson.getInt("ShippingReferenceNumber"));
    	
    	int shipRefNum = responseJson.getInt("ShippingReferenceNumber");
    	order.getShipping().setShippingRefNumber(String.valueOf(shipRefNum));
    	
    	entityManager.persist(order);
    	entityManager.flush();
    	
    	Random random = new Random();
    	int orderNum = random.nextInt(10000000);
    	String confirmId = String.format("%12d", orderNum).replace(" ", "0");
    	return confirmId;
    }
    
    public boolean validateItemAvailability(Order order) {
    	InventoryService invSer = ServiceLocator.getInventoryService();
    	return invSer.validateQuantity(order.getItems());
    }
    
	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public JsonObject shippingInfoToJson(Order order) {
		return Json.createObjectBuilder()
				.add("Organization", "MyCap LLC.")
				.add("OrderRefId", order.getId())
				.add("Zip", order.getShipping().getZip())
				.add("ItemsNumber", order.getLineItems().size()).build();
	}
    
    
}
