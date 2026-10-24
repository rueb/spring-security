package com.jwt.project.service.auth;

import com.jwt.project.entities.User;

public interface AuthService {
	
	User register(User user);
	String encryptPassword(String password);

}
