package com.app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.app.service.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurity {

	private final UserService userDetailsService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public WebSecurity(UserService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userDetailsService = userDetailsService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	@Bean
	protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
		AuthenticationManagerBuilder authenticationManagerBuilder = 
				http.getSharedObject(AuthenticationManagerBuilder.class);
		authenticationManagerBuilder.userDetailsService(userDetailsService)
			.passwordEncoder(bCryptPasswordEncoder);
		
		
		http.csrf().disable().authorizeHttpRequests().requestMatchers(HttpMethod.POST, "/users")
			.permitAll().anyRequest().authenticated();
		
		return http.build();
	}
	
	/*
	 * protected void configure(AuthenticationManagerBuilder auth) throws Exception{
	 * auth.userDetailsService(this.userDetailsService).passwordEncoder(
	 * bCryptPasswordEncoder); }
	 */
	
	
	
}
