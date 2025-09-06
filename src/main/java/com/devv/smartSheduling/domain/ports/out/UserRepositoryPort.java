package com.devv.smartSheduling.domain.ports.out;

import com.devv.smartSheduling.domain.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepositoryPort {
    User save(User user);
    Optional<User> findById(UUID id);
    List<User> findAll();
    boolean deleteById(UUID id);
    Optional<User> update(User user);
}
