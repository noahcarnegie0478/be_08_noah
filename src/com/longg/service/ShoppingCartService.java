package com.longg.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import com.longg.dto.Cart;
import com.longg.dto.CartItem;
import com.longg.dto.Product;
import com.longg.dto.Shop;
import com.longg.env.EnvironmentService;

public class ShoppingCartService {

	public void addToCart(Cart cart, Product product, int quantity) throws IOException {	
		String cartToDB = EnvironmentService.sessionCustomer.id + "," + product.name + "," + product.price + "," + quantity;	 
		 FileWriter fileWriter = new FileWriter(EnvironmentService.CART_FILE_PATH, true);
		 BufferedWriter writer = new BufferedWriter(fileWriter);
		 writer.newLine();
		 writer.write(cartToDB);
		 writer.close();
		 fileWriter.close();
		 EnvironmentService.currentCart = getAllCartsOfCurrentUser();
	}
	
	

	private CartItem findProduct(Cart cart, Product product) {
		for (CartItem item : cart.items) {
			if (item.name.equals(product.name)) {
				return item;
			}
		}
		return null;
	}

	public void showCart(Cart cart) {
		if (cart.items.size() == 0) {
			System.out.println("Your cart is empty");
			return;
		}
		for (CartItem i : cart.items) {
			System.out.println(i.name + " = " + i.price + ". quantity = " + i.quantity );
		}
	}
	
	public Cart getAllCartsOfCurrentUser() {		
		try {
			File file = new File(EnvironmentService.CART_FILE_PATH);
			Scanner scan = new Scanner(file);
			Cart list = new Cart();
			scan.nextLine();
			while (scan.hasNextLine()) {
				String row = scan.nextLine();		
				CartItem cart = readRow(row);
				if (cart != null )  {
					list.items.add(cart);
				}
			}

			return list;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	
	private CartItem readRow(String row) {
		Scanner rowScanner = new Scanner(row);
		rowScanner.useDelimiter(",");
		String userName = rowScanner.next();
		String productName = rowScanner.next();
		String price = rowScanner.next();
		String quantity = rowScanner.next();
		rowScanner.close();
		if (EnvironmentService.sessionCustomer.id.equals(userName) ) {
			System.out.println("They got here!");
			return new CartItem(userName,new Product(productName,Double.parseDouble(price)),Integer.parseInt(quantity));
		}
		return null;
	}
	
}
