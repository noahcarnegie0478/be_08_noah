package com.longg.service.Authenservices;
import com.longg.env.EnvironmentService;
import com.longg.service.CustomerService;

import java.util.ArrayList;

import com.longg.Main;
import com.longg.dto.Customer;
import com.longg.dto.Shop;

// service class -> contain functions 
public  abstract class AuthenService {
	
	public boolean login(String id, String password) {
	ArrayList<Customer> customerList = new CustomerService().getAllCustomers();

		for (Customer c : customerList) {
			if (c.id.equals(id) && c.password.equals(password)) {
				
				EnvironmentService.sessionCustomer = c;
				handleAuthentication();
				return true;
			}
		}
		return false;
	}
	
	public abstract void handleAuthentication() 	;

	public static AuthenService getAuthen(Shop shop) {
		if (shop.id == 1) {
			return new AuthenServiceShop1();
		} else if (shop.id == 2) {
			return new AuthenServiceShop2();
		}else {
			return new AuthenServiceShop3();
		}
	}

	
}
