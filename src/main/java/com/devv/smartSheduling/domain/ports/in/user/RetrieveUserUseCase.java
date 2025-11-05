package com.devv.smartSheduling.domain.ports.in.user;

import com.devv.smartSheduling.domain.model.User;
import java.util.Optional;
import java.util.UUID;
import java.util.List;

/**
 * Input port for getting users.
 * <p>
 * This use case allows finding one user by ID
 * or getting all users from the system.
 * </p>
 */
public interface RetrieveUserUseCase {

    /**
     * Get one user by their ID.
     *
     * @param id the unique ID of the user
     * @return the user if found, or empty if not found
     */
    Optional<User> getUser(UUID id);

    /**
     * Get all users in the system.
     *
     * @return a list with all users
     */
    List<User> getAllUser();
}
