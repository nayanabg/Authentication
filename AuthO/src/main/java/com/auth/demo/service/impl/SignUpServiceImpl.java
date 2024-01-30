package com.auth.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth.demo.constants.RoleConstants;
import com.auth.demo.entity.Login;
import com.auth.demo.entity.Role;
import com.auth.demo.entity.SignUp;
import com.auth.demo.entity.UserRole;
import com.auth.demo.repo.LoginRepo;
import com.auth.demo.repo.RoleRepo;
import com.auth.demo.repo.SignUpRepo;
import com.auth.demo.repo.UserRoleRepo;
import com.auth.demo.request.OnboardUserRequest;
import com.auth.demo.response.OnboardResponse;
import com.auth.demo.response.UserDetailsResponse;
import com.auth.demo.service.SignUpService;

import jakarta.validation.Valid;

@Service
public class SignUpServiceImpl implements SignUpService {

	@Autowired
	SignUpRepo signUpRepo;

	@Autowired
	RoleRepo roleRepo;

	@Autowired
	UserRoleRepo userRoleRepo;

	@Autowired
	LoginRepo loginRepo;

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
		userRole.setRoleId((long) RoleConstants.USER.getRoleId());
		userRoleRepo.save(userRole);

		Role role = roleRepo.findRoleByRoleId(userRole.getRoleId());

		OnboardResponse response = new OnboardResponse();
		response.setUserId(user.getUserId());
		response.setUserName(user.getFirstName() + " " + user.getLastName());
		response.setRoleName(role.getRoleName());

		log.info("Register user details for login purpose ");

		String userName = user.getFirstName() + " " + user.getLastName();
		
		Login login = new Login();
		login.setUserName(userName.trim());
		login.setPassword(user.getPassword());
		loginRepo.save(login);

		return response;
	}

	@Override
	public UserDetailsResponse getUserDetailsById(Long id) {

		SignUp user = signUpRepo.findByUserId(id);
		UserRole userRole = userRoleRepo.findRoleByUserId(user.getUserId());
		Role role = roleRepo.findRoleByRoleId(userRole.getRoleId());

		UserDetailsResponse response = new UserDetailsResponse(user.getFirstName() + " " + user.getLastName(),
				user.getPhoneNo(), user.getCity(), role.getRoleName());
		return response;
	}

	@Override
	public List<UserDetailsResponse> getUserDetails() {

		List<SignUp> usersList = signUpRepo.findAll();
		List<UserDetailsResponse> usersDetailsList = new ArrayList<>();

		for (SignUp user : usersList) {

			UserRole userRole = userRoleRepo.findRoleByUserId(user.getUserId());
			Role role = roleRepo.findRoleByRoleId(userRole.getRoleId());
			UserDetailsResponse response = new UserDetailsResponse(user.getFirstName() + " " + user.getLastName(),
					user.getPhoneNo(), user.getCity(), role.getRoleName());
			usersDetailsList.add(response);
		}

		return usersDetailsList;
	}

}
