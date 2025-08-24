package com.devv.smartSheduling.application.usecases.resource;

import com.devv.smartSheduling.domain.model.Resource;
import com.devv.smartSheduling.domain.ports.in.resource.CreateResourceUseCase;
import com.devv.smartSheduling.domain.ports.out.ResourceRepositoryPort;

public class CreateResourceUseCaseImpl implements CreateResourceUseCase {

    private final ResourceRepositoryPort resourceRepositoryPort;

    public CreateResourceUseCaseImpl(ResourceRepositoryPort resourceRepositoryPort) {
        this.resourceRepositoryPort = resourceRepositoryPort;
    }

    @Override
    public Resource createResource(Resource resource) {
        return resourceRepositoryPort.save(resource);
    }
}
