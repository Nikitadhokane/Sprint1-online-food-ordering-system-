package com.sb.foodsystem.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sb.foodsystem.entity.Menu;

import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class RestaurantDTO {

	private Long id;
	
    @NotEmpty(message = "Name cannot be empty")
	@Size(max = 255, message = "Name must be less than or equal to 255 characters")
	private String name;

    @NotEmpty(message = "Address cannot be empty")
	private String address;

	@NotEmpty(message = "Contact cannot be empty")
	@Size(max = 20, message = "Contact must be less than or equal to 20 characters")
	private String contact;

	@NotEmpty(message = "Email cannot be empty")
	@Email(message = "Email should be valid")
	private String email;

	@NotEmpty(message = "Opening hours cannot be empty")
	private String openingHours;
	
	//@JsonManagedReference
	@OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Menu> menus;

}
