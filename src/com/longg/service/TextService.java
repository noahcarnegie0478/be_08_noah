package com.longg.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class TextService {
	
	
	public void saveInFor(String content, String pathWay) {
		
		try {
			FileWriter file = new FileWriter(pathWay, true);
			BufferedWriter writter = new BufferedWriter(file);
			writter.newLine();
			writter.write(content);
			writter.close();
			file.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
