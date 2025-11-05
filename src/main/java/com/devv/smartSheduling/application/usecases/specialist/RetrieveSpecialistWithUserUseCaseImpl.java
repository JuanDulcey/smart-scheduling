package com.devv.smartSheduling.application.usecases.specialist;

import com.devv.smartSheduling.domain.model.Specialist;
import com.devv.smartSheduling.domain.ports.in.specialist.RetrieveSpecialistWithUserUseCase;
import com.devv.smartSheduling.domain.ports.out.SpecialistRepositoryPort;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Implementation of {@link RetrieveSpecialistWithUserUseCase}.
 * <p>
 * This class gets {@link Specialist} objects with their related user data
 * from the {@link SpecialistRepositoryPort}.
 * </p>
 */
public class RetrieveSpecialistWithUserUseCaseImpl implements RetrieveSpecialistWithUserUseCase {

    private final SpecialistRepositoryPort specialistRepositoryPort;

    /**
     * Constructor for {@code RetrieveSpecialistWithUserUseCaseImpl}.
     *
     * @param specialistRepositoryPort the repository port used to get specialists with user data
     */
    public RetrieveSpecialistWithUserUseCaseImpl(SpecialistRepositoryPort specialistRepositoryPort) {
        this.specialistRepositoryPort = specialistRepositoryPort;
    }

    /**
     * Get one specialist with user information by ID.
     *
     * @param id the ID of the specialist
     * @return an {@link Optional} with the specialist and its user if found
     */
    @Override
    public Optional<Specialist> getSpecialistWithUser(UUID id) {
        return specialistRepositoryPort.findByIdWithUser(id);
    }

    /**
     * Get all specialists with their user information.
     *
     * @return a list with all {@link Specialist} objects and their users
     */
    @Override
    public List<Specialist> getAllSpecialistsWithUser() {
        return specialistRepositoryPort.findAllWithUser();
    }
}
