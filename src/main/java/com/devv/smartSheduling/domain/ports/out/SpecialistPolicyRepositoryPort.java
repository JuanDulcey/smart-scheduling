package com.devv.smartSheduling.domain.ports.out;

import com.devv.smartSheduling.domain.model.SpecialistPolicy;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Output port for Specialist Policy persistence.
 * <p>
 * Defines the operations that any repository implementation
 * must provide to interact with the {@link SpecialistPolicy} domain entity.
 * </p>
 */
public interface SpecialistPolicyRepositoryPort {

    /**
     * Save or update a specialist policy.
     *
     * @param specialistPolicy the entity to save
     * @return the saved entity
     */
    SpecialistPolicy save(SpecialistPolicy specialistPolicy);

    /**
     * Find a policy by its unique ID.
     *
     * @param id the unique identifier
     * @return an {@link Optional} with the policy if found, or empty if not
     */
    Optional<SpecialistPolicy> findById(UUID id);

    /**
     * Get all specialist policies.
     *
     * @return list of all policies
     */
    List<SpecialistPolicy> findAll();

    /**
     * Delete a policy by its unique ID.
     *
     * @param id the unique identifier
     * @return {@code true} if deleted, {@code false} if not found
     */
    boolean deleteById(UUID id);

    /**
     * Update an existing specialist policy.
     *
     * @param specialistPolicy the entity with updated data
     * @return an {@link Optional} with the updated policy if found, or empty if not
     */
    Optional<SpecialistPolicy> update(SpecialistPolicy specialistPolicy);
}

