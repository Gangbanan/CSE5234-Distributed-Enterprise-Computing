package edu.osu.cse5234.business;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.osu.cse5234.business.view.Inventory;
import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.business.view.Item;

/**
 * Session Bean implementation class InventoryServiceBean
 */
@Stateless
public class InventoryServiceBean implements InventoryService {

    /**
     * Default constructor. 
     */
	
	@PersistenceContext
	EntityManager entityManager;
	
	private final String MY_QUERY = "SELECT i FROM Item i";
	List<Item> inventoryList = null;
	
    public InventoryServiceBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Inventory getAvailableInventory() {
		System.out.println("222");
		updateInventoryList();
		Inventory inventory = new Inventory();
		inventory.setItems(inventoryList);
		
		return inventory;
	}

	@Override
	public boolean validateQuantity(List<Item> itemList) {
		updateInventoryList();
		for (Item itemInv : inventoryList) {
			for (Item item : itemList) {
				if (item.getQuantity() < 0 || 
					itemInv.getId() == item.getId() && item.getQuantity() >  itemInv.getQuantity())
					return false;
			}
		}
		
		return true;
	}

	@Override
	public boolean updateInventory(List<Item> itemList) {
		// TODO Auto-generated method stub
		return true;
	}
    
	public void updateInventoryList() {
		inventoryList = entityManager.createQuery(MY_QUERY, Item.class).getResultList();
	}
	
	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
}
