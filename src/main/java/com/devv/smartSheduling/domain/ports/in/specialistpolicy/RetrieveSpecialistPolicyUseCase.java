package com.devv.smartSheduling.domain.ports.in.specialistpolicy;

import com.devv.smartSheduling.domain.model.SpecialistPolicy;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RetrieveSpecialistPolicyUseCase {
    Optional<SpecialistPolicy> getSpecialistPolicy(UUID id);
    List<SpecialistPolicy> getAllSpecialistPolicies();
}
