package com.devv.smartSheduling.application.services;

import com.devv.smartSheduling.domain.model.Resource;
import com.devv.smartSheduling.domain.ports.in.resource.CreateResourceUseCase;
import com.devv.smartSheduling.domain.ports.in.resource.DeleteResourceUseCase;
import com.devv.smartSheduling.domain.ports.in.resource.RetrieveResourceUseCase;
import com.devv.smartSheduling.domain.ports.in.resource.UpdateResourceUseCase;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Service class that manages Resource operations.
 * It can create, delete, find and update resources.
 */
public class ResourceService implements
        CreateResourceUseCase,
        DeleteResourceUseCase,
        RetrieveResourceUseCase,
        UpdateResourceUseCase{

    private final CreateResourceUseCase createResourceUseCase;
    private final DeleteResourceUseCase deleteResourceUseCase;
    private final RetrieveResourceUseCase retrieveResourceUseCase;
    private final UpdateResourceUseCase updateResourceUseCase;

    /**
     * Constructor that sets all the use cases.
     *
     * @param createResourceUseCase handles create operations
     * @param deleteResourceUseCase handles delete operations
     * @param retrieveResourceUseCase handles retrieve operations
     * @param updateResourceUseCase handles update operations
     */
    public ResourceService(CreateResourceUseCase createResourceUseCase, DeleteResourceUseCase deleteResourceUseCase, RetrieveResourceUseCase retrieveResourceUseCase, UpdateResourceUseCase updateResourceUseCase){
        this.createResourceUseCase = createResourceUseCase;
        this.deleteResourceUseCase = deleteResourceUseCase;
        this.retrieveResourceUseCase = retrieveResourceUseCase;
        this.updateResourceUseCase = updateResourceUseCase;
    }

    /** Creates a new resource. */
    @Override
    public Resource createResource(Resource resource) {
        return createResourceUseCase.createResource(resource);
    }

    /** Deletes a resource by ID. */
    @Override
    public boolean deleteResource(UUID id) {
        return deleteResourceUseCase.deleteResource(id);
    }

    /** Gets a resource by ID. */
    @Override
    public Optional<Resource> getResource(UUID id) {
        return retrieveResourceUseCase.getResource(id);
    }

    /** Gets all resources in the system. */
    @Override
    public List<Resource> getAllResources() {
        return retrieveResourceUseCase.getAllResources();
    }

    /** Updates a resource with new data. */
    @Override
    public Optional<Resource> updateResource(UUID id, Resource updatedData) {
        return updateResourceUseCase.updateResource(id, updatedData);
    }
}
