package com.devv.smartSheduling.application.usecases.specialist;

import com.devv.smartSheduling.domain.ports.in.specialist.DeleteSpecialistUseCase;
import com.devv.smartSheduling.domain.ports.out.SpecialistRepositoryPort;

import java.util.UUID;

/**
 * Implementation of {@link DeleteSpecialistUseCase}.
 * <p>
 * This class deletes a {@link com.devv.smartSheduling.domain.model.Specialist}
 * using the {@link SpecialistRepositoryPort}.
 * </p>
 */
public class DeleteSpecialistUseCaseImpl implements DeleteSpecialistUseCase {

    private final SpecialistRepositoryPort specialistRepositoryPort;

    /**
     * Constructor for {@code DeleteSpecialistUseCaseImpl}.
     *
     * @param specialistRepositoryPort the repository port used to delete specialists
     */
    public DeleteSpecialistUseCaseImpl(SpecialistRepositoryPort specialistRepositoryPort) {
        this.specialistRepositoryPort = specialistRepositoryPort;
    }

    /**
     * Delete a specialist by ID.
     *
     * @param id the ID of the specialist to delete
     * @return true if the specialist was deleted, false otherwise
     */
    @Override
    public boolean deleteSpecialist(UUID id) {
        return specialistRepositoryPort.deleteById(id);
    }
}
