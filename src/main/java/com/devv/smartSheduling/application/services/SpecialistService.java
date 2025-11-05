package com.devv.smartSheduling.application.services;

import com.devv.smartSheduling.domain.model.Specialist;
import com.devv.smartSheduling.domain.ports.in.specialist.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Service class that manages all operations for {@link Specialist}.
 * <p>
 * This service connects the use cases to create, read, update,
 * and delete specialists. It also supports retrieving specialists
 * together with their user information.
 * </p>
 */
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

    /**
     * Constructor for {@code SpecialistService}.
     *
     * @param createSpecialistUseCase        use case for creating specialists
     * @param retrieveSpecialistUseCase      use case for getting specialists
     * @param updateSpecialistUseCase        use case for updating specialists
     * @param deleteSpecialistUseCase        use case for deleting specialists
     * @param retrieveSpecialistWithUserUseCase use case for getting specialists with user data
     */
    public SpecialistService(CreateSpecialistUseCase createSpecialistUseCase, RetrieveSpecialistUseCase retrieveSpecialistUseCase, UpdateSpecialistUseCase updateSpecialistUseCase, DeleteSpecialistUseCase deleteSpecialistUseCase, RetrieveSpecialistWithUserUseCase retrieveSpecialistWithUserUseCase) {
        this.createSpecialistUseCase = createSpecialistUseCase;
        this.retrieveSpecialistUseCase = retrieveSpecialistUseCase;
        this.updateSpecialistUseCase = updateSpecialistUseCase;
        this.deleteSpecialistUseCase = deleteSpecialistUseCase;
        this.retrieveSpecialistWithUserUseCase = retrieveSpecialistWithUserUseCase;
    }

    /**
     * Create a new {@link Specialist}.
     *
     * @param specialist the specialist to create
     * @return the created {@link Specialist}
     */
    @Override
    public Specialist createSpecialist(Specialist specialist) {
        return createSpecialistUseCase.createSpecialist(specialist);
    }

    /**
     * Delete a {@link Specialist} by its ID.
     *
     * @param id the ID of the specialist
     * @return {@code true} if deleted, {@code false} if not found
     */
    @Override
    public boolean deleteSpecialist(UUID id) {
        return deleteSpecialistUseCase.deleteSpecialist(id);
    }

    /**
     * Get one {@link Specialist} by ID.
     *
     * @param id the ID of the specialist
     * @return an {@link Optional} with the specialist if found
     */
    @Override
    public Optional<Specialist> getSpecialist(UUID id) {
        return retrieveSpecialistUseCase.getSpecialist(id);
    }

    /**
     * Get all {@link Specialist} records.
     *
     * @return a list of all specialists
     */
    @Override
    public List<Specialist> getAllSpecialists() {
        return retrieveSpecialistUseCase.getAllSpecialists();
    }

    /**
     * Update an existing {@link Specialist}.
     *
     * @param id          the ID of the specialist to update
     * @param updatedData new data for the specialist
     * @return an {@link Optional} with the updated specialist if successful
     */
    @Override
    public Optional<Specialist> updateSpecialist(UUID id, Specialist updatedData) {
        return updateSpecialistUseCase.updateSpecialist(id, updatedData);
    }

    /**
     * Get one {@link Specialist} together with its user data.
     *
     * @param id the ID of the specialist
     * @return an {@link Optional} with the specialist and its user if found
     */
    @Override
    public Optional<Specialist> getSpecialistWithUser(UUID id) {
        return retrieveSpecialistWithUserUseCase.getSpecialistWithUser(id);
    }

    /**
     * Get all {@link Specialist} records with their user data.
     *
     * @return a list of specialists with user information
     */
    @Override
    public List<Specialist> getAllSpecialistsWithUser() {
        return retrieveSpecialistWithUserUseCase.getAllSpecialistsWithUser();
    }
}
