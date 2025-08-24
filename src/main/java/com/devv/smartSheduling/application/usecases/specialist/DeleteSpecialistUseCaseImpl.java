package com.devv.smartSheduling.application.usecases.specialist;

import com.devv.smartSheduling.domain.ports.in.specialist.DeleteSpecialistUseCase;
import com.devv.smartSheduling.domain.ports.out.SpecialistRepositoryPort;

import java.util.UUID;

public class DeleteSpecialistUseCaseImpl implements DeleteSpecialistUseCase {

    private final SpecialistRepositoryPort specialistRepositoryPort;

    public DeleteSpecialistUseCaseImpl(SpecialistRepositoryPort specialistRepositoryPort) {
        this.specialistRepositoryPort = specialistRepositoryPort;
    }


    @Override
    public boolean deleteSpecialist(UUID id) {
        return specialistRepositoryPort.deleteById(id);
    }
}
