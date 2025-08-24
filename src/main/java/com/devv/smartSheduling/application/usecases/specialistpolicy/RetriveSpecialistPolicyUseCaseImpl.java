package com.devv.smartSheduling.application.usecases.specialistpolicy;

import com.devv.smartSheduling.domain.model.SpecialistPolicy;
import com.devv.smartSheduling.domain.ports.in.specialistpolicy.RetrieveSpecialistPolicyUseCase;
import com.devv.smartSheduling.domain.ports.out.SpecialistPolicyRepositoryPort;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class RetriveSpecialistPolicyUseCaseImpl implements RetrieveSpecialistPolicyUseCase {

    private final SpecialistPolicyRepositoryPort specialistPolicyRepositoryPort;

    public RetriveSpecialistPolicyUseCaseImpl(SpecialistPolicyRepositoryPort specialistPolicyRepositoryPort) {
        this.specialistPolicyRepositoryPort = specialistPolicyRepositoryPort;
    }


    @Override
    public Optional<SpecialistPolicy> getSpecialistPolicy(UUID id) {
        return specialistPolicyRepositoryPort.findById(id);
    }

    @Override
    public List<SpecialistPolicy> getAllSpecialistPolicies() {
        return specialistPolicyRepositoryPort.findAll();
    }
}
