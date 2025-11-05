package com.devv.smartSheduling.domain.ports.in.resource;

import java.util.UUID;

/**
 * Input port for deleting a resource.
 * <p>
 * This use case allows to delete a {@code Resource} using its unique ID.
 * </p>
 */
public interface DeleteResourceUseCase {

    /**
     * Deletes a resource by ID.
     *
     * @param id the unique identifier of the resource
     * @return true if the resource was deleted, false if not found
     */
    boolean deleteResource(UUID id);
}
