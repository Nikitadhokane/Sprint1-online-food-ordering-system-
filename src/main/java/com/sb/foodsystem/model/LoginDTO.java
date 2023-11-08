package com.sb.foodsystem.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.sb.foodsystem.entity.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDTO {
	
	private Long loginId;
	
	@NotBlank(message = "Username must not be blank")
	private String username;
	
	@NotBlank(message = "Password must not be blank")
	private String password;
	
	@NotNull(message = "User cannot be null")
	private User user;

}
