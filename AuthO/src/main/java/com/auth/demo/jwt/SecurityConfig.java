package com.auth.demo.jwt;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.auth.demo.repo.LoginRepo;

import jakarta.servlet.http.HttpServletResponse;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration {

	private LoginRepo userRepo;
	private JwtTokenFilter jwtTokenFilter;

	public SecurityConfig(LoginRepo userRepo) {
		this.jwtTokenFilter = jwtTokenFilter;
		this.userRepo = userRepo;
	}

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(username -> userRepo.findByUserName(username));
	}

	protected void configure(HttpSecurity http) throws Exception {

		// Enable CORS and disable CSRF and Set permissions on endpoints
		http = http.cors(AbstractHttpConfigurer::disable).csrf(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests(request -> {
					request.requestMatchers("/signup").permitAll().requestMatchers("/login").permitAll().anyRequest()
							.authenticated();
				});

		// Set session management to stateless
		http = http.sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

		// Set unauthorized requests exception handler
		http = http.exceptionHandling(e -> e.authenticationEntryPoint(
				(request, response, ex) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage())));

		// Add JWT token filter
		/*
		 * Please note that we added the JwtTokenFilter before the Spring Security
		 * internal UsernamePasswordAuthenticationFilter. We’re doing this because we
		 * need access to the user identity at this point to perform
		 * authentication/authorization, and its extraction happens inside the JWT token
		 * filter based on the provided JWT token.
		 */

		http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// Used by Spring Security if CORS is enabled.
	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}

	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return this.authenticationManagerBean();
	}

}
