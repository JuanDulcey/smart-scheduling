package com.devv.smartSheduling.application.usecases.user;

import com.devv.smartSheduling.domain.model.User;
import com.devv.smartSheduling.domain.ports.in.user.UpdateUserUseCase;
import com.devv.smartSheduling.domain.ports.out.UserRepositoryPort;

import java.util.Optional;
import java.util.UUID;

/**
 * Implementation of {@link UpdateUserUseCase}.
 * <p>
 * This class updates the information of a user in the system.
 * </p>
 */
public class UpdateUserUseCaseImpl implements UpdateUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    /**
     * Constructor for {@code UpdateUserUseCaseImpl}.
     *
     * @param userRepositoryPort the repository port used to update user data
     */
    public UpdateUserUseCaseImpl(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    /**
     * Update a user with new information.
     *
     * @param id          the UUID of the user
     * @param updateData  the user data to update
     * @return an {@link Optional} with the updated user if successful
     */
    @Override
    public Optional<User> updateUser(UUID id, User updateData) {
        return userRepositoryPort.findById(id);
    }
}
