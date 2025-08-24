package com.devv.smartSheduling.application.usecases.resource;

import com.devv.smartSheduling.domain.model.Resource;
import com.devv.smartSheduling.domain.ports.in.resource.UpdateResourceUseCase;
import com.devv.smartSheduling.domain.ports.out.ResourceRepositoryPort;

import java.util.Optional;
import java.util.UUID;

public class UpdateResourceUseCaseImpl implements UpdateResourceUseCase {

    private final ResourceRepositoryPort resourceRepositoryPort;

    public UpdateResourceUseCaseImpl(ResourceRepositoryPort resourceRepositoryPort) {
        this.resourceRepositoryPort = resourceRepositoryPort;
    }

    @Override
    public Optional<Resource> updateResource(UUID id, Resource updatedData) {
        return resourceRepositoryPort.update(updatedData);
    }
}
