package com.auth.demo.utils;

import java.util.Base64;

public class PasswordEncoder {

	/* Password encoded with base64 format for response visibility */
	public String encodePassword(String password) {

		byte[] inputStringBytes = password.getBytes();
		String base64String = Base64.getEncoder().encodeToString(inputStringBytes);
		return base64String;
	}

}
