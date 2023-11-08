package com.sb.foodsystem.model;

import javax.persistence.ManyToOne;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.sb.foodsystem.entity.Menu;
import com.sb.foodsystem.entity.User;

//import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.sb.foodsystem.entity.Menu;
//import com.sb.foodsystem.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuTypeDTO {


	    private Long id;

	    @NotNull(message = "Type name cannot be null")
	    @Size(min = 1, max = 255, message = "Type name must be between 1 and 255 characters")
	    private String type_name;

	    @Size(max = 255, message = "Description can be at most 255 characters")
	    private String description;
	    
	    @NotNull(message = "User cannot be null")
	    private User user;
	    
	    @NotNull(message = "Menu cannot be null")
	    private Menu menu;
}
