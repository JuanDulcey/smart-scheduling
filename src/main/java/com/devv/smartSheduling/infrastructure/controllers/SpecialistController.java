package com.devv.smartSheduling.infrastructure.controllers;


import com.devv.smartSheduling.application.services.SpecialistService;
import com.devv.smartSheduling.domain.model.Specialist;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/specialists")
public class SpecialistController {

    private final SpecialistService specialistService;

    public SpecialistController(SpecialistService specialistService) {
        this.specialistService = specialistService;
    }

    @PostMapping
    public ResponseEntity<Specialist> createSpecialist(@RequestBody Specialist specialist) {
        Specialist createdSpecialist = specialistService.createSpecialist(specialist);
        return new ResponseEntity<>(createdSpecialist, HttpStatus.CREATED);
    }

    @GetMapping("/{specialistId}")
    public ResponseEntity<Specialist> getSpecialistById(@PathVariable UUID specialistId) {
        return specialistService.getSpecialist(specialistId)
                .map(specialist -> new ResponseEntity<>(specialist, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Specialist>> getAllSpecialists() {
        List<Specialist> specialists = specialistService.getAllSpecialists();
        return new ResponseEntity<>(specialists, HttpStatus.OK);
    }

    @PutMapping("/{specialistId}")
    public ResponseEntity<Specialist> updateSpecialist(
            @PathVariable UUID specialistId,
            @RequestBody Specialist updateSpecialist) {
        return specialistService.updateSpecialist(specialistId, updateSpecialist)
                .map(specialist -> new ResponseEntity<>(specialist, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{specialistId}")
    public ResponseEntity<Void> deleteSpecialistById(@PathVariable UUID specialistId) {
        if (specialistService.deleteSpecialist(specialistId)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

