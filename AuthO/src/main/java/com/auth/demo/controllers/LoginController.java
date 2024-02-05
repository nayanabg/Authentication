package com.auth.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.demo.common.ResponseHandler;
import com.auth.demo.constants.StatusConstants;
import com.auth.demo.request.LoginRequest;
import com.auth.demo.response.LoginResponse;
import com.auth.demo.service.LoginService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(("/login"))
public class LoginController {

	@Autowired
	private LoginService loginService;

	@PostMapping
	public ResponseEntity<Object> loginUser(@Valid @RequestBody LoginRequest userRequest) {

		LoginResponse response = loginService.loginUser(userRequest);
		return ResponseHandler.generateResponse(StatusConstants.LOGIN_SUCCESS.getStatusMessage(), HttpStatus.OK,
				response);

	}

}
