package com.sb.foodsystem.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
@Table(name="Menu_Details")
public class Menu{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	@Column(name="Menu_Id")
    private Long id;
	
	@Column(name="Menu_Name")
    private String item;
	
	@Column(name="Price")
    private int price;
	
	@Column(name="Quantity")
    private int quantity;
		 
	 @ManyToOne
	 @JoinColumn(name = "cart_id")
	 private Cart cart;
	 
	 //@JsonBackReference
	 @ManyToOne
	 @JoinColumn(name = "restaurant_id")
	 private Restaurant restaurant;

	 @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
	 private List<MenuType> menuTypes;
	


	 


    
	
	
    
    
    
    
   

}
