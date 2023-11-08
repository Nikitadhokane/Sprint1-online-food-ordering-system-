package com.sb.foodsystem.service;

import com.sb.foodsystem.model.LoginDTO;

public interface LoginService {

    LoginDTO createLogin(LoginDTO loginDTO);

    LoginDTO getLoginById(Long id);

	LoginDTO updateLogin(Long id, LoginDTO loginDTO);

   // LoginDTO updateLogin(Long id, LoginDTO loginDTO);

    
}