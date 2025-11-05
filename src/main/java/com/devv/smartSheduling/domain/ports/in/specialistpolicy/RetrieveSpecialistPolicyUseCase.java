package com.devv.smartSheduling.domain.ports.in.specialistpolicy;

import com.devv.smartSheduling.domain.model.SpecialistPolicy;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Input port for retrieving specialist policies.
 * <p>
 * This use case allows getting one or all specialist policies from the system.
 * </p>
 */
public interface RetrieveSpecialistPolicyUseCase {

    /**
     * Get one specialist policy by its unique ID.
     *
     * @param id the unique ID of the specialist policy
     * @return an Optional with the policy if found, or empty if not found
     */
    Optional<SpecialistPolicy> getSpecialistPolicy(UUID id);

    /**
     * Get all specialist policies stored in the system.
     *
     * @return a list of all specialist policies
     */
    List<SpecialistPolicy> getAllSpecialistPolicies();
}
