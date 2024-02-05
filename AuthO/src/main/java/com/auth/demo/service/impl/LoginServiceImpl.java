package com.auth.demo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth.demo.entity.Login;
import com.auth.demo.exceptions.UserDetailsIncorrectException;
import com.auth.demo.jwt.JwtTokenUtil;
import com.auth.demo.repo.LoginRepo;
import com.auth.demo.request.LoginRequest;
import com.auth.demo.response.LoginResponse;
import com.auth.demo.service.LoginService;
import com.auth.demo.utils.PasswordEncoder;

import jakarta.validation.Valid;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepo loginRepo;

	private PasswordEncoder passwordEncoder;

	private JwtTokenUtil jwtTokenUtil;

	Logger log = LoggerFactory.getLogger(LoginService.class);

	@Override
	public LoginResponse loginUser(@Valid LoginRequest userRequest) {

		jwtTokenUtil = new JwtTokenUtil();
		log.info("login requested");
		Login user = loginRepo.findByUserNameAndPassword(userRequest.getUserName(), userRequest.getPassword());

		passwordEncoder = new PasswordEncoder();

		LoginResponse response = new LoginResponse();
		if (user != null && user.getUserName() != null && user.getPassword() != null) {
			response.setToken(jwtTokenUtil.generateToken(user));
			response.setUserName(userRequest.getUserName());
			response.setPassword(passwordEncoder.encodePassword(userRequest.getPassword()));
		} else {
			throw new UserDetailsIncorrectException("User details incorrect");
		}

		return response;
	}

}
