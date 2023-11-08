package com.sb.foodsystem.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.foodsystem.converter.CartConverter;
import com.sb.foodsystem.dao.CartRepository;
import com.sb.foodsystem.entity.Cart;
import com.sb.foodsystem.model.CartDTO;
import com.sb.foodsystem.service.CartService;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartConverter cartConverter;

    @Override
    public CartDTO createCart(CartDTO cartDTO) {
        Cart cart = cartConverter.dtoToEntity(cartDTO);
        Cart savedCart = cartRepository.save(cart);
        return cartConverter.entityToDto(savedCart);
    }

    @Override
    public CartDTO getCartById(Long id) {
        Cart cart = cartRepository.findById(id).orElse(null);
        return cartConverter.entityToDto(cart);
    }

    @Override
    public CartDTO updateCart(CartDTO cartDTO) {
        // Implement the logic for updating a cart
        Cart cart = cartConverter.dtoToEntity(cartDTO);
        Cart updatedCart = cartRepository.save(cart);
        return cartConverter.entityToDto(updatedCart);
    }

    @Override
    public CartDTO deleteCart(Long id) {
        // Implement the logic for deleting a cart
        cartRepository.deleteById(id);
        return new CartDTO(); // Return an empty CartDTO or handle the response accordingly
    }

    @Override
    public CartDTO addItemToCart(Long cartId, Long menuId, int quantity) {
        // Implement the logic for adding an item to the cart
        Cart cart = cartRepository.findById(cartId).orElse(null);
        // Add the item to the cart
        // Update the cart entity and save it using the repository
        Cart updatedCart = cartRepository.save(cart);
        return cartConverter.entityToDto(updatedCart);
    }

    @Override
    public CartDTO removeItemFromCart(Long cartId, Long menuId) {
        // Implement the logic for removing an item from the cart
        Cart cart = cartRepository.findById(cartId).orElse(null);
        // Remove the item from the cart
        // Update the cart entity and save it using the repository
        Cart updatedCart = cartRepository.save(cart);
        return cartConverter.entityToDto(updatedCart);
    }

    @Override
    public CartDTO clearCart(Long cartId) {
        // Implement the logic for clearing the cart
        Cart cart = cartRepository.findById(cartId).orElse(null);
        // Clear the cart items
        // Update the cart entity and save it using the repository
        Cart clearedCart = cartRepository.save(cart);
        return cartConverter.entityToDto(clearedCart);
    }
}