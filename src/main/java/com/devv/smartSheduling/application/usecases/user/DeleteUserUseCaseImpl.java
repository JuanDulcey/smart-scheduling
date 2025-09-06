package com.devv.smartSheduling.application.usecases.user;

import com.devv.smartSheduling.domain.ports.in.user.DeleteUserUseCase;
import com.devv.smartSheduling.domain.ports.out.UserRepositoryPort;

import java.util.UUID;

public class DeleteUserUseCaseImpl implements DeleteUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    public DeleteUserUseCaseImpl(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public boolean deleteUser(UUID id) {
        return userRepositoryPort.deleteById(id);
    }
}
