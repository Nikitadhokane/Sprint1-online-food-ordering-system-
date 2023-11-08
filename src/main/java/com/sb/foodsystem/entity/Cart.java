package com.sb.foodsystem.entity;


import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="Cart_Info")
public class Cart {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="Cart_Id")
	private Long cartId;
	
	@Column(name="Quantity")
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
//	@ManyToOne
//	@JoinColumn(name="menu_id")
//	private Menu menu;

    @OneToMany(mappedBy = "cart")
    private List<Menu> menuItems;
	
}


	
    