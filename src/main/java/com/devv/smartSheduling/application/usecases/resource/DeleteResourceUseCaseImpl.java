package com.devv.smartSheduling.application.usecases.resource;

import com.devv.smartSheduling.domain.ports.in.resource.DeleteResourceUseCase;
import com.devv.smartSheduling.domain.ports.out.ResourceRepositoryPort;

import java.util.UUID;

/**
 * Implementation of {@link DeleteResourceUseCase}.
 * <p>
 * This class deletes a {@link com.devv.smartSheduling.domain.model.Resource}
 * by its unique ID using the {@link ResourceRepositoryPort}.
 * </p>
 */
public class DeleteResourceUseCaseImpl implements DeleteResourceUseCase {

    private final ResourceRepositoryPort resourceRepositoryPort;

    /**
     * Constructor for {@code DeleteResourceUseCaseImpl}.
     *
     * @param resourceRepositoryPort the repository port used to delete resources
     */
    public DeleteResourceUseCaseImpl(ResourceRepositoryPort resourceRepositoryPort) {
        this.resourceRepositoryPort = resourceRepositoryPort;
    }

    /**
     * Delete a resource by its ID.
     *
     * @param id the unique ID of the resource
     * @return {@code true} if the resource was deleted, {@code false} if not found
     */
    @Override
    public boolean deleteResource(UUID id) {
        return resourceRepositoryPort.deleteById(id);
    }
}
