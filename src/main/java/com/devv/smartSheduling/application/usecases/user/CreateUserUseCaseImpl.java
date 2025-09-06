package com.devv.smartSheduling.application.usecases.user;

import com.devv.smartSheduling.domain.model.User;
import com.devv.smartSheduling.domain.ports.in.user.CreateUserUseCase;
import com.devv.smartSheduling.domain.ports.out.UserRepositoryPort;

public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    public CreateUserUseCaseImpl(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }


    @Override
    public User createUser(User user) {
        return userRepositoryPort.save(user);
    }
}
