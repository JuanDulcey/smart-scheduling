package com.devv.smartSheduling.domain.ports.in.specialist;

import com.devv.smartSheduling.domain.model.Specialist;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Input port for retrieving specialists with their user information.
 * <p>
 * This use case allows getting one specialist with user data,
 * or getting a list of all specialists and their users.
 * </p>
 */
public interface RetrieveSpecialistWithUserUseCase {

    /**
     * Finds one specialist with user information.
     *
     * @param id the unique ID of the specialist
     * @return an Optional with the specialist and user, or empty if not found
     */
    Optional<Specialist> getSpecialistWithUser(UUID id);

    /**
     * Gets all specialists with their user information.
     *
     * @return a list with specialists and their users
     */
    List<Specialist> getAllSpecialistsWithUser();
}
