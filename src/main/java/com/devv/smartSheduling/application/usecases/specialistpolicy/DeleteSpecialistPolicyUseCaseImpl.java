package com.devv.smartSheduling.application.usecases.specialistpolicy;

import com.devv.smartSheduling.domain.ports.in.specialistpolicy.DeleteSpecialistPolicyUseCase;
import com.devv.smartSheduling.domain.ports.out.SpecialistPolicyRepositoryPort;

import java.util.UUID;

/**
 * Implementation of {@link DeleteSpecialistPolicyUseCase}.
 * <p>
 * This class is responsible for deleting a {@link com.devv.smartSheduling.domain.model.SpecialistPolicy}
 * using the {@link SpecialistPolicyRepositoryPort}.
 * </p>
 */
public class DeleteSpecialistPolicyUseCaseImpl implements DeleteSpecialistPolicyUseCase {

    private final SpecialistPolicyRepositoryPort  specialistPolicyRepositoryPort;

    /**
     * Constructor for {@code DeleteSpecialistPolicyUseCaseImpl}.
     *
     * @param specialistPolicyRepositoryPort the repository port used to delete specialist policies
     */
    public DeleteSpecialistPolicyUseCaseImpl(SpecialistPolicyRepositoryPort specialistPolicyRepositoryPort) {
        this.specialistPolicyRepositoryPort = specialistPolicyRepositoryPort;
    }

    /**
     * Delete a specialist policy by its ID.
     *
     * @param id the ID of the specialist policy to delete
     * @return true if the policy was deleted, false otherwise
     */
    @Override
    public boolean deleteSpecialistPolicy(UUID id) {
        return specialistPolicyRepositoryPort.deleteById(id);
    }
}
