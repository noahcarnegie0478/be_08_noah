package com.longg.service;
import java.io.File;
import com.longg.env.EnvironmentService;
import java.io.FileNotFoundException;
import java.util.*;
import com.longg.dto.Shop;

public class ShopService {
	
	public ArrayList<Shop> getAllShops() {	
		String FILE_PATH = EnvironmentService.SHOP_FILE_PATH;
		try {
			File file = new File(FILE_PATH);
			Scanner scan = new Scanner(file);
			ArrayList<Shop> list = new ArrayList<>();
			scan.nextLine();
			while (scan.hasNextLine()) {
				String row = scan.nextLine();
			
				Shop s = readRow(row);
				
				list.add(s);
				
			}
			return list;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	
	private Shop readRow(String row) {
		Scanner rowScanner = new Scanner(row);
		rowScanner.useDelimiter(",");
	
		String id = rowScanner.next();
		String name = rowScanner.next();
		String dbPath = rowScanner.next();
		rowScanner.close();
		
		return new Shop(Integer.parseInt(id), name, dbPath);
	}
}
