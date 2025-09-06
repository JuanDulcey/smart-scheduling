package com.devv.smartSheduling.domain.ports.in.user;

import com.devv.smartSheduling.domain.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UpdateUserUseCase {
    Optional<User> updateUser(UUID id, User updateData);
}
