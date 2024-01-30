package com.auth.demo.constants;

public enum StatusConstants {

	ONBOARD_SUCCESS(101, "user.onboard.success"), USER_FOUND(102, "user.details.found"),
	LOGIN_SUCCESS(103, "login.user.success");

	private int code;
	private String message;

	StatusConstants(int code, String message) {
		// TODO Auto-generated constructor stub
		this.code = code;
		this.message = message;
	}

	public int getStatusCode() {
		return code;
	}

	public String getStatusMessage() {
		return message;
	}

}
