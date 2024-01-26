package com.auth.demo.common;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Map;

public class ResponseHandler {

	public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object response) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", message);
		map.put("status", status.value());
		map.put("data", response);

		return new ResponseEntity<Object>(map, status);
	}

}
