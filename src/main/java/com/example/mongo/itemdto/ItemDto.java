package com.example.mongo.itemdto;

import com.example.mongo.dao.Item;

public class ItemDto {
private String itemName;
private Double itemPrice;

public ItemDto() {}

public ItemDto(Item item) {
	this.itemName = item.getItemName();
	this.itemPrice = item.getItemPrice();
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
