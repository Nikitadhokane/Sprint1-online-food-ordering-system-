package com.sb.foodsystem.model;


import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.sb.foodsystem.entity.Restaurant;
import com.sb.foodsystem.entity.User;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderDTO {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;
	
	@NotNull(message = "User cannot be null")
    private User user;

    @NotNull(message = "Restaurant cannot be null")
    private Restaurant restaurant;

    @NotNull(message = "Order date cannot be null")
    private Date orderDate;

    @NotNull(message = "Total amount cannot be null")
    @Positive(message = "Total amount should be a positive number")
    private int totalAmount;

    @NotNull(message = "User ID cannot be null")
    private Long userId;

    @NotNull(message = "Status cannot be null")
    private String status;

}
