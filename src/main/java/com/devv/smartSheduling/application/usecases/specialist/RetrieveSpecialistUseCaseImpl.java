package com.devv.smartSheduling.application.usecases.specialist;

import com.devv.smartSheduling.domain.model.Specialist;
import com.devv.smartSheduling.domain.ports.in.specialist.RetrieveSpecialistUseCase;
import com.devv.smartSheduling.domain.ports.out.SpecialistRepositoryPort;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Implementation of {@link RetrieveSpecialistUseCase}.
 * <p>
 * This class gets one or all {@link Specialist} objects
 * from the {@link SpecialistRepositoryPort}.
 * </p>
 */
public class RetrieveSpecialistUseCaseImpl implements RetrieveSpecialistUseCase {

    private final SpecialistRepositoryPort specialistRepositoryPort;

    /**
     * Constructor for {@code RetrieveSpecialistUseCaseImpl}.
     *
     * @param specialistRepositoryPort the repository port used to get specialists
     */
    public RetrieveSpecialistUseCaseImpl(SpecialistRepositoryPort specialistRepositoryPort) {
        this.specialistRepositoryPort = specialistRepositoryPort;
    }

    /**
     * Get one specialist by ID.
     *
     * @param id the ID of the specialist
     * @return an {@link Optional} with the specialist if found
     */
    @Override
    public Optional<Specialist> getSpecialist(UUID id) {
        return specialistRepositoryPort.findById(id);
    }

    /**
     * Get all specialists.
     *
     * @return a list with all {@link Specialist} objects
     */
    @Override
    public List<Specialist> getAllSpecialists() {
        return specialistRepositoryPort.findAll();
    }
}
