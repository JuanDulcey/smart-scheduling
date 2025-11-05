package com.devv.smartSheduling.infrastructure.controllers;

import com.devv.smartSheduling.application.services.SpecialistPolicyService;
import com.devv.smartSheduling.domain.model.SpecialistPolicy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Controller for handling Specialist Policy endpoints.
 * <p>
 * Provides REST API endpoints to create, read, update, and delete
 * specialist policies in the system.
 * </p>
 */
@RestController
@RequestMapping("api/specialistPolicies")
public class SpecialistPolicyController {

    private final SpecialistPolicyService specialistPolicyService;

    /**
     * Constructor to inject the SpecialistPolicyService.
     *
     * @param specialistPolicyService service for specialist policy operations
     */
    public SpecialistPolicyController(SpecialistPolicyService specialistPolicyService) {
        this.specialistPolicyService = specialistPolicyService;
    }

    /**
     * Create a new specialist policy.
     *
     * @param specialistPolicy the policy data
     * @return the created policy with HTTP status 201 (Created)
     */
    @PostMapping
    public ResponseEntity<SpecialistPolicy> createSpecialistPolicy(@RequestBody SpecialistPolicy specialistPolicy) {
        SpecialistPolicy createdPolicy = specialistPolicyService.createSpecialistPolicy(specialistPolicy);
        return new ResponseEntity<>(createdPolicy, HttpStatus.CREATED);
    }

    /**
     * Get a specialist policy by its ID.
     *
     * @param specialistPolicyId unique ID of the policy
     * @return the policy with HTTP status 200 (OK) if found,
     * or HTTP status 404 (Not Found) if not found
     */
    @GetMapping("/{specialistPolicyId}")
    public ResponseEntity<SpecialistPolicy> getSpecialistPolicyById(@PathVariable UUID specialistPolicyId) {
        return specialistPolicyService.getSpecialistPolicy(specialistPolicyId)
                .map(specialistPolicy -> new ResponseEntity<>(specialistPolicy, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Get all specialist policies.
     *
     * @return list of all policies with HTTP status 200 (OK)
     */
    @GetMapping
    public ResponseEntity<List<SpecialistPolicy>> getAllSpecialistsPolicy() {
        List<SpecialistPolicy> specialistPolicies = specialistPolicyService.getAllSpecialistPolicies();
        return new ResponseEntity<>(specialistPolicies, HttpStatus.OK);
    }

    /**
     * Update an existing specialist policy.
     *
     * @param specialistPolicyId ID of the policy to update
     * @param updateSpecialistPolicy updated policy data
     * @return the updated policy with HTTP status 200 (OK) if found,
     * or HTTP status 404 (Not Found) if the policy does not exist
     */
    @PutMapping("/{specialistPolicyId}")
    public ResponseEntity<SpecialistPolicy> updateSpecialistPolicy(
            @PathVariable UUID specialistPolicyId,
            @RequestBody SpecialistPolicy updateSpecialistPolicy) {
        return specialistPolicyService.updateSpecialistPolicy(specialistPolicyId, updateSpecialistPolicy)
                .map(policy -> new ResponseEntity<>(policy, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Delete a specialist policy by its ID.
     *
     * @param specialistPolicyId unique ID of the policy
     * @return HTTP status 204 (No Content) if deleted,
     * or HTTP status 404 (Not Found) if the policy does not exist
     */
    @DeleteMapping("/{specialistPolicyId}")
    public ResponseEntity<Void> deleteSpecialistPolicyById(@PathVariable UUID specialistPolicyId) {
        if (specialistPolicyService.deleteSpecialistPolicy(specialistPolicyId)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
