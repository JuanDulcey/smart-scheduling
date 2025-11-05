package com.devv.smartSheduling.application.usecases.specialistpolicy;

import com.devv.smartSheduling.domain.model.SpecialistPolicy;
import com.devv.smartSheduling.domain.ports.in.specialistpolicy.RetrieveSpecialistPolicyUseCase;
import com.devv.smartSheduling.domain.ports.out.SpecialistPolicyRepositoryPort;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Implementation of {@link RetrieveSpecialistPolicyUseCase}.
 * <p>
 * This class is responsible for getting one or many {@link SpecialistPolicy}
 * objects using the {@link SpecialistPolicyRepositoryPort}.
 * </p>
 */
public class RetrieveSpecialistPolicyUseCaseImpl implements RetrieveSpecialistPolicyUseCase {

    private final SpecialistPolicyRepositoryPort specialistPolicyRepositoryPort;

    /**
     * Constructor for {@code RetrieveSpecialistPolicyUseCaseImpl}.
     *
     * @param specialistPolicyRepositoryPort the repository port used to get specialist policies
     */
    public RetrieveSpecialistPolicyUseCaseImpl(SpecialistPolicyRepositoryPort specialistPolicyRepositoryPort) {
        this.specialistPolicyRepositoryPort = specialistPolicyRepositoryPort;
    }

    /**
     * Get one specialist policy by ID.
     *
     * @param id the ID of the specialist policy
     * @return an {@link Optional} with the found specialist policy, or empty if not found
     */
    @Override
    public Optional<SpecialistPolicy> getSpecialistPolicy(UUID id) {
        return specialistPolicyRepositoryPort.findById(id);
    }

    /**
     * Get all specialist policies.
     *
     * @return a list with all {@link SpecialistPolicy} objects
     */
    @Override
    public List<SpecialistPolicy> getAllSpecialistPolicies() {
        return specialistPolicyRepositoryPort.findAll();
    }
}
