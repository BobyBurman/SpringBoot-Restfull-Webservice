package com.javaguides.springboot.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.javaguides.springboot.dto.UserDto;
import com.javaguides.springboot.entity.User;
import com.javaguides.springboot.exception.ErrorDetails;
import com.javaguides.springboot.exception.ResourceNotFoundException;
import com.javaguides.springboot.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
@Tag(
		name="Rest Api Handler Method",
		description = "create - update - get - delete "//swagger use
		)
@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {
	
	private UserService userServiceImpl;
	
	
	//http://localhost:8080/api/users
	@Operation(
			summary = "CREATE",
			description = "createUser"
			)
	@ApiResponse(
			responseCode = "201",  //swagger use
			description = "HHTP STATUS 201"
			)
	@PostMapping
	public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserDto userDto){
		UserDto savedUserDto=userServiceImpl.createUser(userDto);
		return new ResponseEntity<UserDto>(savedUserDto,HttpStatus.CREATED);
	}
	
	//http://localhost:8080/api/users/6
	@GetMapping("{Id}")
	public ResponseEntity<UserDto> getUserId(@PathVariable("Id") Long Id) {
		UserDto getUser=userServiceImpl.getUserById(Id);
		return ResponseEntity.ok(getUser);
	}
	
	//http://localhost:8080/api/users
	@GetMapping()
	public ResponseEntity<List<UserDto>> getAllUser(){
		List<UserDto> userAll=userServiceImpl.findAllUser();
		return new ResponseEntity<List<UserDto>>(userAll,HttpStatus.OK);
	}
	
	//http://localhost:8080/api/users/6
	@PutMapping("{userId}")
	public ResponseEntity<UserDto> updatedUser(@PathVariable("userId") Long userId,@RequestBody @Valid UserDto userDto){
		userDto.setId(userId);
		UserDto updatedUser=userServiceImpl.updatedUserId(userDto);
		return ResponseEntity.ok(updatedUser);
	}
	//http://localhost:8080/api/users/6
	@DeleteMapping("{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
		userServiceImpl.deleteUser(userId);
		return new ResponseEntity<String>("User successfully Deleted !", HttpStatus.OK);
	}
	
	/*
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,WebRequest webRequest){		
		ErrorDetails errorDetails=new ErrorDetails(
				LocalDateTime.now(),
				exception.getMessage(),
				webRequest.getDescription(false),
				"USER_NOT_FOUND"
				);
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.NOT_FOUND);
		
	} */
}
