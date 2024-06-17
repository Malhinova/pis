package com.example.demo;

import entity.Role;
import entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;

import configuration.AppConfig;
import repository.RoleRepository;
import repository.UserRepository;
import service.UserService;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = RegistrationTest.TestConfig.class)
public class RegistrationTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Configuration
    @EnableJpaRepositories(basePackages = "repository")
    @EntityScan(basePackages = "entity")
    @ComponentScan(basePackages = "service")
    @Import(AppConfig.class)
    static class TestConfig {
        // Additional test-specific configuration if needed
    }

    @BeforeEach
    public void setUp() {
        Role role = new Role();
        role.setName("ROLE_USER");
        roleRepository.save(role);
    }

    @Test
    public void testUserRegistration() {
        // Prepare test data
        User user = new User();
        user.setUsername("testuser");

        // Register the user
        User registeredUser = userService.registerUser(user, "password123");

        // Assert the user was saved correctly
        assertNotNull(registeredUser.getId());
        assertTrue(registeredUser.getRoles().stream().anyMatch(role -> role.getName().equals("ROLE_USER")));
        assertTrue(passwordEncoder.matches("password123", registeredUser.getPassword()));

        // Print a message indicating the test passed
        System.out.println("Test passed: User registration successful with ID: " + registeredUser.getId());
    }
}
