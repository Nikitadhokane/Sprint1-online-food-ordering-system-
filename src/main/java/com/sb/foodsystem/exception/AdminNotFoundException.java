package com.sb.foodsystem.exception;

@SuppressWarnings("serial")
public class AdminNotFoundException extends RuntimeException {
    public AdminNotFoundException(String message) {
        super(message);
    }
}
