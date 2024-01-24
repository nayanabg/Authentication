package com.auth.demo.common;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {

	public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object response,
			APIError error) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", message);
		map.put("status", status.value());
		map.put("data", response);
		map.put("error", error);

		return new ResponseEntity<Object>(map, status);
	}

	public static ResponseEntity<Object> generateErrorResponse(Object response, APIError error) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("errorCode", error.getErrorCode());
		map.put("errorMessage", error.getErrorMessage());
		map.put("status", error.getStatus().value());
		map.put("data", response);

		return new ResponseEntity<Object>(map, error.getStatus());
	}

}
