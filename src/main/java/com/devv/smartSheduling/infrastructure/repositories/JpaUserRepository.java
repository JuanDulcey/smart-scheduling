package com.devv.smartSheduling.infrastructure.repositories;

import com.devv.smartSheduling.infrastructure.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * JPA repository for managing {@link UserEntity} data.
 * <p>
 * This interface provides basic CRUD operations for the "users" table.
 * It uses {@link JpaRepository} to access the database.
 * </p>
 */
public interface JpaUserRepository extends JpaRepository<UserEntity, UUID> {
    // No additional methods required. Basic CRUD operations are inherited from JpaRepository.
}
