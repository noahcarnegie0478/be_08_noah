package com.longg.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.longg.dto.Product;
import com.longg.env.EnvironmentService;

public class ProductService {
	
	public  ArrayList<Product> getAllProducts() {		
		try {
			File file = new File(EnvironmentService.PRODUCT_FILE_PATH);
			Scanner scan = new Scanner(file);
			ArrayList<Product> list = new ArrayList<>();
			scan.nextLine();
			while (scan.hasNextLine()) {
				String row = scan.nextLine();
			
				Product s = readRow(row);
				
				list.add(s);
				
			}
			return list;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	
	private Product readRow(String row) {
		Scanner rowScanner = new Scanner(row);
		rowScanner.useDelimiter(",");
		String name = rowScanner.next();
		String price = rowScanner.next();
		rowScanner.close();
		
		return new Product(name, Double.parseDouble(price));
	}


}
