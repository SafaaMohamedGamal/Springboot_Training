package com.app.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.app.shared.dto.UserDto;

public interface UserService extends UserDetailsService {

	UserDto createUser(UserDto user);
}
