package com.devv.smartSheduling.application.usecases.resource;

import com.devv.smartSheduling.domain.model.Resource;
import com.devv.smartSheduling.domain.ports.in.resource.CreateResourceUseCase;
import com.devv.smartSheduling.domain.ports.out.ResourceRepositoryPort;

/**
 * Implementation of {@link CreateResourceUseCase}.
 * <p>
 * This class creates a new {@link Resource} and saves it
 * using the {@link ResourceRepositoryPort}.
 * </p>
 */
public class CreateResourceUseCaseImpl implements CreateResourceUseCase {

    private final ResourceRepositoryPort resourceRepositoryPort;

    /**
     * Constructor for {@code CreateResourceUseCaseImpl}.
     *
     * @param resourceRepositoryPort the repository port to save resources
     */
    public CreateResourceUseCaseImpl(ResourceRepositoryPort resourceRepositoryPort) {
        this.resourceRepositoryPort = resourceRepositoryPort;
    }

    /**
     * Create a new {@link Resource}.
     *
     * @param resource the resource to create
     * @return the saved {@link Resource}
     */
    @Override
    public Resource createResource(Resource resource) {
        return resourceRepositoryPort.save(resource);
    }
}
