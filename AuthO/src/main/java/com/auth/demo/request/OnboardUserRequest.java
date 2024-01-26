package com.auth.demo.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OnboardUserRequest {

	@NotNull(message = "firstname.error.null")
	@Size(max = 30, min = 5, message = "firstname.error.size")
	private String firstName;

	@NotNull(message = "lastname.error.null")
	@Size(max = 30, min = 5, message = "lastname.error.size")
	private String lastName;

	@NotNull(message = "password.error.null")
	private String password;

	@NotNull(message = "phoneNo.error.null")
	@Size(max = 10, min = 10, message = "phoneNo.error.size")
	private String phoneNo;

	@Size(max = 20, message = "city.error.size")
	private String city;

}
