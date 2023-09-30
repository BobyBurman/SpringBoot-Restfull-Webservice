package com.javaguides.springboot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.javaguides.springboot.dto.UserDto;
import com.javaguides.springboot.entity.User;

@Mapper
public interface AutoGenerateUserMapper {
	
	AutoGenerateUserMapper MAPPER=Mappers.getMapper(AutoGenerateUserMapper.class);
	
	//@Mapping(source = "email", target = "emailAddress")
	public User convertToUser(UserDto userDto);
	
	public UserDto convertToUserDto(User user);
	
	

}
