package com.devv.smartSheduling.domain.ports.in.specialist;

import java.util.UUID;

/**
 * Input port for deleting a specialist.
 * <p>
 * This use case removes a specialist from the system using their ID.
 * </p>
 */
public interface DeleteSpecialistUseCase {

    /**
     * Deletes a specialist by ID.
     *
     * @param id the unique ID of the specialist
     * @return true if the specialist was deleted, false if not found
     */
    boolean deleteSpecialist(UUID id);
}
