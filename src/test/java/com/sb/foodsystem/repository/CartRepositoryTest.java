package com.sb.foodsystem.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sb.foodsystem.dao.CartRepository;
import com.sb.foodsystem.dao.UserRepository; // Import the UserRepository
import com.sb.foodsystem.entity.Cart;
import com.sb.foodsystem.entity.User;

@SpringBootTest
public class CartRepositoryTest {

    @Autowired
    private CartRepository cartRepository;

    @Autowired // Autowire the UserRepository
    private UserRepository userRepository;

    @Test
    public void testCreateCart() {
        // Creating a new User for the Cart
        User user = new User();
        user.setPassword("testpassword");
        user.setUserName("testuser");
        User savedUser = userRepository.save(user); // Save the user first

        // Creating a new Cart
        Cart cart = new Cart();
        cart.setQuantity(2);
        cart.setUser(savedUser); // Set the saved user to the cart

        // Saving the Cart in the repository
        Cart savedCart = cartRepository.save(cart);

        // Check if the Cart is saved successfully with a generated ID
        assertNotNull(savedCart.getCartId());
    }
    
    @Test
    public void testSaveCart() {
        // Creating a new User for the Cart
        User user = new User();
        user.setPassword("testpassword");
        user.setUserName("testuser");
        User savedUser = userRepository.save(user); // Save the user first

        // Creating a new Cart
        Cart cart = new Cart();
        cart.setQuantity(2);
        cart.setUser(savedUser); // Set the saved user to the cart

        // Saving the Cart in the repository
        Cart savedCart = cartRepository.save(cart);

        // Check if the Cart is saved successfully with a generated ID
        assertNotNull(savedCart.getCartId());
    }
    
    @Test
    public void testFindCartByCartId() {
        Cart cart = new Cart();
        cart.setQuantity(2);
        // set other details

        Cart savedCart = cartRepository.save(cart);
        Long cartId = savedCart.getCartId();

        Cart retrievedCart = cartRepository.findByCartId(cartId);
        assertNotNull(retrievedCart);
        assertEquals(cart.getQuantity(), retrievedCart.getQuantity());
    }
    
    @Test
    public void testDeleteCart() {
        User user = new User();
        user.setPassword("testpassword");
        user.setUserName("testuser");
        User savedUser = userRepository.save(user);

        Cart cart = new Cart();
        cart.setQuantity(2);
        cart.setUser(savedUser);
        Cart savedCart = cartRepository.save(cart);
        Long cartId = savedCart.getCartId();

        cartRepository.deleteById(cartId);

        Cart deletedCart = cartRepository.findByCartId(cartId);
        assertNull(deletedCart);
    }
    
    @Test
    public void testUpdateCart() {
        User user = new User();
        user.setPassword("testpassword");
        user.setUserName("testuser");
        User savedUser = userRepository.save(user);

        Cart cart = new Cart();
        cart.setQuantity(2);
        cart.setUser(savedUser);
        Cart savedCart = cartRepository.save(cart);
        Long cartId = savedCart.getCartId();

        Cart retrievedCart = cartRepository.findByCartId(cartId);
        assertNotNull(retrievedCart);
        assertEquals(2, retrievedCart.getQuantity());

        retrievedCart.setQuantity(5);
        cartRepository.save(retrievedCart);

        Cart updatedCart = cartRepository.findByCartId(cartId);
        assertNotNull(updatedCart);
        assertEquals(5, updatedCart.getQuantity());
    }

    
}