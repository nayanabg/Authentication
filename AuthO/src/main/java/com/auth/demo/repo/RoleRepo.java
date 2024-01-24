package com.auth.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auth.demo.entity.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {

	Role findByRoleId(Long roleId);

}
