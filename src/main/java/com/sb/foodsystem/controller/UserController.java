package com.sb.foodsystem.controller;

import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb.foodsystem.entity.User;
import com.sb.foodsystem.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public String validate(@RequestBody User user) throws ServletException
	{
		String jwtToken="";
		
		if(user.getUserName()==null || user.getPassword()==null)
		{
			throw new ServletException("Please Fill in Username and Password");
		}
		
		String userName=user.getUserName();
		String password=user.getPassword();
		//will check in database whether the login and password is present or not
		user=userService.login(userName, password);
		
		if(user==null)
		{
			throw new ServletException("User not found");
		}
		
		jwtToken=Jwts.builder().setSubject(userName).claim("userName", user.getUserName()).
			setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "secretkey").compact();
		
		return jwtToken;
		
		
	}
	
}
