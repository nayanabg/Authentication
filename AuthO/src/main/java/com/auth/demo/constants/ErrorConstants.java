package com.auth.demo.constants;

public enum ErrorConstants {
	
	ONBOARD_FAILURE(001, "user.onboard.failure"),REQUEST_NULL(002, "request.is.null");

	private int errorCode;
	private String errorMessage;

	ErrorConstants(int code, String message) {
		// TODO Auto-generated constructor stub
		this.errorCode = code;
		this.errorMessage = message;
	}

	public int getStatusCode() {
		return errorCode;
	}

	public String getStatusMessage() {
		return errorMessage;
	}

}
