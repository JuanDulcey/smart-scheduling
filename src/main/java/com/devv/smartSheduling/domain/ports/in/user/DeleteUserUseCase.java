package com.devv.smartSheduling.domain.ports.in.user;

import java.util.UUID;

public interface DeleteUserUseCase {
    boolean deleteUser(UUID id);
}
