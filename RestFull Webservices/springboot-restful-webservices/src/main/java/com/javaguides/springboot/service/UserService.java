package com.javaguides.springboot.service;

import java.util.List;

import com.javaguides.springboot.dto.UserDto;
import com.javaguides.springboot.entity.User;

public interface UserService {
	
	public UserDto createUser(UserDto userDto);
	
	public UserDto getUserById(Long id);
	
	public List<UserDto> findAllUser();
	
	public UserDto updatedUserId(UserDto userDto);
	
	public void deleteUser(Long userId);

}
