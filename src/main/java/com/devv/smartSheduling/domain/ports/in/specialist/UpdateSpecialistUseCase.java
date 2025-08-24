package com.devv.smartSheduling.domain.ports.in.specialist;

import com.devv.smartSheduling.domain.model.Specialist;

import java.util.Optional;
import java.util.UUID;

public interface UpdateSpecialistUseCase {
    /**
     * Caso de uso para actualizar un especialista existente.
     */
    Optional<Specialist> updateSpecialist(UUID id, Specialist updatedData);
}
