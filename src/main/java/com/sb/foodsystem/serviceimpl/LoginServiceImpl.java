package com.sb.foodsystem.serviceimpl;


import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.foodsystem.converter.LoginConverter;
import com.sb.foodsystem.dao.LoginRepository;
import com.sb.foodsystem.dao.UserRepository;
import com.sb.foodsystem.entity.Login;
import com.sb.foodsystem.entity.User;
import com.sb.foodsystem.model.LoginDTO;
import com.sb.foodsystem.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

    private final LoginRepository loginRepository;
    private final UserRepository userRepository;
    
    @Autowired
    private LoginConverter loginConverter;

    public LoginServiceImpl(LoginRepository loginRepository, UserRepository userRepository) {
        this.loginRepository = loginRepository;
        this.userRepository = userRepository;
    }

    @Override
    public LoginDTO createLogin(LoginDTO loginDTO) {
        // convert LoginDTO to Login entity
        Login login = loginConverter.dtoToEntity(loginDTO);

        // create a new User entity and set its properties
        User user = new User();
        user.setPassword(loginDTO.getPassword());
        user.setUserName(loginDTO.getUsername());

        // save the User entity first
        userRepository.save(user);

        // set the User entity in the Login entity
        login.setUser(user);

        // save the Login entity
        login = loginRepository.save(login);

        return loginConverter.entityToDto(login);
    }

    @Override
    public LoginDTO getLoginById(Long id) {
        Optional<Login> loginOptional = loginRepository.findById(id);
        if (loginOptional.isPresent()) {
            return loginConverter.entityToDto(loginOptional.get());
        } else {
            throw new NoSuchElementException("Login not found with id: " + id);
        }
    }

    @Override
    public LoginDTO updateLogin(Long id, LoginDTO loginDTO) {
        Optional<Login> loginOptional = loginRepository.findById(id);
        if (loginOptional.isPresent()) {
            Login login = loginOptional.get();
            // Update the properties of the Login entity using the values from the LoginDTO
            login.setUsername(loginDTO.getUsername());
            login.setPassword(loginDTO.getPassword());

            // Assuming you have a userRepository, you can update the associated User entity as well
            Optional<User> userOptional = userRepository.findById(login.getUser().getUser_id());
            if (userOptional.isPresent()) {
                User user = userOptional.get();
                user.setUserName(loginDTO.getUsername());
                user.setPassword(loginDTO.getPassword());
                userRepository.save(user);
            }

            // Save the updated Login entity
            login = loginRepository.save(login);
            return loginConverter.entityToDto(login);
        } else {
            throw new NoSuchElementException("Login not found with id: " + id);
        }
    }}