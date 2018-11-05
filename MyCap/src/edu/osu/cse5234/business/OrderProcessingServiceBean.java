package edu.osu.cse5234.business;

import java.util.Random;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.ws.WebServiceRef;

import com.chase.payment.CreditCardPayment;
import com.chase.payment.PaymentProcessorService;

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

    
    
}
