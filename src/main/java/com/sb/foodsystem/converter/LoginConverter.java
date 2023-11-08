package com.sb.foodsystem.converter;

import org.springframework.stereotype.Component;

import com.sb.foodsystem.entity.Login;
import com.sb.foodsystem.model.LoginDTO;

@Component
public class LoginConverter {

    public LoginDTO entityToDto(Login login) 
    {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setLoginId(login.getLoginId());
        loginDTO.setUsername(login.getUsername());
        loginDTO.setPassword(login.getPassword());
        loginDTO.setUser(login.getUser());
        return loginDTO;
    }

    public Login dtoToEntity(LoginDTO loginDTO)
    {
        Login login = new Login();
        login.setLoginId((loginDTO.getLoginId()));
        login.setUsername(loginDTO.getUsername());
        login.setPassword(loginDTO.getPassword());
        login.setUser(loginDTO.getUser());
        return login;
    }
}