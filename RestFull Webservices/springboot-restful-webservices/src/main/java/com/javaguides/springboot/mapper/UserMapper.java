package com.javaguides.springboot.mapper;

import com.javaguides.springboot.dto.UserDto;
import com.javaguides.springboot.entity.User;

public class UserMapper {
	
	//convert to user dto from jpa entitry
	public static UserDto convertToUserDto(User user) {
		
		UserDto userDto=new UserDto(
				user.getId(),
				user.getFirstName(),
				user.getLastName(),
				user.getEmail()
				);
		return userDto;
	}
	
	//convert jpa entity from user dto
	
	public static User convertToUserJpa(UserDto userDto) {
		
		User user=new User(
				userDto.getId(),
				userDto.getFirstName(),
				userDto.getLastName(),
				userDto.getEmail()
				);
		return user;
	}

}
