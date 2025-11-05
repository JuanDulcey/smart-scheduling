package com.devv.smartSheduling.application.usecases.user;

import com.devv.smartSheduling.domain.model.User;
import com.devv.smartSheduling.domain.ports.in.user.RetrieveUserUseCase;
import com.devv.smartSheduling.domain.ports.out.UserRepositoryPort;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Implementation of {@link RetrieveUserUseCase}.
 * <p>
 * This class retrieves one or all users using the {@link UserRepositoryPort}.
 * </p>
 */
public class RetriveUserUseCaseImpl implements RetrieveUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    /**
     * Constructor for {@code RetrieveUserUseCaseImpl}.
     *
     * @param userRepositoryPort the repository port used to get user data
     */
    public RetriveUserUseCaseImpl(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    /**
     * Get one user by their unique ID.
     *
     * @param id the UUID of the user
     * @return an {@link Optional} with the user if found
     */
    @Override
    public Optional<User> getUser(UUID id) {
        return userRepositoryPort.findById(id);
    }

    /**
     * Get all users in the system.
     *
     * @return a list of {@link User}
     */
    @Override
    public List<User> getAllUser() {
        return userRepositoryPort.findAll();
    }
}
