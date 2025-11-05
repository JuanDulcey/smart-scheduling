package com.devv.smartSheduling.domain.ports.in.specialist;

import com.devv.smartSheduling.domain.model.Specialist;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Input port for retrieving specialists.
 * <p>
 * This use case allows getting one specialist by ID
 * or listing all specialists in the system.
 * </p>
 */
public interface RetrieveSpecialistUseCase {

    /**
     * Finds one specialist by ID.
     *
     * @param id the unique ID of the specialist
     * @return an Optional with the specialist if found, or empty if not
     */
    Optional<Specialist> getSpecialist(UUID id);

    /**
     * Gets all specialists in the system.
     *
     * @return a list with all specialists
     */
    List<Specialist> getAllSpecialists();
}
