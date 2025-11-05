package com.devv.smartSheduling.application.usecases.specialist;

import com.devv.smartSheduling.domain.model.Specialist;
import com.devv.smartSheduling.domain.ports.in.specialist.CreateSpecialistUseCase;
import com.devv.smartSheduling.domain.ports.out.SpecialistRepositoryPort;

/**
 * Implementation of {@link CreateSpecialistUseCase}.
 * <p>
 * This class creates a new {@link Specialist} using
 * the {@link SpecialistRepositoryPort}.
 * </p>
 */
public class CreateSpecialistUseCaseImpl implements CreateSpecialistUseCase {

    private final SpecialistRepositoryPort specialistRepositoryPort;

    /**
     * Constructor for {@code CreateSpecialistUseCaseImpl}.
     *
     * @param specialistRepositoryPort the repository port used to save specialists
     */
    public CreateSpecialistUseCaseImpl(SpecialistRepositoryPort specialistRepositoryPort) {
        this.specialistRepositoryPort = specialistRepositoryPort;
    }

    /**
     * Create a new {@link Specialist}.
     *
     * @param specialist the specialist object to create
     * @return the created specialist
     */
    @Override
    public Specialist createSpecialist(Specialist specialist) {
        return specialistRepositoryPort.save(specialist);
    }
}
