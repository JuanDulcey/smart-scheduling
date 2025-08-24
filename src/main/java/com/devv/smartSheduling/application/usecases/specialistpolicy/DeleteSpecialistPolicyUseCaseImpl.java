package com.devv.smartSheduling.application.usecases.specialistpolicy;

import com.devv.smartSheduling.domain.ports.in.specialist.DeleteSpecialistUseCase;
import com.devv.smartSheduling.domain.ports.in.specialistpolicy.DeleteSpecialistPolicyUseCase;
import com.devv.smartSheduling.domain.ports.out.SpecialistPolicyRepositoryPort;

import java.util.UUID;

public class DeleteSpecialistPolicyUseCaseImpl implements DeleteSpecialistPolicyUseCase {

    private final SpecialistPolicyRepositoryPort  specialistPolicyRepositoryPort;

    public DeleteSpecialistPolicyUseCaseImpl(SpecialistPolicyRepositoryPort specialistPolicyRepositoryPort) {
        this.specialistPolicyRepositoryPort = specialistPolicyRepositoryPort;
    }

    @Override
    public boolean deleteSpecialistPolicy(UUID id) {
        return specialistPolicyRepositoryPort.deleteById(id);
    }
}
