package com.devv.smartSheduling.application.usecases.user;

import com.devv.smartSheduling.domain.ports.in.user.DeleteUserUseCase;
import com.devv.smartSheduling.domain.ports.out.UserRepositoryPort;

import java.util.UUID;

/**
 * Implementation of {@link DeleteUserUseCase}.
 * <p>
 * This class deletes a user using the {@link UserRepositoryPort}.
 * </p>
 */
public class DeleteUserUseCaseImpl implements DeleteUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    /**
     * Constructor for {@code DeleteUserUseCaseImpl}.
     *
     * @param userRepositoryPort the repository port used to delete users
     */
    public DeleteUserUseCaseImpl(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    /**
     * Delete a user by their unique ID.
     *
     * @param id the UUID of the user to delete
     * @return true if the user was deleted, false otherwise
     */
    @Override
    public boolean deleteUser(UUID id) {
        return userRepositoryPort.deleteById(id);
    }
}
