package com.sb.foodsystem.converter;

import org.springframework.stereotype.Component;

import com.sb.foodsystem.entity.MenuType;
import com.sb.foodsystem.model.MenuTypeDTO;

@Component
public class MenuTypeConverter {
	
	public MenuTypeDTO entityToDto(MenuType menuType) {
        MenuTypeDTO menuTypeDTO = new MenuTypeDTO();
        menuTypeDTO.setId(menuType.getId());
        menuTypeDTO.setType_name(menuType.getType_name());
        menuTypeDTO.setDescription(menuType.getDescription());
        return menuTypeDTO;
    }

    public MenuType dtoToEntity(MenuTypeDTO menuTypeDTO) {
        MenuType menuType = new MenuType();
        menuType.setId(menuTypeDTO.getId());
        menuType.setType_name(menuTypeDTO.getType_name());
        menuType.setDescription(menuTypeDTO.getDescription());
        return menuType;
    }

}
