package com.jwt.project.service.auth;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jwt.project.entities.User;
import com.jwt.project.repository.UserRepository;

import jakarta.transaction.Transactional;
@Service
public class AuthServiceImpl implements AuthService{
	
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	public AuthServiceImpl(UserRepository userRepository,PasswordEncoder passwordEncoder) {
		this.userRepository  = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	@Transactional
	public User register(User user) {
		
		String 	passwordHash = encryptPassword(user.getPasswordHash());
		user.setPasswordHash(passwordHash);
		return userRepository.save(user);
	}

	@Override
	public String encryptPassword(String password) {
		
		return passwordEncoder.encode(password);
	}

}
