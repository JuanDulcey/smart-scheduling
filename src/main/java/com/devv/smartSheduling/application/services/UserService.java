package com.devv.smartSheduling.application.services;

import com.devv.smartSheduling.domain.model.User;
import com.devv.smartSheduling.domain.ports.in.user.CreateUserUseCase;
import com.devv.smartSheduling.domain.ports.in.user.DeleteUserUseCase;
import com.devv.smartSheduling.domain.ports.in.user.RetrieveUserUseCase;
import com.devv.smartSheduling.domain.ports.in.user.UpdateUserUseCase;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UserService implements
        CreateUserUseCase,
        RetrieveUserUseCase,
        UpdateUserUseCase,
        DeleteUserUseCase {

    final private CreateUserUseCase createUserUseCase;
    final private RetrieveUserUseCase retrieveUserUseCase;
    final private UpdateUserUseCase updateUserUseCase;
    final private DeleteUserUseCase deleteUserUseCase;

    public UserService(CreateUserUseCase createUserUseCase, RetrieveUserUseCase retrieveUserUseCase, UpdateUserUseCase updateUserUseCase, DeleteUserUseCase deleteUserUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.retrieveUserUseCase = retrieveUserUseCase;
        this.updateUserUseCase = updateUserUseCase;
        this.deleteUserUseCase = deleteUserUseCase;
    }

    @Override
    public User createUser(User user) {
        return createUserUseCase.createUser(user);
    }

    @Override
    public boolean deleteUser(UUID id) {
        return deleteUserUseCase.deleteUser(id);
    }

    @Override
    public Optional<User> getUser(UUID id) {
        return retrieveUserUseCase.getUser(id);
    }

    @Override
    public List<User> getAllUser() {
        return retrieveUserUseCase.getAllUser();
    }

    @Override
    public Optional<User> updateUser(UUID id, User updateData) {
        return updateUserUseCase.updateUser(id, updateData);
    }
}
