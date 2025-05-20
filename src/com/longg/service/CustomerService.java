package com.longg.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.longg.Main;
import com.longg.env.*;
import com.longg.dto.Customer;
import com.longg.dto.Shop;

public class CustomerService {

	public  ArrayList<Customer> getAllCustomers() {		
		try {
			File file = new File(EnvironmentService.CUSTOMER_FILE_PATH);
			Scanner scan = new Scanner(file);
			ArrayList<Customer> list = new ArrayList<>();
			scan.nextLine();
			while (scan.hasNextLine()) {
				String row = scan.nextLine();
			
				Customer s = readRow(row);
				
				list.add(s);
				
			}
			return list;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	
	private Customer readRow(String row) {
		Scanner rowScanner = new Scanner(row);
		rowScanner.useDelimiter(",");
		String id = rowScanner.next();
		String password = rowScanner.next();
		rowScanner.close();
		
		return new Customer(id, password);
	}

}
