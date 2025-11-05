package com.devv.smartSheduling.infrastructure.repositories;

import com.devv.smartSheduling.infrastructure.entities.ResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * JPA repository interface for {@link ResourceEntity}.
 * <p>
 * Provides standard CRUD operations on the "resources" table
 * in the "directory_service" schema using Spring Data JPA.
 * </p>
 */
public interface JpaResourceRepository extends JpaRepository<ResourceEntity, UUID> {
    // No additional methods required. Basic CRUD operations are inherited from JpaRepository.
}
