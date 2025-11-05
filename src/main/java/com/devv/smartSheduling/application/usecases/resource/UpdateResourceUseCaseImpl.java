package com.devv.smartSheduling.application.usecases.resource;

import com.devv.smartSheduling.domain.model.Resource;
import com.devv.smartSheduling.domain.ports.in.resource.UpdateResourceUseCase;
import com.devv.smartSheduling.domain.ports.out.ResourceRepositoryPort;

import java.util.Optional;
import java.util.UUID;

/**
 * Implementation of {@link UpdateResourceUseCase}.
 * <p>
 * This class updates an existing {@link Resource} in the data source
 * using the {@link ResourceRepositoryPort}.
 * </p>
 */
public class UpdateResourceUseCaseImpl implements UpdateResourceUseCase {

    private final ResourceRepositoryPort resourceRepositoryPort;

    /**
     * Constructor for {@code UpdateResourceUseCaseImpl}.
     *
     * @param resourceRepositoryPort the repository port used to update resources
     */
    public UpdateResourceUseCaseImpl(ResourceRepositoryPort resourceRepositoryPort) {
        this.resourceRepositoryPort = resourceRepositoryPort;
    }

    /**
     * Update an existing {@link Resource} by its ID.
     *
     * @param id the unique ID of the resource to update
     * @param updatedData the resource object with new data
     * @return an {@link Optional} with the updated resource if successful
     */
    @Override
    public Optional<Resource> updateResource(UUID id, Resource updatedData) {
        return resourceRepositoryPort.update(updatedData);
    }
}
