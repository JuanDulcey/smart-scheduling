package com.devv.smartSheduling.domain.ports.in.specialist;

import com.devv.smartSheduling.domain.model.Specialist;

import java.util.Optional;
import java.util.UUID;

/**
 * Input port for updating an existing specialist.
 * <p>
 * This use case allows changing the data of a specialist
 * using their unique ID.
 * </p>
 */
public interface UpdateSpecialistUseCase {

    /**
     * Updates a specialist with new information.
     *
     * @param id          the unique ID of the specialist
     * @param updatedData the new data to update
     * @return an Optional with the updated specialist, or empty if not found
     */
    Optional<Specialist> updateSpecialist(UUID id, Specialist updatedData);
}
