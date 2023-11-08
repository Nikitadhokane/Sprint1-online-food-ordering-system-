package com.sb.foodsystem.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.foodsystem.converter.MenuTypeConverter;
import com.sb.foodsystem.dao.MenuTypeRepository;
import com.sb.foodsystem.entity.MenuType;
import com.sb.foodsystem.model.MenuTypeDTO;
import com.sb.foodsystem.service.MenuTypeService;

@Service
public class MenuTypeServiceImpl implements MenuTypeService {

	@Autowired
    private MenuTypeRepository menuTypeRepository;
	
	@Autowired
    private MenuTypeConverter menuTypeConverter;

    public MenuTypeServiceImpl(MenuTypeRepository menuTypeRepository, MenuTypeConverter menuTypeConverter) 
    {
        this.menuTypeRepository = menuTypeRepository;
        this.menuTypeConverter = menuTypeConverter;
    }

    
    @Override
    public MenuTypeDTO createMenuType(MenuTypeDTO menuTypeDTO)
    {
        MenuType menuType = menuTypeConverter.dtoToEntity(menuTypeDTO);
        menuType = menuTypeRepository.save(menuType);
        return menuTypeConverter.entityToDto(menuType);
    }

    @Override
    public MenuTypeDTO getMenuTypeById(Long id) 
    {
        MenuType menuType = menuTypeRepository.findById(id).orElse(null);
        return menuTypeConverter.entityToDto(menuType);
    }

    @Override
    public MenuTypeDTO updateMenuType(Long id, MenuTypeDTO menuTypeDTO) 
    {
        MenuType menuType = menuTypeConverter.dtoToEntity(menuTypeDTO);
        menuType.setId(id); // Assuming id is part of the MenuTypeDTO
        menuType = menuTypeRepository.save(menuType);
        return menuTypeConverter.entityToDto(menuType);
    }

    @Override
    public String deleteMenuType(Long id) 
    {
        menuTypeRepository.deleteById(id);
        return "Menu type with ID " + id + " has been deleted successfully.";
    }
}