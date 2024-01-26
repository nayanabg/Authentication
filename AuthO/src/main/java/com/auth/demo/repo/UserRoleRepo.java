package com.auth.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auth.demo.entity.UserRole;

public interface UserRoleRepo extends JpaRepository<UserRole, Long> {

	UserRole findRoleByUserId(Long userId);

}
