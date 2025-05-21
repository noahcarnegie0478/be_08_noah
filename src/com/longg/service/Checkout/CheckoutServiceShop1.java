package com.longg.service.Checkout;

import java.time.LocalDateTime;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.longg.dto.Cart;
import com.longg.env.EnvironmentService;
import com.longg.service.EmailService;
import com.longg.service.ShoppingCartService;
import com.longg.service.interfaces.SendEmail;

public class CheckoutServiceShop1 extends CheckoutService implements SendEmail {
	


	@Override
	public void handleCheckout(Cart cart) {
		// TODO Auto-generated method stub
		total = ShoppingCartService.showCart(cart);
		System.out.println("Total of your cart is: " + total);
		sendEmail();
		
		
	}

	public void sendEmail() {
		EmailService emailService = new EmailService();
		String checkoutDetail = "User:" + EnvironmentService.sessionCustomer.id + "has purcharsed $" + total + " at "+ LocalDateTime.now();
		try {
			emailService.EmailSender("Detail of your payment", checkoutDetail);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
