package com.devv.smartSheduling.domain.ports.in.specialist;

import com.devv.smartSheduling.domain.model.Specialist;

/**
 * Input port for creating a new specialist.
 * <p>
 * This use case adds a new specialist to the system.
 * </p>
 */
public interface CreateSpecialistUseCase {

    /**
     * Creates a new specialist in the system.
     *
     * @param specialist the specialist data to create
     * @return the created specialist with an assigned ID
     */
    Specialist createSpecialist(Specialist specialist);
}
