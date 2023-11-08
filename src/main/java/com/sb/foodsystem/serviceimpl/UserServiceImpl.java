package com.sb.foodsystem.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.foodsystem.converter.UserConverter;
import com.sb.foodsystem.dao.UserRepository;
import com.sb.foodsystem.entity.User;
import com.sb.foodsystem.model.UserDTO;
import com.sb.foodsystem.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
    private UserRepository userRepository;
	
	@Autowired
    private UserConverter userConverter;

    public UserServiceImpl(UserRepository userRepository, UserConverter userConverter) 
    {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }
    public void saveUser(User user)
    {
        userRepository.save(user);
    }

    @Override
    public UserDTO createUser(UserDTO userDTO)
    {
        User user = userConverter.dtoToEntity(userDTO);
        user = userRepository.save(user);
        return userConverter.entityToDto(user);
    }

    @Override
    public UserDTO getUserById(Long id)
    {
        User user = userRepository.findById(id).orElse(null);
        return userConverter.entityToDto(user);
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) 
    {
        User user = userConverter.dtoToEntity(userDTO);
        user.setUser_id(id); // Assuming userId is part of the UserDTO
        user = userRepository.save(user);
        return userConverter.entityToDto(user);
    }

    @Override
    public String deleteUser(Long id) 
    {
        userRepository.deleteById(id);
        return "User with ID " + id + " has been deleted successfully.";
    }

	@Override
	public User login(String userName, String password)
	{
		User user = userRepository.findByUserNameAndPassword(userName, password);
		return user;
	}
	

}