	package edu.osu.cse5234.business.view;

import javax.persistence.*;

import sun.misc.JavaAWTAccess;

@Entity
@Table(name="ITEM")
public class Item implements java.io.Serializable{
	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 529792865303031544L;
	/**
	 * 
	 */
	
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
	
	public Item(int id, int itemNumber, String name, String description, int quantity, double price) {
		this.id = id;
		this.itemNumber = itemNumber;
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getItemNumber() {
		return this.itemNumber;
	}

	public void setItemNumber(int itemNumber) {
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
