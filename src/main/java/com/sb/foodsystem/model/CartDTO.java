package com.sb.foodsystem.model;

import java.util.List;

//import javax.persistence.ManyToOne;
//import javax.validation.constraints.NotNull;
//
//import com.sb.foodsystem.entity.Menu;
//import com.sb.foodsystem.entity.User;

import lombok.AllArgsConstructor;
//import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor(staticName="build")
//public class CartDTO {
//	
//	private Long id;
//	
//	@NotNull
//	private int quantity;
//	
//	@NotNull(message = "User cannot be null")
//	@ManyToOne
//	private User user;
//	
//	@NotNull(message = "Menu cannot be null")
//	private Menu menu;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CartDTO {
	
	
    private Long cartId ;
    private int quantity;
    private Long userId ;
    private List<MenuDTO> menus;

   
}
	

