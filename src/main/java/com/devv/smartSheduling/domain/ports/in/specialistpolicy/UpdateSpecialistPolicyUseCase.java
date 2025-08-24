package com.devv.smartSheduling.domain.ports.in.specialistpolicy;

import com.devv.smartSheduling.domain.model.SpecialistPolicy;

import java.util.Optional;
import java.util.UUID;

public interface UpdateSpecialistPolicyUseCase {
    /**
     * Caso de uso para actualizar un especialistapolicy existente.
     */
    Optional<SpecialistPolicy> updateSpecialistPolicy(UUID id, SpecialistPolicy updatedData);
}
