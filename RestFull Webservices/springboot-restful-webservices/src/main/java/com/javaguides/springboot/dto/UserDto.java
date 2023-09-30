package com.javaguides.springboot.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Schema
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	
	private Long id;
	
	//first name should not be empty
	
	@Schema(
			description = "User First Name"   //swagger use
			)
	@NotEmpty(message="first name should not be empty")
	private String firstName;
	
	//last name should not be empty
	@NotEmpty(message="last name should not be empty")
	private String lastName;
	
	//email should not be empty 
	//email should be valid
	@NotEmpty(message="email should not be empty")
	@Email(message="email should be valid & well formated")
	private String email;
	

}
