package com.devv.smartSheduling.infrastructure.controllers;

import com.devv.smartSheduling.application.services.UserService;
import com.devv.smartSheduling.domain.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Controller for handling User endpoints.
 * <p>
 * Provides REST API endpoints to create, read, update, and delete
 * users in the system.
 * </p>
 */
@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    /**
     * Constructor to inject the UserService.
     *
     * @param userService service for user operations
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Create a new user.
     *
     * @param user user data
     * @return the created user with HTTP status 201 (Created)
     */
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createUser = userService.createUser(user);
        return new ResponseEntity<>(createUser, HttpStatus.CREATED);
    }

    /**
     * Get a user by its ID.
     *
     * @param userId unique ID of the user
     * @return the user with HTTP status 200 (OK) if found,
     * or HTTP status 404 (Not Found) if not found
     */
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable UUID userId) {
        return userService.getUser(userId)
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Get all users.
     *
     * @return list of all users with HTTP status 200 (OK)
     */
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUser();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    /**
     * Update an existing user.
     *
     * @param userId ID of the user to update
     * @param updateUser updated user data
     * @return the updated user with HTTP status 200 (OK) if found,
     * or HTTP status 404 (Not Found) if the user does not exist
     */
    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(
            @PathVariable UUID userId,
            @RequestBody User updateUser) {
        return userService.updateUser(userId, updateUser)
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Delete a user by its ID.
     *
     * @param userId unique ID of the user
     * @return HTTP status 204 (No Content) if deleted,
     * or HTTP status 404 (Not Found) if the user does not exist
     */
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUserById(@PathVariable UUID userId) {
        if (userService.deleteUser(userId)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
