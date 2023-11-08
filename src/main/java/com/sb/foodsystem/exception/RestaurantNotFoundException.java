package com.sb.foodsystem.exception;

@SuppressWarnings("serial")
public class RestaurantNotFoundException extends RuntimeException {
    public RestaurantNotFoundException(String message) 
    {
        super(message);
    }
}