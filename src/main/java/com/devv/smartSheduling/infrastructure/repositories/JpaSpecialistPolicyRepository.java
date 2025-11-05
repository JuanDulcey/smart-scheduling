package com.devv.smartSheduling.infrastructure.repositories;

import com.devv.smartSheduling.infrastructure.entities.SpecialistPolicyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * JPA repository interface for SpecialistPolicyEntity.
 * <p>
 * Provides basic CRUD operations and query capabilities
 * for the {@link SpecialistPolicyEntity} using Spring Data JPA.
 * </p>
 */
public interface JpaSpecialistPolicyRepository extends JpaRepository<SpecialistPolicyEntity, UUID> {
    // No additional methods required. Basic CRUD operations are inherited from JpaRepository.
}
