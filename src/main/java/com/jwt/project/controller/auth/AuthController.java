package com.jwt.project.controller.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.project.dto.ApiResponse;
import com.jwt.project.dto.user.UserDTO;
import com.jwt.project.dto.user.UserResponseDTO;
import com.jwt.project.entities.User;
import com.jwt.project.mapper.UserMapper;
import com.jwt.project.service.auth.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	private  final   AuthService authService;
	private final  UserMapper userMapper;
	
	public AuthController(AuthService authService,UserMapper userMapper) {
		this.authService = authService;
		this.userMapper = userMapper;
	}
	
	
	@PostMapping("/register")
	public ResponseEntity<ApiResponse<UserResponseDTO>>create(@RequestBody UserDTO dto){
		
		User user = userMapper.toDomain(dto);
		User newUser = authService.register(user);
		
		UserResponseDTO userResponseDTO = userMapper.toResponseDTO(newUser);
		ApiResponse<UserResponseDTO>response = new ApiResponse<UserResponseDTO>(true, "usuario creado correctament", 201, userResponseDTO);
		return ResponseEntity.status(HttpStatus.CREATED.value()).body(response);
	}

}

