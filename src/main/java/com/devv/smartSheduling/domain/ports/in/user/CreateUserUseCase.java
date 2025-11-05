package com.devv.smartSheduling.domain.ports.in.user;

import com.devv.smartSheduling.domain.model.User;

/**
 * Input port for creating a new user.
 * <p>
 * This use case is responsible for saving a new user in the system.
 * </p>
 */
public interface CreateUserUseCase {

    /**
     * Create a new user.
     *
     * @param user the user information to save
     * @return the created user with an assigned ID
     */
    User createUser(User user);
}
