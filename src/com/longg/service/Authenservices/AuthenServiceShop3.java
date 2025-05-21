package com.longg.service.Authenservices;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import com.longg.env.EnvironmentService;
import com.longg.service.TextService;

public class AuthenServiceShop3 extends AuthenService {

	@Override
	public void handleAuthentication() {
		// TODO Auto-generated method stub
		
		LocalDateTime loginTime = LocalDateTime.now();
		DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String loginDetail = EnvironmentService.sessionCustomer.id + "," + loginTime.format(myFormat);
		TextService textService = new TextService();
		textService.saveInFor(loginDetail, EnvironmentService.LOGIN_FILE_PATH);
		
	}

	

}
