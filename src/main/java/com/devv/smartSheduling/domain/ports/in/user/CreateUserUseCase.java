package com.devv.smartSheduling.domain.ports.in.user;

import com.devv.smartSheduling.domain.model.User;

public interface CreateUserUseCase {
    User createUser(User user);
}
