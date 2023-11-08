package com.sb.foodsystem.converter;

import org.springframework.stereotype.Component;

import com.sb.foodsystem.entity.User;
import com.sb.foodsystem.model.UserDTO;

@Component
public class UserConverter {

    public UserDTO entityToDto(User user)
    {
        UserDTO userDTO = new UserDTO();
        userDTO.setUser_id(user.getUser_id());
        userDTO.setPassword(user.getPassword());
        userDTO.setUserName(user.getUserName());
//        userDTO.setEmail(user.getEmail());
//        userDTO.setAddress(user.getAddress());
//        userDTO.setContact(user.getContact());
        return userDTO;
    }

    public User dtoToEntity(UserDTO userDTO)
    {
        User user = new User();
        user.setUser_id(userDTO.getUser_id());
        user.setPassword(userDTO.getPassword());
        user.setUserName(userDTO.getUserName());
//        user.setEmail(userDTO.getEmail());
//        user.setAddress(userDTO.getAddress());
//        user.setContact(userDTO.getContact());
        return user;
    }
}