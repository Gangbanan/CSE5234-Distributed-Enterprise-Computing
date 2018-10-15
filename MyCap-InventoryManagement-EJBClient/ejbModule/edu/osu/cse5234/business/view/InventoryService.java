package edu.osu.cse5234.business.view;

import java.util.List;

import javax.ejb.Remote;


@Remote
public interface InventoryService {
	public Inventory getAvailableInventory();
	public boolean validateQuantity(List <Item> itemList);
	public boolean updateInventory(List <Item> itemList);
}
