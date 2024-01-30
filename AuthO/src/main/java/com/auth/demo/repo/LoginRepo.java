package com.auth.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auth.demo.entity.Login;

@Repository
public interface LoginRepo extends JpaRepository<Login, Long> {

	Login findByUserNameAndPassword(String userName, String password);

}
