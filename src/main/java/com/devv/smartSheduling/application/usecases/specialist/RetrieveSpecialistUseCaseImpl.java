package com.devv.smartSheduling.application.usecases.specialist;

import com.devv.smartSheduling.domain.model.Specialist;
import com.devv.smartSheduling.domain.ports.in.specialist.RetrieveSpecialistUseCase;
import com.devv.smartSheduling.domain.ports.out.SpecialistRepositoryPort;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class RetrieveSpecialistUseCaseImpl implements RetrieveSpecialistUseCase {

    private final SpecialistRepositoryPort specialistRepositoryPort;

    public RetrieveSpecialistUseCaseImpl(SpecialistRepositoryPort specialistRepositoryPort) {
        this.specialistRepositoryPort = specialistRepositoryPort;
    }

    @Override
    public Optional<Specialist> getSpecialist(UUID id) {
        return specialistRepositoryPort.findById(id);
    }

    @Override
    public List<Specialist> getAllSpecialists() {
        return specialistRepositoryPort.findAll();
    }
}
