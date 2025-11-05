package com.devv.smartSheduling.domain.ports.in.resource;

import com.devv.smartSheduling.domain.model.Resource;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Input port for reading resource information.
 * <p>
 * This use case allows to get one resource by ID or get all resources in the system.
 * </p>
 */
public interface RetrieveResourceUseCase {

    /**
     * Finds one resource by ID.
     *
     * @param id the unique identifier of the resource
     * @return an Optional with the resource, or empty if not found
     */
    Optional<Resource> getResource(UUID id);

    /**
     * Returns all resources in the system.
     *
     * @return a list with all resources
     */
    List<Resource> getAllResources();
}
