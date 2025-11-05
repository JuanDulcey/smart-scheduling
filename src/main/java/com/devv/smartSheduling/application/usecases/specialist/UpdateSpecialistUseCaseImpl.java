package com.devv.smartSheduling.application.usecases.specialist;

import com.devv.smartSheduling.domain.model.Specialist;
import com.devv.smartSheduling.domain.ports.in.specialist.UpdateSpecialistUseCase;
import com.devv.smartSheduling.domain.ports.out.SpecialistRepositoryPort;

import java.util.Optional;
import java.util.UUID;

/**
 * Implementation of {@link UpdateSpecialistUseCase}.
 * <p>
 * This class updates the information of a {@link Specialist}
 * using the {@link SpecialistRepositoryPort}.
 * </p>
 */
public class UpdateSpecialistUseCaseImpl implements UpdateSpecialistUseCase {

    private final SpecialistRepositoryPort specialistRepositoryPort;

    /**
     * Constructor for {@code UpdateSpecialistUseCaseImpl}.
     *
     * @param specialistRepositoryPort the repository port used to update specialists
     */
    public UpdateSpecialistUseCaseImpl(SpecialistRepositoryPort specialistRepositoryPort) {
        this.specialistRepositoryPort = specialistRepositoryPort;
    }

    /**
     * Update a specialist with new data.
     *
     * @param id the ID of the specialist to update
     * @param updatedData the new data for the specialist
     * @return an {@link Optional} with the updated specialist if found
     */
    @Override
    public Optional<Specialist> updateSpecialist(UUID id, Specialist updatedData) {
        return specialistRepositoryPort.update(updatedData);
    }
}
