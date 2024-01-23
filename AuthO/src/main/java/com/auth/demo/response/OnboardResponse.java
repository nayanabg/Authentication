package com.auth.demo.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OnboardResponse {
	
	private Long userId;
	
	private String roleName;
	
	private String userName;

}
