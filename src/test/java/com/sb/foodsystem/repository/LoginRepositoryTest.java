package com.sb.foodsystem.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sb.foodsystem.dao.LoginRepository;
import com.sb.foodsystem.dao.UserRepository;
import com.sb.foodsystem.entity.Login;
import com.sb.foodsystem.entity.User;

@SpringBootTest
public class LoginRepositoryTest {

    @Autowired
    private LoginRepository loginRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Test
    public void testCreateLogin() {
        User user = new User();
        user.setPassword("testpassword");
        user.setUserName("testuser");
        User savedUser = userRepository.save(user); // Save the user first

        Login login = new Login();
        login.setUsername("testusername");
        login.setPassword("testpassword");
        login.setUser(savedUser);

        // Creating a new Login
        Login createdLogin = loginRepository.save(login);

        // Check if the Login is created successfully with a generated ID
        assertNotNull(createdLogin.getLoginId());
    }

    @Test
    public void testSaveLogin() {
        User user = new User();
        user.setPassword("testpassword");
        user.setUserName("testuser");
        User savedUser = userRepository.save(user); // Save the user first

        Login login = new Login();
        login.setUsername("testusername");
        login.setPassword("testpassword");
        login.setUser(savedUser);

        Login savedLogin = loginRepository.save(login);
        assertNotNull(savedLogin.getLoginId());
    }

    @Test
    public void testFindLoginByLoginId() {
        User user = new User();
        user.setPassword("testpassword");
        user.setUserName("testuser");
        User savedUser = userRepository.save(user);

        Login login = new Login();
        login.setUsername("testusername");
        login.setPassword("testpassword");
        login.setUser(savedUser);

        Login savedLogin = loginRepository.save(login);
        Long loginId = savedLogin.getLoginId();

        Login retrievedLogin = loginRepository.findById(loginId).orElse(null);
        assertNotNull(retrievedLogin);
        assertEquals(login.getUsername(), retrievedLogin.getUsername());
        assertEquals(login.getPassword(), retrievedLogin.getPassword());
        // Add more assertions for other fields
    }

    @Test
    public void testUpdateLogin() {
        User user = new User();
        user.setPassword("testpassword");
        user.setUserName("testuser");
        User savedUser = userRepository.save(user);

        Login login = new Login();
        login.setUsername("testusername");
        login.setPassword("testpassword");
        login.setUser(savedUser);

        Login savedLogin = loginRepository.save(login);
        Long loginId = savedLogin.getLoginId();

        Login retrievedLogin = loginRepository.findById(loginId).orElse(null);
        assertNotNull(retrievedLogin);

        retrievedLogin.setUsername("newusername");
        retrievedLogin.setPassword("newpassword");
        loginRepository.save(retrievedLogin);

        Login updatedLogin = loginRepository.findById(loginId).orElse(null);
        assertNotNull(updatedLogin);
        assertEquals("newusername", updatedLogin.getUsername());
        assertEquals("newpassword", updatedLogin.getPassword());
        // Add more assertions for other fields
    }

    @Test
    public void testDeleteLogin() {
        User user = new User();
        user.setPassword("testpassword");
        user.setUserName("testuser");
        User savedUser = userRepository.save(user);

        Login login = new Login();
        login.setUsername("testusername");
        login.setPassword("testpassword");
        login.setUser(savedUser);

        Login savedLogin = loginRepository.save(login);
        Long loginId = savedLogin.getLoginId();

        loginRepository.deleteById(loginId);

        Login deletedLogin = loginRepository.findById(loginId).orElse(null);
        assertNull(deletedLogin);
    }
}