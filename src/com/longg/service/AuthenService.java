package com.longg.service;
import com.longg.env.EnvironmentService;

import java.util.ArrayList;
import com.longg.Main;

import com.longg.dto.Customer;
import com.longg.service.CustomerService;

// service class -> contain functions 
public class AuthenService {
	
	public boolean login(String id, String password) {
	ArrayList<Customer> customerList = new CustomerService().getAllCustomers();
		
		
		
		
		
		for (Customer c : customerList) {
			if (c.id.equals(id) && c.password.equals(password)) {
				System.out.println("id" + c.id  + " password" + c.password );
				EnvironmentService.sessionCustomer = c;
				return true;
			}
		}
		return false;
	}
	
	
	//handle authentication

	
}
