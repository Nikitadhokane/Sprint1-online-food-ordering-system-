package com.sb.foodsystem.converter;

import org.springframework.stereotype.Component;

import com.sb.foodsystem.entity.Menu;
import com.sb.foodsystem.model.MenuDTO;

@Component
public class MenuConverter {

	public MenuDTO entityToDTO(Menu menu) {
        MenuDTO menuDTO = new MenuDTO();
        menuDTO.setId(menu.getId());
        menuDTO.setItem(menu.getItem());
        menuDTO.setPrice(menu.getPrice());
        menuDTO.setQuantity(menu.getQuantity());
        if (menu.getRestaurant() != null) {
            menuDTO.setRestaurantId(menu.getRestaurant().getId());
        }
        // Set other fields or nested objects as needed
        return menuDTO;
    }

	public Menu dtoToEntity(MenuDTO menuDTO) {
        Menu menu = new Menu();
        menu.setId(menuDTO.getId());
        menu.setItem(menuDTO.getItem());
        menu.setPrice(menuDTO.getPrice());
        menu.setQuantity(menuDTO.getQuantity());
        // Set other fields or nested objects as needed
        return menu;
    }
}


