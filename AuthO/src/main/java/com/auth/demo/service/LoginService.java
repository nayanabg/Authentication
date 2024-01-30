package com.auth.demo.service;

import com.auth.demo.request.LoginRequest;
import com.auth.demo.response.LoginResponse;

import jakarta.validation.Valid;

public interface LoginService {

	LoginResponse loginUser(@Valid LoginRequest userRequest);

}
