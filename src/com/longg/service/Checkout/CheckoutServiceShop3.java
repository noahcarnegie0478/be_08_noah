package com.longg.service.Checkout;

import java.time.LocalDateTime;
import java.util.Scanner;

import com.longg.dto.Cart;
import com.longg.env.EnvironmentService;
import com.longg.service.ShoppingCartService;
import com.longg.service.TextService;

public class CheckoutServiceShop3 extends CheckoutService {
	final int Checkout = 0;
	Scanner scan = new Scanner(System.in);
	

	@Override
	public void handleCheckout(Cart cart) {
		// TODO Auto-generated method stub
		total = ShoppingCartService.showCart(cart);
		TextService textService = new TextService();
		String checkoutDetail = EnvironmentService.sessionCustomer.id + "," + total + ","+ LocalDateTime.now();
		System.out.println("Total of your cart is: $" + total);
		System.out.println("================= Do you want to checkout? ==================");
		System.out.println("================= If yes please press 0 ==================");
		System.out.println("================= If not please press any button ==================");
		int option = scan.nextInt();
		
		switch (option) {
		case Checkout: 
			textService.saveInFor(checkoutDetail, EnvironmentService.CHECKOUT_FILE_PATH);
			System.out.println("================= Thank you for Checkout! ==================");
			
			break;
			
		default: 
			System.out.println("Please continue your shopping !");
			
		}
		
	}
	
	


}
