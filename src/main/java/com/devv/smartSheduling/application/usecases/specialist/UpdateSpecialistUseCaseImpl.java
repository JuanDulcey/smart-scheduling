package com.devv.smartSheduling.application.usecases.specialist;

import com.devv.smartSheduling.domain.model.Specialist;
import com.devv.smartSheduling.domain.ports.in.specialist.UpdateSpecialistUseCase;
import com.devv.smartSheduling.domain.ports.out.SpecialistRepositoryPort;

import java.util.Optional;
import java.util.UUID;

public class UpdateSpecialistUseCaseImpl implements UpdateSpecialistUseCase {

    private final SpecialistRepositoryPort specialistRepositoryPort;

    public UpdateSpecialistUseCaseImpl(SpecialistRepositoryPort specialistRepositoryPort) {
        this.specialistRepositoryPort = specialistRepositoryPort;
    }

    @Override
    public Optional<Specialist> updateSpecialist(UUID id, Specialist updatedData) {
        return specialistRepositoryPort.update(updatedData);
    }
}
