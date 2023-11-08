package com.sb.foodsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb.foodsystem.converter.RestaurantConverter;
import com.sb.foodsystem.model.RestaurantDTO;
import com.sb.foodsystem.service.RestaurantService;

@RestController
//@RequestMapping("/restaurants")
@RequestMapping("/api/restaurants")
public class RestaurantController {

	@Autowired
    private final RestaurantService restaurantService;
	
	@SuppressWarnings("unused")
	@Autowired
    private final RestaurantConverter restaurantConverter;

    
    public RestaurantController(RestaurantService restaurantService, RestaurantConverter restaurantConverter)
    {
        this.restaurantService = restaurantService;
        this.restaurantConverter = restaurantConverter;
    }

    @PostMapping("/restaurants")
    public ResponseEntity<RestaurantDTO> createRestaurant(@RequestBody RestaurantDTO restaurantDTO) 
    {
        RestaurantDTO createdRestaurant = restaurantService.createRestaurant(restaurantDTO);
        return new ResponseEntity<>(createdRestaurant, HttpStatus.CREATED);
    }
    
    @GetMapping("/getAllrestaurants")
	public List<RestaurantDTO> getAllrestaurants()
	{
		return restaurantService.getAllrestaurants();
	}

    @GetMapping("/restaurants/{id}")
    public ResponseEntity<RestaurantDTO> getRestaurantById(@PathVariable Long id) 
    {
        RestaurantDTO restaurant = restaurantService.getRestaurantById(id);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @PutMapping("/restaurants/{id}")
    public ResponseEntity<RestaurantDTO> updateRestaurant(@PathVariable Long id, @RequestBody RestaurantDTO restaurantDTO)
    {
        RestaurantDTO updatedRestaurant = restaurantService.updateRestaurant(id, restaurantDTO);
        return new ResponseEntity<>(updatedRestaurant, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String deleteRestaurant(@PathVariable Long id) 
    {
        return restaurantService.deleteRestaurant(id);
    }
}
