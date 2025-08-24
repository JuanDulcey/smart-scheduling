package com.devv.smartSheduling.application.usecases.specialistpolicy;

import com.devv.smartSheduling.domain.model.SpecialistPolicy;
import com.devv.smartSheduling.domain.ports.in.specialistpolicy.UpdateSpecialistPolicyUseCase;
import com.devv.smartSheduling.domain.ports.out.SpecialistPolicyRepositoryPort;

import java.util.Optional;
import java.util.UUID;

public class UpdateSpecialistPolicyUseCaseImpl implements UpdateSpecialistPolicyUseCase {

    private final SpecialistPolicyRepositoryPort specialistPolicyRepositoryPort;

    public UpdateSpecialistPolicyUseCaseImpl(SpecialistPolicyRepositoryPort specialistPolicyRepositoryPort) {
        this.specialistPolicyRepositoryPort = specialistPolicyRepositoryPort;
    }


    @Override
    public Optional<SpecialistPolicy> updateSpecialistPolicy(UUID id, SpecialistPolicy updatedData) {
        return specialistPolicyRepositoryPort.update(updatedData);
    }
}
