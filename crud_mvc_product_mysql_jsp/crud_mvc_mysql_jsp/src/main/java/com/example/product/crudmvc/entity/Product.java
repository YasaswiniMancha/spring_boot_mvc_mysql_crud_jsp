package com.example.product.crudmvc.entity;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT_MVC_TBL")
public class Product {

	@Id
	@GeneratedValue

	private Integer itemNumber;
	private String itemName;
	private String price;
	private String availability;

	public Integer getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(Integer itemNumber) {
		this.itemNumber = itemNumber;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	@Override
	public String toString() {
		return "Product [itemNumber=" + itemNumber + ", itemName=" + itemName + ", price=" + price + ", availability="
				+ availability + "]";
	}

	

}
