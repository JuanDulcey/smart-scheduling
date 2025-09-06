package com.devv.smartSheduling.infrastructure.controllers;

import com.devv.smartSheduling.application.services.ResourceService;
import com.devv.smartSheduling.domain.model.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

//@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("api/resources")
public class ResourceController {

    private final ResourceService resourceService;

    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @PostMapping
    public ResponseEntity<Resource> createResource(@RequestBody Resource resource) {
        Resource createdResource = resourceService.createResource(resource);
        return new ResponseEntity<>(createdResource, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Resource>> getAllResources() {
        List<Resource> resources = resourceService.getAllResources();
        return new ResponseEntity<>(resources, HttpStatus.OK);
    }

    @GetMapping("/{resourceId}")
    public ResponseEntity<Resource> getResourceById(@PathVariable UUID resourceId) {
        return resourceService.getResource(resourceId)
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{resourceId}")
    public ResponseEntity<Resource> updateResource(
            @PathVariable UUID resourceId,
            @RequestBody Resource updatedResource) {
        return resourceService.updateResource(resourceId, updatedResource)
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{resourceId}")
    public ResponseEntity<Void> deleteResource(@PathVariable UUID resourceId) {
        if (resourceService.deleteResource(resourceId)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}