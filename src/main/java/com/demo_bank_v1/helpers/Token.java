package com.demo_bank_v1.helpers;

import java.util.UUID;

public class Token {
	
	public static String generateToken() {
		
		String Token=UUID.randomUUID().toString();
		return Token;
	}

}
