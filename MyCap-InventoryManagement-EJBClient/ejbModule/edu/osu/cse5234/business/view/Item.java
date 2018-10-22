	package edu.osu.cse5234.business.view;

import javax.persistence.*;

import sun.misc.JavaAWTAccess;

@Entity
@Table(name="ITEM")
public class Item implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 529792865303031544L;
	/**
	 * 
	 */
	
//	private int id;
//	private int itemNumber;
//	private String name;
//	private String description;
//	private int quantity;
//	private double price;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="ITEM_NUMBER")
	private int itemNumber;
	@Column(name="NAME")
	private String name;
	@Column(name="DESCRIPTION")
	private String description;
	@Column(name="AVAILABLE_QUANTITY")
	private int quantity;
	@Column(name="UNIT_PRICE")
	private double price;
	
	
	
	public Item() {}
	
	public Item(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getItemNubmer() {
		return this.itemNumber;
	}

	public void setItemNubmer(int itemNumber) {
		this.itemNumber = itemNumber;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
