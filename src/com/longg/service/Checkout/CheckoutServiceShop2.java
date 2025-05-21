package com.longg.service.Checkout;

import com.longg.dto.Cart;

import com.longg.service.ShoppingCartService;

public class CheckoutServiceShop2 extends CheckoutService {

	
	@Override
	public void handleCheckout(Cart cart) {
		// TODO Auto-generated method stub
		total = ShoppingCartService.showCart(cart);
		System.out.println("Total of your cart is: " + total);
		
		
		
	}
	


}
