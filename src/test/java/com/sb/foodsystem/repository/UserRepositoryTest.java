package com.sb.foodsystem.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sb.foodsystem.dao.UserRepository;
import com.sb.foodsystem.entity.User;
@SpringBootTest
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void testCreateUser() {
	    // Create a sample user
	    User user = new User();
	    // Set the necessary attributes for the user
	    user.setUserName("testUser");
	    user.setPassword("password123");

	    // Save the user
	    User savedUser = userRepository.save(user);

	    // Assert that the saved user has an ID
	    assertNotNull(savedUser.getUser_id());
	}
	
	@Test
	public void testSaveUser() {
	    // Create a sample user
	    User user = new User();
	    // Set the necessary attributes for the user
	    user.setUserName("testUser");
	    user.setPassword("password123");

	    // Save the user
	    User savedUser = userRepository.save(user);

	    // Assert that the saved user has an ID
	    assertNotNull(savedUser.getUser_id());
	}


	@Test
	public void testFindUserByUserNameAndPassword() {
	    // Implement the test logic to find User by username and password
	}

	@Test
	public void testUpdateUser() {
	    // Create a sample user
	    User user = new User();
	    // Set the necessary attributes for the user
	    user.setUserName("testUser");
	    user.setPassword("password123");

	    // Save the user
	    User savedUser = userRepository.save(user);
	    assertNotNull(savedUser.getUser_id());

	    // Update the user
	    savedUser.setPassword("newPassword123");
	    User updatedUser = userRepository.save(savedUser);

	    // Assert that the password has been updated
	    assertEquals("newPassword123", updatedUser.getPassword());
	}

	@Test
	public void testDeleteUser() {
	    // Create and save a sample user
	    User user = new User();
	    // Set the necessary attributes for the user
	    user.setUserName("sampleUser");
	    user.setPassword("password123");

	    // Save the user
	    User savedUser = userRepository.save(user);
	    assertNotNull(savedUser.getUser_id());

	    // Delete the user
	    userRepository.delete(savedUser);

	    // Attempt to retrieve the user after deletion
	    User deletedUser = userRepository.findByUserNameAndPassword(savedUser.getUserName(), savedUser.getPassword());

	    // Assert that the deleted user is null
	    assertNull(deletedUser);
	}

}
