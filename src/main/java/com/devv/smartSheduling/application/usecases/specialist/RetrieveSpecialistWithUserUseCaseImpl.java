package com.devv.smartSheduling.application.usecases.specialist;

import com.devv.smartSheduling.domain.model.Specialist;
import com.devv.smartSheduling.domain.ports.in.specialist.RetrieveSpecialistWithUserUseCase;
import com.devv.smartSheduling.domain.ports.out.SpecialistRepositoryPort;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class RetrieveSpecialistWithUserUseCaseImpl implements RetrieveSpecialistWithUserUseCase {

    private final SpecialistRepositoryPort specialistRepositoryPort;

    public RetrieveSpecialistWithUserUseCaseImpl(SpecialistRepositoryPort specialistRepositoryPort) {
        this.specialistRepositoryPort = specialistRepositoryPort;
    }


    @Override
    public Optional<Specialist> getSpecialistWithUser(UUID id) {
        return specialistRepositoryPort.findByIdWithUser(id);
    }

    @Override
    public List<Specialist> getAllSpecialistsWithUser() {
        return specialistRepositoryPort.findAllWithUser();
    }
}
