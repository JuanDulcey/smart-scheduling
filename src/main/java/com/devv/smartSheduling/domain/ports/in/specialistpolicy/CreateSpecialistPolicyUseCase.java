package com.devv.smartSheduling.domain.ports.in.specialistpolicy;

import com.devv.smartSheduling.domain.model.SpecialistPolicy;

/**
 * Input port for creating a new specialist policy.
 * <p>
 * This use case allows saving a new policy for a specialist.
 * </p>
 */
public interface CreateSpecialistPolicyUseCase {

    /**
     * Creates a new specialist policy.
     *
     * @param specialistPolicy the policy data to save
     * @return the created specialist policy with an assigned ID
     */
    SpecialistPolicy createSpecialistPolicy(SpecialistPolicy specialistPolicy);
}
