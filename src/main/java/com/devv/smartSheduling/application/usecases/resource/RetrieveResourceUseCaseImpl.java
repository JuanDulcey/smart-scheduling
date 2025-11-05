package com.devv.smartSheduling.application.usecases.resource;

import com.devv.smartSheduling.domain.model.Resource;
import com.devv.smartSheduling.domain.ports.in.resource.RetrieveResourceUseCase;
import com.devv.smartSheduling.domain.ports.out.ResourceRepositoryPort;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Implementation of {@link RetrieveResourceUseCase}.
 * <p>
 * This class gets one or all {@link Resource} objects
 * from the data source using the {@link ResourceRepositoryPort}.
 * </p>
 */
public class RetrieveResourceUseCaseImpl implements RetrieveResourceUseCase {

    private final ResourceRepositoryPort resourceRepositoryPort;

    /**
     * Constructor for {@code RetrieveResourceUseCaseImpl}.
     *
     * @param resourceRepositoryPort the repository port used to find resources
     */
    public RetrieveResourceUseCaseImpl(ResourceRepositoryPort resourceRepositoryPort) {
        this.resourceRepositoryPort = resourceRepositoryPort;
    }

    /**
     * Get one {@link Resource} by its ID.
     *
     * @param id the unique ID of the resource
     * @return an {@link Optional} with the resource if found
     */
    @Override
    public Optional<Resource> getResource(UUID id) {
        return resourceRepositoryPort.findById(id);
    }

    /**
     * Get all {@link Resource} records.
     *
     * @return a list of all resources
     */
    @Override
    public List<Resource> getAllResources() {
        return resourceRepositoryPort.findAll();
    }
}
