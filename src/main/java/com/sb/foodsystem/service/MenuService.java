package com.sb.foodsystem.service;

import com.sb.foodsystem.model.MenuDTO;

public interface MenuService {

    MenuDTO createMenu(MenuDTO menuDTO);

    MenuDTO getMenuById(Long id);

    MenuDTO updateMenu(Long id, MenuDTO menuDTO);

    String deleteMenu(Long id);
}