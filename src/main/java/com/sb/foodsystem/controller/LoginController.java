package com.sb.foodsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb.foodsystem.converter.LoginConverter;
import com.sb.foodsystem.model.LoginDTO;
import com.sb.foodsystem.service.LoginService;

@RestController
//@RequestMapping("/login")
@RequestMapping("/api/login")
public class LoginController {

	@Autowired
    private LoginService loginService;
	
	@SuppressWarnings("unused")
	@Autowired
	private LoginConverter loginConverter;

    @PostMapping("/create/login")
    public LoginDTO createLogin(@RequestBody LoginDTO loginDTO)
    {
        return loginService.createLogin(loginDTO);
    }

    @GetMapping("/login/{id}")
    public LoginDTO getLoginById(@PathVariable Long id)
    {
        return loginService.getLoginById(id);
    }

    @PutMapping("/login/{id}")
    public LoginDTO updateLogin(@PathVariable Long id, @RequestBody LoginDTO loginDTO) 
    {
        return loginService.updateLogin(id, loginDTO);
    }

	 


	
}
