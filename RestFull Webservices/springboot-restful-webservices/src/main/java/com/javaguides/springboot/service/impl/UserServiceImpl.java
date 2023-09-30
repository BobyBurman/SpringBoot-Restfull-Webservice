package com.javaguides.springboot.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.javaguides.springboot.dto.UserDto;
import com.javaguides.springboot.entity.User;
import com.javaguides.springboot.exception.EmailAlreadyExistsException;
import com.javaguides.springboot.exception.ResourceNotFoundException;
import com.javaguides.springboot.mapper.AutoGenerateUserMapper;
import com.javaguides.springboot.mapper.UserMapper;
import com.javaguides.springboot.repository.UserRepository;
import com.javaguides.springboot.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepo;

	private ModelMapper modelMapper;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		
		//convert dto to jpa
		//User user=UserMapper.convertToUserJpa(userDto);
		
		//User user=modelMapper.map(userDto, User.class);
		
		Optional<User> userEmail=userRepo.findByEmail(userDto.getEmail());
		
		if(userEmail.isPresent()) {
			throw new EmailAlreadyExistsException(userEmail.get().getEmail()+" : This email already exist");
		}
		
		User user=AutoGenerateUserMapper.MAPPER.convertToUser(userDto);
		
		User savedUser=userRepo.save(user);
		
		//convert jpa to dto
		//UserDto savedUserDto=UserMapper.convertToUserDto(savedUser);
		
		//UserDto savedUserDto=modelMapper.map(savedUser, UserDto.class);
		
		UserDto savedUserDto=AutoGenerateUserMapper.MAPPER.convertToUserDto(savedUser);
		
		return savedUserDto;
	}

	@Override
	public UserDto getUserById(Long id) {
		
		//Optional<User> optionalUser=userRepo.findById(id);	
		 User user=userRepo.findById(id).orElseThrow(
				 ()->new ResourceNotFoundException("user","id", id)
				 );	
		
		//UserDto getUserDto=UserMapper.convertToUserDto(optionalUser.get());
		
		//UserDto getUserDto=modelMapper.map(optionalUser.get(), UserDto.class);
		
		//UserDto getUserDto=AutoGenerateUserMapper.MAPPER.convertToUserDto(optionalUser.get());
		 UserDto getUserDto=AutoGenerateUserMapper.MAPPER.convertToUserDto(user);
		
		return getUserDto;
	}

	@Override
	public List<UserDto> findAllUser() {
		
		List<User> getAllUser=userRepo.findAll();
		
	/*  List<UserDto> getAllUserDto=new ArrayList<UserDto>();
		for(User u:getAllUser) {
			UserDto userDto=UserMapper.convertToUserDto(u);
			getAllUserDto.add(userDto);
		}
		return getAllUserDto ; */
		
		//return getAllUser.stream().map(UserMapper::convertToUserDto).collect(Collectors.toList());
		
		//return getAllUser.stream().map((user)-> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
		
		return getAllUser.stream().map((user)-> AutoGenerateUserMapper.MAPPER.convertToUserDto(user)).collect(Collectors.toList());
	}

	@Override
	public UserDto updatedUserId(UserDto userDto) {
		
		//User existingUser=userRepo.findById(userDto.getId()).get();
		
		User existingUser=userRepo.findById(userDto.getId()).orElseThrow(
				()->new ResourceNotFoundException("user", "id",userDto.getId())
				);
		
		existingUser.setFirstName(userDto.getFirstName());
		existingUser.setLastName(userDto.getLastName());
		existingUser.setEmail(userDto.getEmail());
		
		User updatedUser=userRepo.save(existingUser);
		
		//return UserMapper.convertToUserDto(updatedUser);
		//return modelMapper.map(updatedUser, UserDto.class);
		return AutoGenerateUserMapper.MAPPER.convertToUserDto(updatedUser);
	}

	@Override
	public void deleteUser(Long userId) {

		User existingUser=userRepo.findById(userId).orElseThrow(
				()->new ResourceNotFoundException("user", "id",userId)
				);
		
		userRepo.deleteById(userId);
		
	}

}
