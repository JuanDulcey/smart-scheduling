package com.devv.smartSheduling.infrastructure.controllers;


import com.devv.smartSheduling.application.services.SpecialistService;
import com.devv.smartSheduling.domain.model.Specialist;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Controller for handling Specialist endpoints.
 * <p>
 * Provides REST API endpoints to create, read, update, and delete specialists.
 * Also includes endpoints to retrieve specialists along with their user information.
 * </p>
 */
@RestController
@RequestMapping("api/specialists")
public class SpecialistController {

    private final SpecialistService specialistService;

    /**
     * Constructor to inject the SpecialistService.
     *
     * @param specialistService the service to handle specialist operations
     */
    public SpecialistController(SpecialistService specialistService) {
        this.specialistService = specialistService;
    }

    /**
     * Create a new specialist.
     *
     * @param specialist the specialist data
     * @return the created specialist with HTTP status 201 (Created)
     */
    @PostMapping
    public ResponseEntity<Specialist> createSpecialist(@RequestBody Specialist specialist) {
        Specialist createdSpecialist = specialistService.createSpecialist(specialist);
        return new ResponseEntity<>(createdSpecialist, HttpStatus.CREATED);
    }

    /**
     * Get a specialist by its ID.
     *
     * @param specialistId the unique ID of the specialist
     * @return the specialist with HTTP status 200 (OK) if found,
     * or HTTP status 404 (Not Found) if not found
     */
    @GetMapping("/{specialistId}")
    public ResponseEntity<Specialist> getSpecialistById(@PathVariable UUID specialistId) {
        return specialistService.getSpecialist(specialistId)
                .map(specialist -> new ResponseEntity<>(specialist, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Get all specialists.
     *
     * @return list of all specialists with HTTP status 200 (OK)
     */
    @GetMapping
    public ResponseEntity<List<Specialist>> getAllSpecialists() {
        List<Specialist> specialists = specialistService.getAllSpecialists();
        return new ResponseEntity<>(specialists, HttpStatus.OK);
    }

    /**
     * Update an existing specialist.
     *
     * @param specialistId    the ID of the specialist to update
     * @param updateSpecialist the updated specialist data
     * @return the updated specialist with HTTP status 200 (OK) if found,
     * or HTTP status 404 (Not Found) if the specialist does not exist
     */
    @PutMapping("/{specialistId}")
    public ResponseEntity<Specialist> updateSpecialist(
            @PathVariable UUID specialistId,
            @RequestBody Specialist updateSpecialist) {
        return specialistService.updateSpecialist(specialistId, updateSpecialist)
                .map(specialist -> new ResponseEntity<>(specialist, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Delete a specialist by its ID.
     *
     * @param specialistId the unique ID of the specialist
     * @return HTTP status 204 (No Content) if deleted,
     * or HTTP status 404 (Not Found) if the specialist does not exist
     */
    @DeleteMapping("/{specialistId}")
    public ResponseEntity<Void> deleteSpecialistById(@PathVariable UUID specialistId) {
        if (specialistService.deleteSpecialist(specialistId)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Get a specialist by its ID along with user data.
     *
     * @param specialistId the unique ID of the specialist
     * @return the specialist with user data with HTTP status 200 (OK) if found,
     * or HTTP status 404 (Not Found) if not found
     */
    @GetMapping("/{specialistId}/with-user")
    public ResponseEntity<Specialist> getSpecialistByIdWithUser(@PathVariable UUID specialistId) {
        Optional<Specialist> specialist = specialistService.getSpecialistWithUser(specialistId);
        return specialist.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Get all specialists along with their user data.
     *
     * @return list of specialists with user data with HTTP status 200 (OK)
     */
    @GetMapping("/with-user")
    public ResponseEntity<List<Specialist>> getAllSpecialistsWithUser() {
        List<Specialist> specialists = specialistService.getAllSpecialistsWithUser();
        return new ResponseEntity<>(specialists, HttpStatus.OK);
    }
}

