package com.devv.smartSheduling.domain.ports.in.resource;

import com.devv.smartSheduling.domain.model.Resource;

import java.util.Optional;
import java.util.UUID;

/**
 * Input port for updating a resource.
 * <p>
 * This use case allows to modify the data of an existing resource.
 * </p>
 */
public interface UpdateResourceUseCase {

    /**
     * Input port for updating a resource.
     * <p>
     * This use case allows to modify the data of an existing resource.
     * </p>
     */
    Optional<Resource> updateResource(UUID id, Resource updatedData);
}
