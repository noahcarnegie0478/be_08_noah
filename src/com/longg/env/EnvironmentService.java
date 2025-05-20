package com.longg.env;

import com.longg.Main;
import com.longg.dto.Cart;
import com.longg.dto.Customer;


public class EnvironmentService {
	
	public static final String FILE_PATH = "be8_noah/src/com/longg/db/";
	public static final String SHOP_FILE_PATH = FILE_PATH + "shop/shop.txt";
	public static String CUSTOMER_FILE_PATH = FILE_PATH + Main.shop.dbPath + "/customer.txt";
	public static String PRODUCT_FILE_PATH = FILE_PATH + Main.shop.dbPath + "/product.txt";
	public static String CART_FILE_PATH = FILE_PATH + Main.shop.dbPath + "/cart.txt";
	public static Customer sessionCustomer = new Customer();
	public static Cart currentCart;

}
