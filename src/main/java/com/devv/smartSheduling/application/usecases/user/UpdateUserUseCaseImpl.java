package com.devv.smartSheduling.application.usecases.user;

import com.devv.smartSheduling.domain.model.User;
import com.devv.smartSheduling.domain.ports.in.user.UpdateUserUseCase;
import com.devv.smartSheduling.domain.ports.out.UserRepositoryPort;

import java.util.Optional;
import java.util.UUID;

public class UpdateUserUseCaseImpl implements UpdateUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    public UpdateUserUseCaseImpl(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }


    @Override
    public Optional<User> updateUser(UUID id, User updateData) {
        return userRepositoryPort.findById(id);
    }
}
