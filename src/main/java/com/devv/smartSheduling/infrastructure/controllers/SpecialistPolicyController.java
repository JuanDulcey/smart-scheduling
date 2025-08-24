package com.devv.smartSheduling.infrastructure.controllers;

import com.devv.smartSheduling.application.services.SpecialistPolicyService;
import com.devv.smartSheduling.domain.model.Specialist;
import com.devv.smartSheduling.domain.model.SpecialistPolicy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/specialistPolicies")
public class SpecialistPolicyController {

    private final SpecialistPolicyService specialistPolicyService;

    public SpecialistPolicyController(SpecialistPolicyService specialistPolicyService) {
        this.specialistPolicyService = specialistPolicyService;
    }

    @PostMapping
    public ResponseEntity<SpecialistPolicy> createSpecialistPolicy(@RequestBody SpecialistPolicy specialistPolicy) {
        SpecialistPolicy createdPolicy = specialistPolicyService.createSpecialistPolicy(specialistPolicy);
        return new ResponseEntity<>(createdPolicy, HttpStatus.CREATED);
    }


    @GetMapping("/{specialistPolicyId}")
    public ResponseEntity<SpecialistPolicy> getSpecialistPolicyById(@PathVariable UUID specialistPolicyId) {
        return specialistPolicyService.getSpecialistPolicy(specialistPolicyId)
                .map(specialistPolicy -> new ResponseEntity<>(specialistPolicy, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<SpecialistPolicy>> getAllSpecialistsPolicy() {
        List<SpecialistPolicy> specialistPolicies = specialistPolicyService.getAllSpecialistPolicies();
        return new ResponseEntity<>(specialistPolicies, HttpStatus.OK);
    }

    @PutMapping("/{specialistPolicyId}")
    public ResponseEntity<SpecialistPolicy> updateSpecialistPolicy(
            @PathVariable UUID specialistPolicyId,
            @RequestBody SpecialistPolicy updateSpecialistPolicy) {
        return specialistPolicyService.updateSpecialistPolicy(specialistPolicyId, updateSpecialistPolicy)
                .map(policy -> new ResponseEntity<>(policy, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{specialistPolicyId}")
    public ResponseEntity<Void> deleteSpecialistPolicyById(@PathVariable UUID specialistPolicyId) {
        if (specialistPolicyService.deleteSpecialistPolicy(specialistPolicyId)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
