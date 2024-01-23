package com.auth.demo.service;

import com.auth.demo.request.OnboardUserRequest;
import com.auth.demo.response.OnboardResponse;

import jakarta.validation.Valid;

public interface SignUpService {

	OnboardResponse signUpUser(@Valid OnboardUserRequest userRequest);



}
