package com.devv.smartSheduling.domain.ports.in.resource;

import com.devv.smartSheduling.domain.model.Resource;

/**
 * Input port for creating a new resource.
 * <p>
 * This use case allows to create a new {@link Resource} in the system.
 * </p>
 */
public interface CreateResourceUseCase {

    /**
     * Creates a new resource.
     *
     * @param resource the resource object to create
     * @return the created {@link Resource} with its ID and stored data
     */
    Resource createResource(Resource resource);
}
