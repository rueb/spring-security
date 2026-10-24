package com.jwt.project.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.jwt.project.dto.user.UserDTO;
import com.jwt.project.dto.user.UserResponseDTO;
import com.jwt.project.entities.User;

@Mapper(componentModel = "spring")

public interface UserMapper {

	@Mapping(target = "passwordHash", source = "password")
	User toDomain(UserDTO dto);

	UserResponseDTO toResponseDTO(User user);

}
