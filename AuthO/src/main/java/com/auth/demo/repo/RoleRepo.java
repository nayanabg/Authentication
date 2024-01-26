package com.auth.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auth.demo.entity.Role;

public interface RoleRepo extends JpaRepository<Role, Long>{

	Role findRoleByRoleId(Long roleId);	

}
