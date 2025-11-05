package com.devv.smartSheduling.domain.ports.out;

import com.devv.smartSheduling.domain.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Output port for User persistence operations.
 * <p>
 * Defines the basic operations that any repository implementation
 * must provide to interact with the {@link User} domain entity.
 * </p>
 */
public interface UserRepositoryPort {

    /**
     * Save or update a user.
     *
     * @param user the user entity to save
     * @return the saved user
     */
    User save(User user);

    /**
     * Find a user by its unique ID.
     *
     * @param id the unique identifier
     * @return an {@link Optional} with the user if found, or empty if not
     */
    Optional<User> findById(UUID id);

    /**
     * Get all users.
     *
     * @return list of all users
     */
    List<User> findAll();

    /**
     * Delete a user by its unique ID.
     *
     * @param id the unique identifier
     * @return {@code true} if deleted, {@code false} if not found
     */
    boolean deleteById(UUID id);

    /**
     * Update an existing user.
     *
     * @param user the entity with updated data
     * @return an {@link Optional} with the updated user if found, or empty if not
     */
    Optional<User> update(User user);
}
