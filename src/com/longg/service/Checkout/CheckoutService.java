package com.longg.service.Checkout;

import com.longg.Main;
import com.longg.dto.Cart;
import com.longg.dto.Shop;

public abstract class CheckoutService {
	public int total;
	
	public abstract void handleCheckout(Cart cart);
	
	public static CheckoutService getCheckout(Shop shop) {
		System.out.println(shop.id);
		if (shop.id == 1) {
			return new CheckoutServiceShop1();
		}else if (shop.id == 2) {
			return new CheckoutServiceShop2();
		}else {
			return new CheckoutServiceShop3();
		}
		
	}

	

}
