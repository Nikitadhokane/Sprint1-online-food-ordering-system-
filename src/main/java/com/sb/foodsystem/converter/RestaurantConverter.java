package com.sb.foodsystem.converter;

import org.springframework.stereotype.Component;

import com.sb.foodsystem.entity.Restaurant;
import com.sb.foodsystem.model.RestaurantDTO;

@Component
public class RestaurantConverter {

    public RestaurantDTO entityToDto(Restaurant restaurant) {
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        restaurantDTO.setId(restaurant.getId());
        restaurantDTO.setName(restaurant.getName());
        restaurantDTO.setAddress(restaurant.getAddress());
        restaurantDTO.setContact(restaurant.getContact());
        restaurantDTO.setEmail(restaurant.getEmail());
        restaurantDTO.setOpeningHours(restaurant.getOpeningHours());
        return restaurantDTO;
    }

    public Restaurant dtoToEntity(RestaurantDTO restaurantDTO) {
        Restaurant restaurant = new Restaurant();
        restaurant.setId(restaurantDTO.getId());
        restaurant.setName(restaurantDTO.getName());
        restaurant.setAddress(restaurantDTO.getAddress());
        restaurant.setContact(restaurantDTO.getContact());
        restaurant.setEmail(restaurantDTO.getEmail());
        restaurant.setOpeningHours(restaurantDTO.getOpeningHours());
        return restaurant;
    }
}