package com.auth.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.demo.Common.ResponseHandler;
import com.auth.demo.request.OnboardUserRequest;
import com.auth.demo.response.OnboardResponse;
import com.auth.demo.service.SignUpService;
import com.auth.demo.utility.StatusConstants;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/signup")
public class SignUpController {
	
	@Autowired
	SignUpService signUpService;
	
	@PostMapping("/user")
	public ResponseEntity<Object> onboardUser(@Valid @RequestBody OnboardUserRequest userRequest){
		OnboardResponse response = signUpService.signUpUser(userRequest);	
		return ResponseHandler.generateResponse(StatusConstants.ONBOARD_SUCCESS.getStatusMessage(), HttpStatus.OK, response, null);
	}

}
