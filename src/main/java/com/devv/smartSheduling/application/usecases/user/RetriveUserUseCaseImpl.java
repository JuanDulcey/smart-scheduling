package com.devv.smartSheduling.application.usecases.user;

import com.devv.smartSheduling.domain.model.User;
import com.devv.smartSheduling.domain.ports.in.user.RetrieveUserUseCase;
import com.devv.smartSheduling.domain.ports.out.UserRepositoryPort;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class RetriveUserUseCaseImpl implements RetrieveUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    public RetriveUserUseCaseImpl(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public Optional<User> getUser(UUID id) {
        return userRepositoryPort.findById(id);
    }

    @Override
    public List<User> getAllUser() {
        return userRepositoryPort.findAll();
    }
}
