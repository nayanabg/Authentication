package com.auth.demo.Common;

import org.springframework.http.HttpStatus;

public class APIError {
	
    private HttpStatus status;
    private String message;
    private String errors;

    public APIError(HttpStatus status, String message, String errors) {
        super();
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

}
