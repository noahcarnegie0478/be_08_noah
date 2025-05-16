package com.longg.dto;
import java.util.*;

public class Shop {
	public int id;
	public String name;
	public String dbPath;
//	public ArrayList<Product> products;
//	public ArrayList<Customer> customers;
	
	public Shop() {
		
	}
	public Shop(int id, String name, String dbPath) {
		super();
		this.id = id;
		this.name = name;
		this.dbPath = dbPath;
		
	}
}