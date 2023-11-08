package com.sb.foodsystem.repository;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sb.foodsystem.dao.MenuRepository;
import com.sb.foodsystem.dao.MenuTypeRepository;
import com.sb.foodsystem.dao.UserRepository;
import com.sb.foodsystem.entity.Menu;
import com.sb.foodsystem.entity.MenuType;
import com.sb.foodsystem.entity.User;

@SpringBootTest
public class MenuTypeRepositoryTest {

    @Autowired
    private MenuTypeRepository menuTypeRepository;
    
    @Autowired 
    MenuRepository menuRepository;
    
    @Autowired
    UserRepository userRepository;
    
    @Test
    public void testFindMenuTypeByMenuId() {
        // Creating a sample Menu
        Menu menu = new Menu();
        // Set the necessary attributes for the menu
        menu.setItem("Sample Item");
        menu.setPrice(10);
        menu.setQuantity(100);

        // Saving the menu
        menu = menuRepository.save(menu);

        // Creating a sample MenuType
        MenuType menuType = new MenuType();
        // Set the necessary attributes for the menu type
        menuType.setType_name("Sample Type");
        menuType.setDescription("Sample Description");
        menuType.setMenu(menu);

        // Saving the menu type
        menuType = menuTypeRepository.save(menuType);

        // Finding the menu type by the menu ID
        List<MenuType> foundMenuTypes = menuTypeRepository.findByMenu_Id(menu.getId());

        // Asserting that the found menu type list is not null
        assertNotNull(foundMenuTypes);
    }

    @Test
    public void testSaveMenuType() {
        // Create a sample User
        User user = new User();
        user.setPassword("password");
        user.setUserName("username");

        // Save the user
        User savedUser = userRepository.save(user);

        // Create a sample MenuType
        MenuType menuType = new MenuType();
        menuType.setUser(savedUser);
        // Set the necessary attributes for the menu type
        menuType.setType_name("Sample Type");
        menuType.setDescription("Sample Description");

        // Save the menu type
        MenuType savedMenuType = menuTypeRepository.save(menuType);

        // Assert that the saved menu type has an ID
        assertNotNull(savedMenuType.getId());
    }
    
    @Test
    public void testUpdateMenuType() {
        // Create and save a sample MenuType
        MenuType menuType = new MenuType();
        // Set the necessary attributes for the menu type

        // Save the menu type
        MenuType savedMenuType = menuTypeRepository.save(menuType);

        // Update the menu type
        savedMenuType.setType_name("New Menu Type Name");
        MenuType updatedMenuType = menuTypeRepository.save(savedMenuType);

        // Assert that the updated menu type has the new name
        assertEquals("New Menu Type Name", updatedMenuType.getType_name());
    }

    @Test
    public void testDeleteMenuType() {
        // Create and save a sample MenuType
        MenuType menuType = new MenuType();
        // Set the necessary attributes for the menu type
        User user = new User(); // Add a sample user
        user.setPassword("password");
        user.setUserName("username");

        // Save the user
        User savedUser = userRepository.save(user);

        menuType.setUser(savedUser);
        menuType.setType_name("Sample Type"); // Add a type name
        menuType.setDescription("Sample Description"); // Add a description

        // Save the menu type
        MenuType savedMenuType = menuTypeRepository.save(menuType);

        // Delete the menu type
        menuTypeRepository.deleteById(savedMenuType.getId());

        // Attempt to retrieve the menu type after deletion
        MenuType deletedMenuType = menuTypeRepository.findById(savedMenuType.getId()).orElse(null);

        // Assert that the deleted menu type is null
        assertNull(deletedMenuType);
    }


}