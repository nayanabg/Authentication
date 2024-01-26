package com.auth.demo.service;

import com.auth.demo.request.OnboardUserRequest;
import com.auth.demo.response.OnboardResponse;
import com.auth.demo.response.UserDetailsResponse;

import jakarta.validation.Valid;

public interface SignUpService {

	OnboardResponse signUpUser(@Valid OnboardUserRequest userRequest);

	UserDetailsResponse getUserDetailsById(Long id);



}
