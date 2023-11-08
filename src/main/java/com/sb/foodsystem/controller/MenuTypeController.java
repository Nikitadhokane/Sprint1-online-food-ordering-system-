package com.sb.foodsystem.controller;

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

import com.sb.foodsystem.converter.LoginConverter;
import com.sb.foodsystem.converter.MenuTypeConverter;
import com.sb.foodsystem.model.LoginDTO;
import com.sb.foodsystem.model.MenuTypeDTO;
import com.sb.foodsystem.service.LoginService;
import com.sb.foodsystem.service.MenuTypeService;

@RestController
//@RequestMapping("/menu-types")
@RequestMapping("/api/menutype")
public class MenuTypeController {

	@Autowired
    private MenuTypeService menuTypeService;
	
	@SuppressWarnings("unused")
	@Autowired
    private MenuTypeConverter menuTypeConverter;

    
    public MenuTypeController(MenuTypeService menuTypeService, MenuTypeConverter menuTypeConverter)
    {
        this.menuTypeService = menuTypeService;
        this.menuTypeConverter = menuTypeConverter;
    }

    @PostMapping("/create/menu-type")
    public ResponseEntity<MenuTypeDTO> createMenuType(@RequestBody MenuTypeDTO menuTypeDTO)
    {
        MenuTypeDTO createdMenuType = menuTypeService.createMenuType(menuTypeDTO);
        return new ResponseEntity<>(createdMenuType, HttpStatus.CREATED);
    }

    @GetMapping("/menu-type/{id}")
    public ResponseEntity<MenuTypeDTO> getMenuTypeById(@PathVariable Long id) 
    {
        MenuTypeDTO menuTypeDTO = menuTypeService.getMenuTypeById(id);
        return new ResponseEntity<>(menuTypeDTO, HttpStatus.OK);
    }

    @PutMapping("/menu-type/{id}")
    public ResponseEntity<MenuTypeDTO> updateMenuType(@PathVariable Long id, @RequestBody MenuTypeDTO menuTypeDTO) 
    {
        MenuTypeDTO updatedMenuType = menuTypeService.updateMenuType(id, menuTypeDTO);
        return new ResponseEntity<>(updatedMenuType, HttpStatus.OK);
    }

    @DeleteMapping("/menu-type/{id}")
    public ResponseEntity<String> deleteMenuType(@PathVariable Long id) 
    {
        String message = menuTypeService.deleteMenuType(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}

