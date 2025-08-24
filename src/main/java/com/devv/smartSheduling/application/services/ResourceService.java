package com.devv.smartSheduling.application.services;

import com.devv.smartSheduling.domain.model.Resource;
import com.devv.smartSheduling.domain.ports.in.resource.CreateResourceUseCase;
import com.devv.smartSheduling.domain.ports.in.resource.DeleteResourceUseCase;
import com.devv.smartSheduling.domain.ports.in.resource.RetrieveResourceUseCase;
import com.devv.smartSheduling.domain.ports.in.resource.UpdateResourceUseCase;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ResourceService implements
        CreateResourceUseCase,
        DeleteResourceUseCase,
        RetrieveResourceUseCase,
        UpdateResourceUseCase{

    private final CreateResourceUseCase createResourceUseCase;
    private final DeleteResourceUseCase deleteResourceUseCase;
    private final RetrieveResourceUseCase retrieveResourceUseCase;
    private final UpdateResourceUseCase updateResourceUseCase;

    public ResourceService(CreateResourceUseCase createResourceUseCase, DeleteResourceUseCase deleteResourceUseCase, RetrieveResourceUseCase retrieveResourceUseCase, UpdateResourceUseCase updateResourceUseCase){
        this.createResourceUseCase = createResourceUseCase;
        this.deleteResourceUseCase = deleteResourceUseCase;
        this.retrieveResourceUseCase = retrieveResourceUseCase;
        this.updateResourceUseCase = updateResourceUseCase;
    }

    @Override
    public Resource createResource(Resource resource) {
        return createResourceUseCase.createResource(resource);
    }

    @Override
    public boolean deleteResource(UUID id) {
        return deleteResourceUseCase.deleteResource(id);
    }

    @Override
    public Optional<Resource> getResource(UUID id) {
        return retrieveResourceUseCase.getResource(id);
    }

    @Override
    public List<Resource> getAllResources() {
        return retrieveResourceUseCase.getAllResources();
    }

    @Override
    public Optional<Resource> updateResource(UUID id, Resource updatedData) {
        return updateResourceUseCase.updateResource(id, updatedData);
    }
}
