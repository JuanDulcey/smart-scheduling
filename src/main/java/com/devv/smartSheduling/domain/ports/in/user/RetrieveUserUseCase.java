package com.devv.smartSheduling.domain.ports.in.user;

import com.devv.smartSheduling.domain.model.User;
import java.util.Optional;
import java.util.UUID;
import java.util.List;

public interface RetrieveUserUseCase {
    Optional<User> getUser(UUID id);
    List<User> getAllUser();
}
