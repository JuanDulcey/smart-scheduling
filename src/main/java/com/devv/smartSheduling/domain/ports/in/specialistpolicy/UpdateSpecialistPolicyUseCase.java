package com.devv.smartSheduling.domain.ports.in.specialistpolicy;

import com.devv.smartSheduling.domain.model.SpecialistPolicy;

import java.util.Optional;
import java.util.UUID;

/**
 * Input port for updating an existing specialist policy.
 * <p>
 * This use case allows changing the information of a specialist policy
 * already stored in the system.
 * </p>
 */
public interface UpdateSpecialistPolicyUseCase {

    /**
     * Update a specialist policy by its unique ID.
     *
     * @param id the unique ID of the specialist policy
     * @param updatedData the new data to update the policy
     * @return an Optional with the updated policy if found, or empty if not found
     */
    Optional<SpecialistPolicy> updateSpecialistPolicy(UUID id, SpecialistPolicy updatedData);
}
