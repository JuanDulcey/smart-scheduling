package com.devv.smartSheduling.application.usecases.specialistpolicy;

import com.devv.smartSheduling.domain.model.SpecialistPolicy;
import com.devv.smartSheduling.domain.ports.in.specialistpolicy.CreateSpecialistPolicyUseCase;
import com.devv.smartSheduling.domain.ports.out.SpecialistPolicyRepositoryPort;

public class CreateSpecialistPolicyUseCaseImpl implements CreateSpecialistPolicyUseCase {

    private final SpecialistPolicyRepositoryPort specialistPolicyRepositoryPort;

    public CreateSpecialistPolicyUseCaseImpl(SpecialistPolicyRepositoryPort specialistPolicyRepositoryPort) {
        this.specialistPolicyRepositoryPort = specialistPolicyRepositoryPort;
    }


    @Override
    public SpecialistPolicy createSpecialistPolicy(SpecialistPolicy specialistPolicy) {
        return specialistPolicyRepositoryPort.save(specialistPolicy);
    }
}
