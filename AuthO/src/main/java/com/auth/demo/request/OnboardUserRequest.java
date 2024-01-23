package com.auth.demo.request;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OnboardUserRequest {
	
	@NonNull
	@Size(max = 30,min = 5)
	private String firstName;
	
	@NonNull
	@Size(max = 30,min = 5)
	private String lastName;
	
	@NonNull
	private String password;
	
	@NonNull
	@Size(max = 10,min = 10)
	private String phoneNo;
	
	@Size(max = 20)
	private String city;

}
