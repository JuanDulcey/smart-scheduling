package com.devv.smartSheduling.domain.ports.in.user;

import com.devv.smartSheduling.domain.model.User;

import java.util.Optional;
import java.util.UUID;

/**
 * Input port for updating a user.
 * <p>
 * This use case allows changing user information
 * like name, phone, or email.
 * </p>
 */
public interface UpdateUserUseCase {

    /**
     * Update an existing user with new data.
     *
     * @param id the ID of the user to update
     * @param updateData the user data with new values
     * @return the updated user if found, or empty if not found
     */
    Optional<User> updateUser(UUID id, User updateData);
}
