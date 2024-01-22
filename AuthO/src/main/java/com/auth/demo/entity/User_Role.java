package com.auth.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_role")
@Getter
@Setter
public class User_Role {
	
	@Id
	private Long id;
	
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "role_id")
	private Long roleId;

}
