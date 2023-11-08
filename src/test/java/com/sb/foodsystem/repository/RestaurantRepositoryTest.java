package com.sb.foodsystem.repository;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sb.foodsystem.dao.RestaurantRepository;
import com.sb.foodsystem.entity.Restaurant;

@SpringBootTest
public class RestaurantRepositoryTest {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Test
    public void testCreateRestaurant() {
        Restaurant restaurant = new Restaurant();
        restaurant.setName("Sample Restaurant");
        restaurant.setAddress("123 Main St, City");
        restaurant.setContact("123-456-7890");
        restaurant.setEmail("info@samplerestaurant.com");
        restaurant.setOpeningHours("9 AM - 10 PM");

        Restaurant savedRestaurant = restaurantRepository.save(restaurant);

        assertNotNull(savedRestaurant.getId());
    }
    
    @Test
    public void testSaveRestaurant() {
        // Create a sample restaurant
        Restaurant restaurant = new Restaurant();
        restaurant.setName("Sample Restaurant");
        restaurant.setAddress("123 Main St, City");
        restaurant.setContact("123-456-7890");
        restaurant.setEmail("info@samplerestaurant.com");
        restaurant.setOpeningHours("9 AM - 10 PM");

        // Save the restaurant
        Restaurant savedRestaurant = restaurantRepository.save(restaurant);

        // Assert that the saved restaurant has an ID
        assertNotNull(savedRestaurant.getId());
    }

    @Test
    public void testFindRestaurantById() {
        // Create and save a restaurant
        Restaurant restaurant = new Restaurant();
        restaurant.setName("Sample Restaurant");
        restaurant.setAddress("123 Main St, City");
        restaurant.setContact("123-456-7890");
        restaurant.setEmail("info@samplerestaurant.com");
        restaurant.setOpeningHours("9 AM - 10 PM");
        Restaurant savedRestaurant = restaurantRepository.save(restaurant);

        // Find the restaurant by ID
        Optional<Restaurant> foundRestaurant = restaurantRepository.findById(savedRestaurant.getId());

        // Assert that the found restaurant is not null
        assertNotNull(foundRestaurant);
    }

    @Test
    public void testUpdateRestaurant() {
        // Create and save a restaurant
        Restaurant restaurant = new Restaurant();
        restaurant.setName("Sample Restaurant");
        restaurant.setAddress("123 Main St, City");
        restaurant.setContact("123-456-7890");
        restaurant.setEmail("info@samplerestaurant.com");
        restaurant.setOpeningHours("9 AM - 10 PM");
        Restaurant savedRestaurant = restaurantRepository.save(restaurant);

        // Update the restaurant
        savedRestaurant.setName("Updated Restaurant Name");
        Restaurant updatedRestaurant = restaurantRepository.save(savedRestaurant);

        // Assert that the updated restaurant has the new name
        assertEquals("Updated Restaurant Name", updatedRestaurant.getName());
    }

    
    @Test
    public void testDeleteRestaurant() {
        // Create and save a sample restaurant
        Restaurant restaurant = new Restaurant();
        restaurant.setName("Sample Restaurant");
        restaurant.setAddress("123 Main St, City");
        restaurant.setContact("123-456-7890");
        restaurant.setEmail("info@samplerestaurant.com");
        restaurant.setOpeningHours("9 AM - 10 PM");
        Restaurant savedRestaurant = restaurantRepository.save(restaurant);
        assertNotNull(savedRestaurant.getId());

        // Delete the restaurant
        restaurantRepository.delete(savedRestaurant);

        // Attempt to retrieve the restaurant after deletion
        Restaurant deletedRestaurant = restaurantRepository.findById(savedRestaurant.getId()).orElse(null);

        // Assert that the deleted restaurant is null
        assertNull(deletedRestaurant);
    }
    }
