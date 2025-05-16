package com.longg.dto;

public class CartItem extends Product {

	public int quantity;
	public String userName;

	public CartItem() {
	}

	public CartItem(String name, int price) {
		super(name, price);
	}

	public CartItem(String userName,Product product, int quantity) {
		this.userName = userName;
		this.name = product.name;
		this.price = product.price;
		this.quantity = quantity;
		
	}
	
}
