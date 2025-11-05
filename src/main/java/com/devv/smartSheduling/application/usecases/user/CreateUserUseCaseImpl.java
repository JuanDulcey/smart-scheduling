package com.devv.smartSheduling.application.usecases.user;

import com.devv.smartSheduling.domain.model.User;
import com.devv.smartSheduling.domain.ports.in.user.CreateUserUseCase;
import com.devv.smartSheduling.domain.ports.out.UserRepositoryPort;

/**
 * Implementation of {@link CreateUserUseCase}.
 * <p>
 * This class creates a new {@link User} using the {@link UserRepositoryPort}.
 * </p>
 */
public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    /**
     * Constructor for {@code CreateUserUseCaseImpl}.
     *
     * @param userRepositoryPort the repository port used to save users
     */
    public CreateUserUseCaseImpl(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    /**
     * Create a new user and save it in the repository.
     *
     * @param user the user to create
     * @return the created {@link User}
     */
    @Override
    public User createUser(User user) {
        return userRepositoryPort.save(user);
    }
}
