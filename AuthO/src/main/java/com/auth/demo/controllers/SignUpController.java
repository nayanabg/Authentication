package com.auth.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.demo.common.ResponseHandler;
import com.auth.demo.constants.StatusConstants;
import com.auth.demo.request.OnboardUserRequest;
import com.auth.demo.response.OnboardResponse;
import com.auth.demo.response.UserDetailsResponse;
import com.auth.demo.service.SignUpService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/signup")
public class SignUpController {

	@Autowired
	SignUpService signUpService;

	@PostMapping("/user")
	public ResponseEntity<Object> onboardUser(@Valid @RequestBody OnboardUserRequest userRequest) {

		OnboardResponse response = signUpService.signUpUser(userRequest);
		return ResponseHandler.generateResponse(StatusConstants.ONBOARD_SUCCESS.getStatusMessage(), HttpStatus.OK,
				response);

	}

	@GetMapping("/user/{id}")
	public ResponseEntity<Object> getUserById(@PathVariable Long id) {

		UserDetailsResponse response = signUpService.getUserDetailsById(id);
		return ResponseHandler.generateResponse(StatusConstants.USER_FOUND.getStatusMessage(), HttpStatus.OK, response);

	}

	@GetMapping("/user/details")
	public ResponseEntity<Object> getUserDetails() {
		List<UserDetailsResponse> response = signUpService.getUserDetails();
		return ResponseHandler.generateResponse(StatusConstants.USER_FOUND.getStatusMessage(), HttpStatus.OK, response);
	}
}
