package com.devv.smartSheduling.domain.ports.out;

import com.devv.smartSheduling.domain.model.Specialist;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Output port for Specialist persistence operations.
 * <p>
 * Defines the operations that any repository implementation
 * must provide to interact with the {@link Specialist} domain entity.
 * </p>
 */
public interface SpecialistRepositoryPort {

    /**
     * Save or update a specialist.
     *
     * @param specialist the entity to save
     * @return the saved entity
     */
    Specialist save(Specialist specialist);

    /**
     * Find a specialist by its unique ID.
     *
     * @param id the unique identifier
     * @return an {@link Optional} with the specialist if found, or empty if not
     */
    Optional<Specialist> findById(UUID id);

    /**
     * Get all specialists.
     *
     * @return list of all specialists
     */
    List<Specialist> findAll();

    /**
     * Delete a specialist by its unique ID.
     *
     * @param id the unique identifier
     * @return {@code true} if deleted, {@code false} if not found
     */
    boolean deleteById(UUID id);

    /**
     * Update an existing specialist.
     *
     * @param specialist the entity with updated data
     * @return an {@link Optional} with the updated specialist if found, or empty if not
     */
    Optional<Specialist> update(Specialist specialist);


    /**
     * Find a specialist and load its associated user.
     *
     * @param id the specialist unique ID
     * @return an {@link Optional} with the specialist and its user if found, or empty if not
     */
    Optional<Specialist> findByIdWithUser(UUID id);

    /**
     * Get all specialists including their associated users.
     *
     * @return list of specialists with their user data
     */
    List<Specialist> findAllWithUser();
}
