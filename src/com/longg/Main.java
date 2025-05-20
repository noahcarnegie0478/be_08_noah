package com.longg;

import com.longg.service.ShopService;
import com.longg.service.ProductService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.longg.dto.Cart;
import com.longg.dto.CartItem;
import com.longg.dto.Product;
import com.longg.dto.Shop;
import com.longg.env.EnvironmentService;
import com.longg.service.AuthenService;
import com.longg.service.ProductService;
import com.longg.service.ShoppingCartService;

public class Main {

	
	static Scanner scan = new Scanner(System.in);
	private static final int VIEW_CART_OPTION_ON_MENU = 0;

	private static ShoppingCartService cartService = new ShoppingCartService();
	private static AuthenService authenService = new AuthenService();
	public static Shop shop = new Shop();
	public static void main(String[] args) {
		

		boolean isLoggedin;
		selectShop();

		do {
			isLoggedin = doLogin();
		} while (!isLoggedin);
	
		do {
			showMenu();

			System.out.print("Enter An Option: ");
			int option = scan.nextInt();
			scan.nextLine();

			if (option == VIEW_CART_OPTION_ON_MENU) {
				cartService.showCart(EnvironmentService.currentCart);
			} else {
				try {
					doAddProductToCart(option);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}

		} while (true);
	}

	private static void showMenu() {
		ArrayList<Product> productions = new ProductService().getAllProducts();
		System.out.println("0. View Cart");
		for (int i = 0; i < productions.size(); i++) {
			System.out.println(
					(i + 1) + ". " + productions.get(i).name + " : " + productions.get(i).price);
		}
	}
	
	
	private static void selectShop() {
		ShopService shopService = new ShopService();
		ArrayList<Shop> shops = shopService.getAllShops();
		System.out.println("============================ Shops ============================");
		for (int i = 0; i < shops.size(); i++) {
			System.out.println(( shops.get(i).id) +  ":  " + shops.get(i).name );
		}	
		System.out.println("============================");
		System.out.println("Enter An Option: ");
		int option = scan.nextInt();
		scan.nextLine();
		shop = shops.get(option -  1);
		System.out.println(shop.name);
		
	}


	private static boolean doLogin() {
		System.out.print("Enter ID: ");
		String userID = scan.nextLine();

		// Enter Password
		System.out.print("Enter Password: ");
		String userPassword = scan.nextLine();

		boolean isLoggedin = authenService.login(userID, userPassword);
		if (isLoggedin) {
			EnvironmentService.currentCart = cartService.getAllCartsOfCurrentUser();
			System.out.println(EnvironmentService.sessionCustomer.id);
//			if (EnvironmentService.currentCart.items.size() != 0) {
//				System.out.println("its has been added");
//			}
		}
		return isLoggedin;
	}

	private static void doAddProductToCart(int productIndex) throws IOException {
		ArrayList<Product> productions = new ProductService().getAllProducts();
		Product selectedProduct = productions.get(productIndex - 1);

		System.out.print("Enter quantity : ");
		int quantity = Integer.parseInt(scan.nextLine());

		cartService.addToCart(EnvironmentService.currentCart, selectedProduct, quantity);

		System.out.println("Added succesfully.");
	}

}
