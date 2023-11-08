package com.sb.foodsystem.model;



import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import com.sb.foodsystem.entity.Menu;
import com.sb.foodsystem.entity.Order;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderDetailsDTO {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long orderDetails_Id;
	
	@NotNull(message = "Order cannot be null")
    private Order order;

    @NotNull(message = "Menu cannot be null")
    private Menu menu;

    @NotNull(message = "Amount cannot be null")
    @PositiveOrZero(message = "Amount should be a positive number or zero")
    private float amount;

    @NotNull(message = "Total amount cannot be null")
    @PositiveOrZero(message = "Total amount should be a positive number or zero")
    private float totalAmount;

    @NotNull(message = "Quantity cannot be null")
    @Positive(message = "Quantity should be a positive number")
    private int quantity;


}
