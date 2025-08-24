package com.devv.smartSheduling.application.services;

import com.devv.smartSheduling.domain.model.SpecialistPolicy;
import com.devv.smartSheduling.domain.ports.in.specialistpolicy.CreateSpecialistPolicyUseCase;
import com.devv.smartSheduling.domain.ports.in.specialistpolicy.DeleteSpecialistPolicyUseCase;
import com.devv.smartSheduling.domain.ports.in.specialistpolicy.RetrieveSpecialistPolicyUseCase;
import com.devv.smartSheduling.domain.ports.in.specialistpolicy.UpdateSpecialistPolicyUseCase;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class SpecialistPolicyService implements
        CreateSpecialistPolicyUseCase,
        DeleteSpecialistPolicyUseCase,
        RetrieveSpecialistPolicyUseCase,
        UpdateSpecialistPolicyUseCase{

    private final CreateSpecialistPolicyUseCase createSpecialistPolicyUseCase;
    private final DeleteSpecialistPolicyUseCase deleteSpecialistPolicyUseCase;
    private final RetrieveSpecialistPolicyUseCase retrieveSpecialistPolicyUseCase;
    private final UpdateSpecialistPolicyUseCase updateSpecialistPolicyUseCase;

    public SpecialistPolicyService(CreateSpecialistPolicyUseCase createSpecialistPolicyUseCase, DeleteSpecialistPolicyUseCase deleteSpecialistPolicyUseCase, RetrieveSpecialistPolicyUseCase retrieveSpecialistPolicyUseCase, UpdateSpecialistPolicyUseCase updateSpecialistPolicyUseCase) {
        this.createSpecialistPolicyUseCase = createSpecialistPolicyUseCase;
        this.deleteSpecialistPolicyUseCase = deleteSpecialistPolicyUseCase;
        this.retrieveSpecialistPolicyUseCase = retrieveSpecialistPolicyUseCase;
        this.updateSpecialistPolicyUseCase = updateSpecialistPolicyUseCase;
    }

    @Override
    public SpecialistPolicy createSpecialistPolicy(SpecialistPolicy specialistPolicy) {
        return createSpecialistPolicyUseCase.createSpecialistPolicy(specialistPolicy);
    }

    @Override
    public boolean deleteSpecialistPolicy(UUID id) {
        return deleteSpecialistPolicyUseCase.deleteSpecialistPolicy(id);
    }

    @Override
    public Optional<SpecialistPolicy> getSpecialistPolicy(UUID id) {
        return retrieveSpecialistPolicyUseCase.getSpecialistPolicy(id);
    }

    @Override
    public List<SpecialistPolicy> getAllSpecialistPolicies() {
        return retrieveSpecialistPolicyUseCase.getAllSpecialistPolicies();
    }

    @Override
    public Optional<SpecialistPolicy> updateSpecialistPolicy(UUID id, SpecialistPolicy updatedData) {
        return updateSpecialistPolicyUseCase.updateSpecialistPolicy(id, updatedData);
    }
}
