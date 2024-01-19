package com.auth.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sign_up")
public class SignUp {
	
	@Id
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "phone_no")
	private String phoneNo;
	
	@Column(name = "city")
	private String city;

}
