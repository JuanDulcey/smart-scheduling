package com.devv.smartSheduling.application.usecases.specialist;

import com.devv.smartSheduling.domain.model.Specialist;
import com.devv.smartSheduling.domain.ports.in.specialist.CreateSpecialistUseCase;
import com.devv.smartSheduling.domain.ports.out.SpecialistRepositoryPort;

public class CreateSpecialistUseCaseImpl implements CreateSpecialistUseCase {

    private final SpecialistRepositoryPort specialistRepositoryPort;

    public CreateSpecialistUseCaseImpl(SpecialistRepositoryPort specialistRepositoryPort) {
        this.specialistRepositoryPort = specialistRepositoryPort;
    }

    @Override
    public Specialist createSpecialist(Specialist specialist) {
        return specialistRepositoryPort.save(specialist);
    }
}
