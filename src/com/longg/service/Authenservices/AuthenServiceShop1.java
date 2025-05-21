package com.longg.service.Authenservices;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.longg.service.EmailService;

public class AuthenServiceShop1 extends AuthenService {

	@Override
	public void handleAuthentication() {
		// TODO Auto-generated method stub
		System.out.print("You has been succesfully loged in thorugh email");
		
		EmailService emailService = new EmailService();
		try {
			emailService.EmailSender("Email login alert", "Succesfully Login");
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	
	

}
