package com.sb.foodsystem.model;

import java.util.List;

import javax.persistence.CascadeType;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sb.foodsystem.entity.Cart;
import com.sb.foodsystem.entity.MenuType;
import com.sb.foodsystem.entity.Restaurant;


import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class MenuDTO {
	
	private Long id;
	
    @NotNull(message = "Item name cannot be null")
    @Size(min = 1, max = 255, message = "Item name must be between 1 and 255 characters")
    private String item;
    
    @NotNull(message = "Price cannot be null")
	private int price;
    
    @NotNull(message = "Quantity cannot be null")
	private int quantity;
    
    private Long restaurantId;
    
    private List<MenuTypeDTO> menuTypes;

    
    
//    @JsonBackReference
//    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
//    private List<MenuType> menuType;
//
//    @JsonBackReference
//    @ManyToOne
//    @JoinColumn(name = "restaurant_id")
//    private Restaurant restaurant;
//    @JsonBackReference
//    @ManyToOne
//	@JoinColumn(name = "restaurant_id")
//	private Restaurant restaurant;

//	 @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
//	 private List<MenuType> menuTypes;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;
}


	


