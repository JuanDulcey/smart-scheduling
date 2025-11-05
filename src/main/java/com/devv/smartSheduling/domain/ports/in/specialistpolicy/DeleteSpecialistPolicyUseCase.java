package com.devv.smartSheduling.domain.ports.in.specialistpolicy;

import java.util.UUID;

/**
 * Input port for deleting a specialist policy.
 * <p>
 * This use case allows removing a policy by its unique ID.
 * </p>
 */
public interface DeleteSpecialistPolicyUseCase {

    /**
     * Deletes a specialist policy by ID.
     *
     * @param id the unique ID of the policy to delete
     * @return true if the policy was deleted, false if not found
     */
    boolean deleteSpecialistPolicy(UUID id);
}
