package com.example.mongo.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "item")
public class Item {
	@Id
	@Field("_id")
	private int id;
	@Field("item_name")
	private String itemName;
	@Field("item_price")
	private Double itemPrice;
	
	@PersistenceConstructor
	public Item(int id, String itemName, @Value("#root.item_price ?: 0.0") Double itemPrice) {
		this.id = id;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
	}
	
	public Item() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	
}
