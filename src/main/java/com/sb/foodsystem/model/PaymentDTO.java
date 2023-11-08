package com.sb.foodsystem.model;


import java.sql.Time;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.sb.foodsystem.entity.Order;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PaymentDTO {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull(message = "Order cannot be null")
    private Order order;

    @NotNull(message = "Amount cannot be null")
    @Positive(message = "Amount should be a positive number")
    private int amount;

    @NotNull(message = "Time cannot be null")
    private Time time;
}
