package com.auth.demo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth.demo.entity.SignUp;
import com.auth.demo.entity.UserRole;
import com.auth.demo.repo.SignUpRepo;
import com.auth.demo.request.OnboardUserRequest;
import com.auth.demo.response.OnboardResponse;
import com.auth.demo.service.SignUpService;

import jakarta.validation.Valid;

@Service
public class SignUpServiceImpl implements SignUpService {

	@Autowired
	SignUpRepo signUpRepo;
	

	Logger log = LoggerFactory.getLogger(SignUpService.class);

	@Override
	public OnboardResponse signUpUser(@Valid OnboardUserRequest userRequest) {

		log.info("Onboard request incoming : " + userRequest.toString());

		SignUp user = new SignUp();
		user.setFirstName(userRequest.getFirstName());
		user.setLastName(userRequest.getLastName());
		user.setPassword(userRequest.getPassword());
		user.setCity(userRequest.getCity());
		user.setPhoneNo(userRequest.getPhoneNo());
		signUpRepo.save(user);

		log.info("New user onboarded : " + user.getUserId());
		
		UserRole userRole = new UserRole();
		userRole.setUserId(user.getUserId());
		userRole.setRoleId(1L);
		
		OnboardResponse response = new OnboardResponse();
		response.setUserId(user.getUserId());
		response.setUserName(user.getFirstName() + " " + user.getLastName());

		return response;
	}

}
