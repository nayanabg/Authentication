package com.auth.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auth.demo.entity.SignUp;

@Repository
public interface SignUpRepo extends JpaRepository<SignUp, Long> {

	SignUp findByUserId(Long id);

}
