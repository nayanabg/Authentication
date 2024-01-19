package com.auth.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "login")
public class Login {

	@Id
	@Column(name = "login_id")
	private Long loginId;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "password")
	private String password;
}
