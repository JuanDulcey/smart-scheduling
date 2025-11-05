package com.devv.smartSheduling.infrastructure.controllers;

import com.devv.smartSheduling.application.services.ResourceService;
import com.devv.smartSheduling.domain.model.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Controller for handling Resource endpoints.
 * <p>
 * Provides REST API endpoints to create, read, update, and delete resources.
 * </p>
 */
@RestController
@RequestMapping("api/resources")
public class ResourceController {

    private final ResourceService resourceService;

    /**
     * Constructor to inject the ResourceService.
     *
     * @param resourceService the service to handle resource operations
     */
    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    /**
     * Create a new resource.
     *
     * @param resource the resource data
     * @return the created resource with HTTP status 201 (Created)
     */
    @PostMapping
    public ResponseEntity<Resource> createResource(@RequestBody Resource resource) {
        Resource createdResource = resourceService.createResource(resource);
        return new ResponseEntity<>(createdResource, HttpStatus.CREATED);
    }

    /**
     * Get all resources.
     *
     * @return list of all resources with HTTP status 200 (OK)
     */
    @GetMapping
    public ResponseEntity<List<Resource>> getAllResources() {
        List<Resource> resources = resourceService.getAllResources();
        return new ResponseEntity<>(resources, HttpStatus.OK);
    }

    /**
     * Get a resource by its ID.
     *
     * @param resourceId the unique ID of the resource
     * @return the resource with HTTP status 200 (OK) if found,
     * or HTTP status 404 (Not Found) if not found
     */
    @GetMapping("/{resourceId}")
    public ResponseEntity<Resource> getResourceById(@PathVariable UUID resourceId) {
        return resourceService.getResource(resourceId)
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Update an existing resource.
     *
     * @param resourceId      the ID of the resource to update
     * @param updatedResource the updated resource data
     * @return the updated resource with HTTP status 200 (OK) if found,
     * or HTTP status 404 (Not Found) if the resource does not exist
     */
    @PutMapping("/{resourceId}")
    public ResponseEntity<Resource> updateResource(
            @PathVariable UUID resourceId,
            @RequestBody Resource updatedResource) {
        return resourceService.updateResource(resourceId, updatedResource)
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Delete a resource by its ID.
     *
     * @param resourceId the unique ID of the resource
     * @return HTTP status 204 (No Content) if deleted,
     * or HTTP status 404 (Not Found) if the resource does not exist
     */
    @DeleteMapping("/{resourceId}")
    public ResponseEntity<Void> deleteResource(@PathVariable UUID resourceId) {
        if (resourceService.deleteResource(resourceId)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}