package com.devv.smartSheduling.application.usecases.specialistpolicy;

import com.devv.smartSheduling.domain.model.SpecialistPolicy;
import com.devv.smartSheduling.domain.ports.in.specialistpolicy.CreateSpecialistPolicyUseCase;
import com.devv.smartSheduling.domain.ports.out.SpecialistPolicyRepositoryPort;

/**
 * Implementation of {@link CreateSpecialistPolicyUseCase}.
 * <p>
 * This class is responsible for creating a new {@link SpecialistPolicy}
 * using the {@link SpecialistPolicyRepositoryPort}.
 * </p>
 */
public class CreateSpecialistPolicyUseCaseImpl implements CreateSpecialistPolicyUseCase {

    private final SpecialistPolicyRepositoryPort specialistPolicyRepositoryPort;

    /**
     * Constructor for {@code CreateSpecialistPolicyUseCaseImpl}.
     *
     * @param specialistPolicyRepositoryPort the repository port used to save specialist policies
     */
    public CreateSpecialistPolicyUseCaseImpl(SpecialistPolicyRepositoryPort specialistPolicyRepositoryPort) {
        this.specialistPolicyRepositoryPort = specialistPolicyRepositoryPort;
    }

    /**
     * Create and save a new specialist policy.
     *
     * @param specialistPolicy the policy data to create
     * @return the created {@link SpecialistPolicy}
     */
    @Override
    public SpecialistPolicy createSpecialistPolicy(SpecialistPolicy specialistPolicy) {
        return specialistPolicyRepositoryPort.save(specialistPolicy);
    }
}
