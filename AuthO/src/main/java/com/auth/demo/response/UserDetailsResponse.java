package com.auth.demo.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class UserDetailsResponse {
	
	private String userName;
	
	private String phoneNo;
	
	private String city;
	
	private String roleName;

}
