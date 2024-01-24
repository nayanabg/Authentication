package com.auth.demo.common;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class APIError {

	private String errorMessage;
	private int errorCode;
	private HttpStatus status;

	public APIError(int errors, String message, HttpStatus status) {
		super();
		this.status = status;
		this.errorMessage = message;
		this.errorCode = errors;
	}

}
