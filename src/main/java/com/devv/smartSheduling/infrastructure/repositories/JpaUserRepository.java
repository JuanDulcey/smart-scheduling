package com.devv.smartSheduling.infrastructure.repositories;

import com.devv.smartSheduling.infrastructure.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaUserRepository extends JpaRepository<UserEntity, UUID> {
}
