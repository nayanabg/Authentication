package com.auth.demo.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class LoginRequest {
	
	private String userName;
	
	private String password;
	

}
