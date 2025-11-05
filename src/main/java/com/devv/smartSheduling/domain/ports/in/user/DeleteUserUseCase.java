package com.devv.smartSheduling.domain.ports.in.user;

import java.util.UUID;

/**
 * Input port for deleting a user.
 * <p>
 * This use case is responsible for removing a user from the system
 * using their unique identifier (UUID).
 * </p>
 */
public interface DeleteUserUseCase {

    /**
     * Delete a user by their ID.
     *
     * @param id the unique ID of the user to delete
     * @return true if the user was deleted successfully, false otherwise
     */
    boolean deleteUser(UUID id);
}
