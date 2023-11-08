package com.sb.foodsystem.repository;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sb.foodsystem.dao.AdminRepository;
import com.sb.foodsystem.entity.Admin;

@SpringBootTest
public class AdminRepositoryTest {

    @Autowired
    private AdminRepository adminRepository;
    
    @Test
    public void testCreateAdmin()
    {
    	Admin admin = new Admin();
    	admin.setUsername("admin12");
    	admin.setPassword("pass12");
    	admin.setEmail("admin12@gmail.com");
    	admin.setContact("7687675434");
    	
    	Admin savedAdmin = adminRepository.save(admin);
    	assertNotNull(savedAdmin.getId());
    	System.out.println("test create admin is running");
    }

    @Test
    public void testSaveAdmin() {
        Admin admin = new Admin();
        admin.setUsername("admin1");
        admin.setPassword("pass12");
        admin.setEmail("admin1@gmail.com");
        admin.setContact("8765465698");

        Admin savedAdmin = adminRepository.save(admin);
        assertNotNull(savedAdmin.getId());
    }

    @Test
    public void testFindAllAdmins() {
        List<Admin> admins = adminRepository.findAll();
        assertNotNull(admins);
    }

    @Test
    public void testgetAdminById() {
        Admin admin = new Admin();
        admin.setUsername("admin1");
        admin.setPassword("pass12");
        admin.setEmail("admin1@gmail.com");
        admin.setContact("8765465698");

        Admin savedAdmin = adminRepository.save(admin);
        Long adminId = savedAdmin.getId();

        // Make sure to retrieve the admin by its ID
        Admin retrievedAdmin = adminRepository.findById(adminId).orElse(null);

        assertNotNull(retrievedAdmin);
        assertEquals(admin.getUsername(), retrievedAdmin.getUsername());
        assertEquals(admin.getPassword(), retrievedAdmin.getPassword());
        assertEquals(admin.getEmail(), retrievedAdmin.getEmail());
        assertEquals(admin.getContact(), retrievedAdmin.getContact());
    }
    @Test
    public void testUpdateAdmin() {
        Admin admin = new Admin();
        admin.setUsername("admin1");
        admin.setPassword("pass12");
        admin.setEmail("admin@gmail.com");
        admin.setContact("8765465698");

        Admin savedAdmin = adminRepository.save(admin);
        Long adminId = savedAdmin.getId();

        Admin retrievedAdmin = adminRepository.findById(adminId).orElse(null);
        assertNotNull(retrievedAdmin);

        retrievedAdmin.setUsername("newAdmin1");
        retrievedAdmin.setPassword("npass1");
        retrievedAdmin.setEmail("newadmin@gmail.com");
        retrievedAdmin.setContact("1234567890");

        adminRepository.save(retrievedAdmin);

        Admin updatedAdmin = adminRepository.findById(adminId).orElse(null);
        assertNotNull(updatedAdmin);
        assertEquals("newAdmin1", updatedAdmin.getUsername());
        assertEquals("npass1", updatedAdmin.getPassword());
        assertEquals("newadmin@gmail.com", updatedAdmin.getEmail());
        assertEquals("1234567890", updatedAdmin.getContact());
    }

    @Test
    public void testDeleteAdmin() {
        Admin admin = new Admin();
        admin.setUsername("admin1");
        admin.setPassword("pass12");
        admin.setEmail("admin@gmail.com");
        admin.setContact("8765465698");

        Admin savedAdmin = adminRepository.save(admin);
        Long adminId = savedAdmin.getId();

        adminRepository.deleteById(adminId);

        Admin deletedAdmin = adminRepository.findById(adminId).orElse(null);
        assertNull(deletedAdmin);
    }
    




}