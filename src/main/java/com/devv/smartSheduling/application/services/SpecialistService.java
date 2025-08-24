package com.devv.smartSheduling.application.services;

import com.devv.smartSheduling.domain.model.Specialist;
import com.devv.smartSheduling.domain.ports.in.specialist.CreateSpecialistUseCase;
import com.devv.smartSheduling.domain.ports.in.specialist.DeleteSpecialistUseCase;
import com.devv.smartSheduling.domain.ports.in.specialist.RetrieveSpecialistUseCase;
import com.devv.smartSheduling.domain.ports.in.specialist.UpdateSpecialistUseCase;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class SpecialistService implements
        CreateSpecialistUseCase,
        DeleteSpecialistUseCase,
        RetrieveSpecialistUseCase,
        UpdateSpecialistUseCase{

    private final CreateSpecialistUseCase createSpecialistUseCase;
    private final RetrieveSpecialistUseCase retrieveSpecialistUseCase;
    private final UpdateSpecialistUseCase updateSpecialistUseCase;
    private final DeleteSpecialistUseCase deleteSpecialistUseCase;

    public SpecialistService(CreateSpecialistUseCase createSpecialistUseCase, RetrieveSpecialistUseCase retrieveSpecialistUseCase, UpdateSpecialistUseCase updateSpecialistUseCase, DeleteSpecialistUseCase deleteSpecialistUseCase) {
        this.createSpecialistUseCase = createSpecialistUseCase;
        this.retrieveSpecialistUseCase = retrieveSpecialistUseCase;
        this.updateSpecialistUseCase = updateSpecialistUseCase;
        this.deleteSpecialistUseCase = deleteSpecialistUseCase;
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
}
