package com.devv.smartSheduling.application.usecases.specialistpolicy;

import com.devv.smartSheduling.domain.model.SpecialistPolicy;
import com.devv.smartSheduling.domain.ports.in.specialistpolicy.UpdateSpecialistPolicyUseCase;
import com.devv.smartSheduling.domain.ports.out.SpecialistPolicyRepositoryPort;

import java.util.Optional;
import java.util.UUID;

/**
 * Implementation of {@link UpdateSpecialistPolicyUseCase}.
 * <p>
 * This class updates the information of a {@link SpecialistPolicy}
 * using the {@link SpecialistPolicyRepositoryPort}.
 * </p>
 */
public class UpdateSpecialistPolicyUseCaseImpl implements UpdateSpecialistPolicyUseCase {

    private final SpecialistPolicyRepositoryPort specialistPolicyRepositoryPort;

    /**
     * Constructor for {@code UpdateSpecialistPolicyUseCaseImpl}.
     *
     * @param specialistPolicyRepositoryPort the repository port used to update specialist policies
     */
    public UpdateSpecialistPolicyUseCaseImpl(SpecialistPolicyRepositoryPort specialistPolicyRepositoryPort) {
        this.specialistPolicyRepositoryPort = specialistPolicyRepositoryPort;
    }

    /**
     * Update a specialist policy with new data.
     *
     * @param id the ID of the specialist policy to update
     * @param updatedData the new information for the specialist policy
     * @return an {@link Optional} with the updated specialist policy if found
     */
    @Override
    public Optional<SpecialistPolicy> updateSpecialistPolicy(UUID id, SpecialistPolicy updatedData) {
        return specialistPolicyRepositoryPort.update(updatedData);
    }
}
