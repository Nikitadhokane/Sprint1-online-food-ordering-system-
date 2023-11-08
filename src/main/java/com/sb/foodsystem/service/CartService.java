package com.sb.foodsystem.service;

import com.sb.foodsystem.model.CartDTO;

public interface CartService {

    CartDTO createCart(CartDTO cartDTO);

    CartDTO getCartById(Long id);
    
    CartDTO updateCart(CartDTO cartDTO);
    
    CartDTO deleteCart(Long id);
    
    CartDTO addItemToCart(Long cartId, Long menuId, int quantity);
    
    CartDTO removeItemFromCart(Long cartId, Long menuId);
    
    CartDTO clearCart(Long cartId);


}
