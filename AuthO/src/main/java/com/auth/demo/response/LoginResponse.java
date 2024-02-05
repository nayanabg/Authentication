package com.auth.demo.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginResponse {

	private String userName;
	private String password;
	private String token;
}
