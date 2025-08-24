package com.devv.smartSheduling.application.usecases.resource;

import com.devv.smartSheduling.domain.ports.in.resource.DeleteResourceUseCase;
import com.devv.smartSheduling.domain.ports.out.ResourceRepositoryPort;

import java.util.UUID;

public class DeleteResourceUseCaseImpl implements DeleteResourceUseCase {

    private final ResourceRepositoryPort resourceRepositoryPort;

    public DeleteResourceUseCaseImpl(ResourceRepositoryPort resourceRepositoryPort) {
        this.resourceRepositoryPort = resourceRepositoryPort;
    }

    @Override
    public boolean deleteResource(UUID id) {
        return resourceRepositoryPort.deleteById(id);
    }
}
