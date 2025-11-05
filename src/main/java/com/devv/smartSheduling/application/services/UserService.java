package com.devv.smartSheduling.application.services;

import com.devv.smartSheduling.domain.model.User;
import com.devv.smartSheduling.domain.ports.in.user.CreateUserUseCase;
import com.devv.smartSheduling.domain.ports.in.user.DeleteUserUseCase;
import com.devv.smartSheduling.domain.ports.in.user.RetrieveUserUseCase;
import com.devv.smartSheduling.domain.ports.in.user.UpdateUserUseCase;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Service class that manages all operations for {@link User}.
 * <p>
 * This service connects use cases for creating, getting,
 * updating, and deleting users in the system.
 * </p>
 */
public class UserService implements
        CreateUserUseCase,
        RetrieveUserUseCase,
        UpdateUserUseCase,
        DeleteUserUseCase {

    final private CreateUserUseCase createUserUseCase;
    final private RetrieveUserUseCase retrieveUserUseCase;
    final private UpdateUserUseCase updateUserUseCase;
    final private DeleteUserUseCase deleteUserUseCase;

    /**
     * Constructor for {@code UserService}.
     *
     * @param createUserUseCase   use case to create users
     * @param retrieveUserUseCase use case to get users
     * @param updateUserUseCase   use case to update users
     * @param deleteUserUseCase   use case to delete users
     */
    public UserService(CreateUserUseCase createUserUseCase, RetrieveUserUseCase retrieveUserUseCase, UpdateUserUseCase updateUserUseCase, DeleteUserUseCase deleteUserUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.retrieveUserUseCase = retrieveUserUseCase;
        this.updateUserUseCase = updateUserUseCase;
        this.deleteUserUseCase = deleteUserUseCase;
    }

    /**
     * Create a new {@link User}.
     *
     * @param user the user to create
     * @return the created {@link User}
     */
    @Override
    public User createUser(User user) {
        return createUserUseCase.createUser(user);
    }

    /**
     * Delete a {@link User} by its ID.
     *
     * @param id the ID of the user
     * @return {@code true} if deleted, {@code false} if not found
     */
    @Override
    public boolean deleteUser(UUID id) {
        return deleteUserUseCase.deleteUser(id);
    }

    /**
     * Get one {@link User} by ID.
     *
     * @param id the ID of the user
     * @return an {@link Optional} with the user if found
     */
    @Override
    public Optional<User> getUser(UUID id) {
        return retrieveUserUseCase.getUser(id);
    }

    /**
     * Get all {@link User} records.
     *
     * @return a list of all users
     */
    @Override
    public List<User> getAllUser() {
        return retrieveUserUseCase.getAllUser();
    }

    /**
     * Update an existing {@link User}.
     *
     * @param id          the ID of the user to update
     * @param updateData  new data for the user
     * @return an {@link Optional} with the updated user if successful
     */
    @Override
    public Optional<User> updateUser(UUID id, User updateData) {
        return updateUserUseCase.updateUser(id, updateData);
    }
}
