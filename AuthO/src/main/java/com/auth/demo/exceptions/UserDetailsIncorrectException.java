package com.auth.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserDetailsIncorrectException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserDetailsIncorrectException(String message) {
		super(message);
	}

	public UserDetailsIncorrectException(String message, Throwable cause) {
		super(message, cause);
	}

}
