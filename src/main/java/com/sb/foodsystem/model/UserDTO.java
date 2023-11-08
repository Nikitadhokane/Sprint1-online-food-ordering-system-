package com.sb.foodsystem.model;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sb.foodsystem.entity.MenuType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long user_id;
	
	@NotEmpty(message = "Username cannot be empty")
    @Size(max = 255, message = "Username must be less than or equal to 255 characters")
    private String userName;

    @NotEmpty(message = "Password cannot be empty")
    @Size(min = 8, max = 255, message = "Password must be between 8 and 255 characters")
    private String password;
    
    @JsonBackReference
    @OneToMany(mappedBy = "user")
    private List<MenuType> menuTypes;

}
