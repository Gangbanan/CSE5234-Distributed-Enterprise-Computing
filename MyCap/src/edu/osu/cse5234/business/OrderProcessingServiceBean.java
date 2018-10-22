package edu.osu.cse5234.business;

import java.util.Random;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.util.ServiceLocator;



/**
 * Session Bean implementation class OrderProcessingServiceBean
 */
@Stateless
@LocalBean
public class OrderProcessingServiceBean {

    /**
     * Default constructor. 
     */
    public OrderProcessingServiceBean() {
        // TODO Auto-generated constructor stub
    }
    
    public String processOrder (Order order) {
    	InventoryService invSer = ServiceLocator.getInventoryService();
    	if (invSer.validateQuantity(order.getItems()) == false) return null;
    	invSer.updateInventory(order.getItems());
    	Random random = new Random();
    	int orderNum = random.nextInt(10000000);
    	String confirmId = String.format("%12d", orderNum).replace(" ", "0");
    	return confirmId;
    }
    
    public boolean validateItemAvailability(Order order) {
    	InventoryService invSer = ServiceLocator.getInventoryService();
    	return invSer.validateQuantity(order.getItems());
    }
    
    
    
}
