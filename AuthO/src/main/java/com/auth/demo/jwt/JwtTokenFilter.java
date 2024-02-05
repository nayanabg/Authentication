package com.auth.demo.jwt;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth.demo.repo.LoginRepo;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.*;

public class JwtTokenFilter extends OncePerRequestFilter {

	private JwtTokenUtil jwtTokenUtil;
	private LoginRepo loginRepo;

	JwtTokenFilter(JwtTokenUtil jwtTokenUtil, LoginRepo loginRepo) {
		this.jwtTokenUtil = jwtTokenUtil;
		this.loginRepo = loginRepo;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// Get authorization header and validate
		final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
		if ((header.isEmpty() || !header.startsWith("Bearer "))) {
			filterChain.doFilter(request, response);
			return;
		}

		// Get jwt token
		final String token = header.split(" ")[1].trim();

		// Get user identity and set it on the spring security context
		UserDetails userDetails = loginRepo.findByUserName(jwtTokenUtil.getUsernameFromToken(token));

		// jwt token validate
		if (!jwtTokenUtil.validateToken(token, userDetails)) {
			filterChain.doFilter(request, response);
			return;
		}

		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null,
				userDetails == null ? List.of() : userDetails.getAuthorities());

		authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		filterChain.doFilter(request, response);
	}

}
