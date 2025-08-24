package com.devv.smartSheduling.application.usecases.resource;

import com.devv.smartSheduling.domain.model.Resource;
import com.devv.smartSheduling.domain.ports.in.resource.RetrieveResourceUseCase;
import com.devv.smartSheduling.domain.ports.out.ResourceRepositoryPort;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class RetrieveResourceUseCaseImpl implements RetrieveResourceUseCase {

    private final ResourceRepositoryPort resourceRepositoryPort;

    public RetrieveResourceUseCaseImpl(ResourceRepositoryPort resourceRepositoryPort) {
        this.resourceRepositoryPort = resourceRepositoryPort;
    }

    @Override
    public Optional<Resource> getResource(UUID id) {
        return resourceRepositoryPort.findById(id);
    }

    @Override
    public List<Resource> getAllResources() {
        return resourceRepositoryPort.findAll();
    }
}
