package edu.osu.cse5234.model;

import java.util.List;

import edu.osu.cse5234.business.view.Item;

public class Order {
	private String orderID;
	private List<Item> items;
	private static int orderNum = 0;
	
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public String getOrderID() {
		return orderID;
	}
	
	public String confirm() {
		if (orderID != null) return getOrderID();
		orderNum++;
		orderID = String.format("%12d", orderNum).replace(" ", "0");
		return orderID;
	}
	
}
