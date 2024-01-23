package com.auth.demo.utility;

public enum StatusConstants {

	ONBOARD_SUCCESS(101, "user.onboard.success"), ONBOARD_FAILURE(102, "user.onboard.failure");

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
