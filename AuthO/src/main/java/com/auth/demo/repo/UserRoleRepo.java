package com.auth.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auth.demo.entity.UserRole;

@Repository
public interface UserRoleRepo extends JpaRepository<UserRole, Long> {
	
}
