package com.sb.foodsystem.repository;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sb.foodsystem.dao.MenuRepository;
import com.sb.foodsystem.dao.RestaurantRepository;
import com.sb.foodsystem.entity.Menu;
import com.sb.foodsystem.entity.Restaurant;

@SpringBootTest
public class MenuRepositoryTest {

    @Autowired
    private MenuRepository menuRepository;
    
    @Autowired 
    private RestaurantRepository restaurantRepository;

    @Test
    public void testSaveMenu() {
        Restaurant restaurant = new Restaurant();
        restaurant.setName("Delicious Restaurant");
        restaurant.setAddress("123 Main St, City");
        restaurant.setContact("123-456-7890");
        restaurant.setEmail("info@deliciousrestaurant.com");
        restaurant.setOpeningHours("9 AM - 10 PM");

        Restaurant savedRestaurant = restaurantRepository.save(restaurant);
        assertNotNull(savedRestaurant.getId());

        Menu menu = new Menu();
        menu.setItem("Burger");
        menu.setPrice(10);
        menu.setQuantity(50);
        menu.setRestaurant(savedRestaurant);

        Menu savedMenu = menuRepository.save(menu);
        assertNotNull(savedMenu.getId());
    }
    
    @Test
    public void testCreateMenu() {
        // Create a new restaurant
        Restaurant restaurant = new Restaurant();
        restaurant.setName("Test Restaurant");
        restaurant.setAddress("123 Test St, City");
        restaurant.setContact("123-456-7890");
        restaurant.setEmail("info@testrestaurant.com");
        restaurant.setOpeningHours("9 AM - 9 PM");
        Restaurant savedRestaurant = restaurantRepository.save(restaurant);
        assertNotNull(savedRestaurant.getId());

        // Create a new menu associated with the restaurant
        Menu menu = new Menu();
        menu.setItem("Test Item");
        menu.setPrice(15);
        menu.setQuantity(30);
        menu.setRestaurant(savedRestaurant);
        Menu savedMenu = menuRepository.save(menu);
        assertNotNull(savedMenu.getId());

        // Check if the Menu is saved successfully with a generated ID
        assertNotNull(savedMenu.getId());
        assertEquals("Test Item", savedMenu.getItem());
        assertEquals(15, savedMenu.getPrice());
        assertEquals(30, savedMenu.getQuantity());
        assertEquals(savedRestaurant.getId(), savedMenu.getRestaurant().getId());
    }

    @Test
    public void testFindMenuByRestaurantId() {
        // Create a new restaurant
        Restaurant restaurant = new Restaurant();
        restaurant.setName("Delicious Restaurant");
        restaurant.setAddress("123 Main St, City");
        restaurant.setContact("123-456-7890");
        restaurant.setEmail("info@deliciousrestaurant.com");
        restaurant.setOpeningHours("9 AM - 10 PM");
        Restaurant savedRestaurant = restaurantRepository.save(restaurant);
        assertNotNull(savedRestaurant.getId());

        // Create a new menu associated with the restaurant
        Menu menu = new Menu();
        menu.setItem("Burger");
        menu.setPrice(10);
        menu.setQuantity(50);
        menu.setRestaurant(savedRestaurant);
        Menu savedMenu = menuRepository.save(menu);
        assertNotNull(savedMenu.getId());

        // Find menu by the restaurant ID
        List<Menu> foundMenus = menuRepository.findByRestaurant_Id(savedRestaurant.getId());
        assertNotNull(foundMenus);
        assertEquals(1, foundMenus.size());
        assertEquals(savedMenu.getItem(), foundMenus.get(0).getItem());
        assertEquals(savedMenu.getPrice(), foundMenus.get(0).getPrice());
        assertEquals(savedMenu.getQuantity(), foundMenus.get(0).getQuantity());
    }

    @Test
    public void testDeleteMenuByRestaurantId() {
        // Save a restaurant
        Restaurant restaurant = new Restaurant();
        restaurant.setName("Delicious Restaurant");
        restaurant.setAddress("123 Main St, City");
        restaurant.setContact("123-456-7890");
        restaurant.setEmail("info@deliciousrestaurant.com");
        restaurant.setOpeningHours("9 AM - 10 PM");
        Restaurant savedRestaurant = restaurantRepository.save(restaurant);
        assertNotNull(savedRestaurant.getId());

        // Save a menu associated with the restaurant
        Menu menu = new Menu();
        menu.setItem("Burger");
        menu.setPrice(10);
        menu.setQuantity(50);
        menu.setRestaurant(savedRestaurant);
        Menu savedMenu = menuRepository.save(menu);
        assertNotNull(savedMenu.getId());

     // Delete menu by the restaurant ID
        menuRepository.deleteByRestaurant_Id(savedRestaurant.getId());
        Menu deletedMenu = menuRepository.findById(savedMenu.getId()).orElse(null);
        assertNull(deletedMenu);    }

    @Test
    public void testUpdateMenu() {
        // Save a restaurant
        Restaurant restaurant = new Restaurant();
        restaurant.setName("Delicious Restaurant");
        restaurant.setAddress("123 Main St, City");
        restaurant.setContact("123-456-7890");
        restaurant.setEmail("info@deliciousrestaurant.com");
        restaurant.setOpeningHours("9 AM - 10 PM");
        Restaurant savedRestaurant = restaurantRepository.save(restaurant);
        assertNotNull(savedRestaurant.getId());

        // Save a menu associated with the restaurant
        Menu menu = new Menu();
        menu.setItem("Burger");
        menu.setPrice(10);
        menu.setQuantity(50);
        menu.setRestaurant(savedRestaurant);
        Menu savedMenu = menuRepository.save(menu);
        assertNotNull(savedMenu.getId());

        // Update the menu
        savedMenu.setItem("Cheeseburger");
        savedMenu.setPrice(12);
        menuRepository.save(savedMenu);

        Menu updatedMenu = menuRepository.findById(savedMenu.getId()).orElse(null);
        assertNotNull(updatedMenu);
        assertEquals("Cheeseburger", updatedMenu.getItem());
        assertEquals(12, updatedMenu.getPrice());
    }
}