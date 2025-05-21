package com.longg.service;


import javax.mail.*;

import javax.mail.internet.*;

import com.longg.env.EnvironmentService;

import java.util.Properties;



public class EmailService {
	Session newSession = null;
	
	
	public void EmailSender(String subject, String body) throws AddressException, MessagingException {
		
		setupServer();
		sendEmail(emailContent(subject, body));
		
	}
	

	
	private void sendEmail(MimeMessage content) throws MessagingException {
		String sender = EnvironmentService.email;
		String passkey = EnvironmentService.passkey;
		String emailHost = "smtp.gmail.com";
		Transport transport = newSession.getTransport("smtp");
		transport.connect(emailHost, sender, passkey);
		transport.sendMessage(content, content.getAllRecipients());
		transport.close();
		System.out.println("Email has been sent");
		 
		
		
		
		
	}
	
	private MimeMessage emailContent(String subject, String body) throws AddressException, MessagingException {
		String recipient = "brucehoang99@gmail.com";
		MimeMessage message = new MimeMessage(newSession);
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
		message.setSubject(subject);
		message.setText(body);
		
		return message;
		
		
		
		
		
		
		
	}
	private void setupServer() {
		Properties property = System.getProperties();
		property.put("mail.smtp.port", "587");
		property.put("mail.smtp.auth", "auth");
		property.put("mail.smtp.starttls.enable", "true");
		newSession = Session.getDefaultInstance(property, null);
		
		
		
	}
}
