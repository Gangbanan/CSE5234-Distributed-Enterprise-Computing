package edu.osu.cse5234.business;

import java.util.Arrays;
import java.util.List;

import javax.ejb.Stateless;

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
    public InventoryServiceBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Inventory getAvailableInventory() {
		// TODO Auto-generated method stub
		Item item1 = new Item("New York Yankees '47 MLB Black Series MVP Cap", "15", "10");
		Item item2 = new Item("Melin The Bar Inlay Cap", "16", "20");
		Item item3 = new Item("Cap1", "17", "30");
		Item item4 = new Item("Cap1", "18", "40");
		Item item5 = new Item("Cap1", "19", "50");
		List<Item> itemList = Arrays.asList(item1, item2, item3, item4, item5);
		Inventory inventory = new Inventory();
		inventory.setItems(itemList);
		return inventory;
	}

	@Override
	public boolean validateQuantity(List<Item> itemList) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean updateInventory(List<Item> itemList) {
		// TODO Auto-generated method stub
		return true;
	}
    

}