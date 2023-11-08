package com.sb.foodsystem.service;

import java.util.List;

import com.sb.foodsystem.model.RestaurantDTO;

public interface RestaurantService {

    RestaurantDTO createRestaurant(RestaurantDTO restaurantDTO);

    RestaurantDTO getRestaurantById(Long id);

    RestaurantDTO updateRestaurant(Long id, RestaurantDTO restaurantDTO);

    String deleteRestaurant(Long id);

	List<RestaurantDTO> getAllrestaurants();
}