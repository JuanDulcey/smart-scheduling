package com.devv.smartSheduling.infrastructure.repositories;

import com.devv.smartSheduling.infrastructure.entities.SpecialistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * JPA repository for managing {@link SpecialistEntity} data.
 * <p>
 * This interface provides basic CRUD operations for the "specialists" table.
 * It uses {@link JpaRepository} to access the database.
 * </p>
 */
public interface JpaSpecialistRepository extends JpaRepository<SpecialistEntity, UUID> {
    // No additional methods required. Basic CRUD operations are inherited from JpaRepository.
}
