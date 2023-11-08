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

import com.sb.foodsystem.converter.MenuConverter;
import com.sb.foodsystem.model.MenuDTO;
import com.sb.foodsystem.service.MenuService;

@RestController
//@RequestMapping("/menu")
@RequestMapping("/api/menu")
public class MenuController {

	@Autowired
    private final MenuService menuService;
	
	@SuppressWarnings("unused")
	@Autowired
    private final MenuConverter menuConverter;

   
    public MenuController(MenuService menuService, MenuConverter menuConverter) 
    {
        this.menuService = menuService;
        this.menuConverter = menuConverter;
    }

//    @PostMapping("/menu")
//    public MenuDTO createMenu(@RequestBody MenuDTO menuDTO) 
//    {
//    	
//        return menuService.createMenu(menuDTO);
//    }
    
     @PostMapping(value = "/menu", consumes = "application/json")
	 public ResponseEntity<MenuDTO> createMenu(@RequestBody MenuDTO menuDTO) 
	 {
	      MenuDTO createdMenu = menuService.createMenu(menuDTO);
	      return new ResponseEntity<>(createdMenu, HttpStatus.CREATED);
	 }
 

    @GetMapping("/menu/{id}")
    public MenuDTO getMenuById(@PathVariable Long id) {
        return menuService.getMenuById(id);
    }

    @PutMapping("/menu/{id}")
    public MenuDTO updateMenu(@PathVariable Long id, @RequestBody MenuDTO menuDTO) 
    {
        return menuService.updateMenu(id, menuDTO);
    }


    @DeleteMapping("/menu/{id}")
    public String deleteMenu(@PathVariable Long id)
    {
        return menuService.deleteMenu(id);
    }
}
