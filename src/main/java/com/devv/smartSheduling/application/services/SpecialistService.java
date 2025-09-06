package com.devv.smartSheduling.application.services;

import com.devv.smartSheduling.domain.model.Specialist;
import com.devv.smartSheduling.domain.ports.in.specialist.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class SpecialistService implements
        CreateSpecialistUseCase,
        DeleteSpecialistUseCase,
        RetrieveSpecialistUseCase,
        UpdateSpecialistUseCase,
        RetrieveSpecialistWithUserUseCase {

    private final CreateSpecialistUseCase createSpecialistUseCase;
    private final RetrieveSpecialistUseCase retrieveSpecialistUseCase;
    private final UpdateSpecialistUseCase updateSpecialistUseCase;
    private final DeleteSpecialistUseCase deleteSpecialistUseCase;
    private final RetrieveSpecialistWithUserUseCase retrieveSpecialistWithUserUseCase;

    public SpecialistService(CreateSpecialistUseCase createSpecialistUseCase, RetrieveSpecialistUseCase retrieveSpecialistUseCase, UpdateSpecialistUseCase updateSpecialistUseCase, DeleteSpecialistUseCase deleteSpecialistUseCase, RetrieveSpecialistWithUserUseCase retrieveSpecialistWithUserUseCase) {
        this.createSpecialistUseCase = createSpecialistUseCase;
        this.retrieveSpecialistUseCase = retrieveSpecialistUseCase;
        this.updateSpecialistUseCase = updateSpecialistUseCase;
        this.deleteSpecialistUseCase = deleteSpecialistUseCase;
        this.retrieveSpecialistWithUserUseCase = retrieveSpecialistWithUserUseCase;
    }

    @Override
    public Specialist createSpecialist(Specialist specialist) {
        return createSpecialistUseCase.createSpecialist(specialist);
    }

    @Override
    public boolean deleteSpecialist(UUID id) {
        return deleteSpecialistUseCase.deleteSpecialist(id);
    }

    @Override
    public Optional<Specialist> getSpecialist(UUID id) {
        return retrieveSpecialistUseCase.getSpecialist(id);
    }

    @Override
    public List<Specialist> getAllSpecialists() {
        return retrieveSpecialistUseCase.getAllSpecialists();
    }

    @Override
    public Optional<Specialist> updateSpecialist(UUID id, Specialist updatedData) {
        return updateSpecialistUseCase.updateSpecialist(id, updatedData);
    }


    @Override
    public Optional<Specialist> getSpecialistWithUser(UUID id) {
        return retrieveSpecialistWithUserUseCase.getSpecialistWithUser(id);
    }

    @Override
    public List<Specialist> getAllSpecialistsWithUser() {
        return retrieveSpecialistWithUserUseCase.getAllSpecialistsWithUser();
    }
}
