package com.devv.smartSheduling.domain.ports.in.specialist;

import com.devv.smartSheduling.domain.model.Specialist;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RetrieveSpecialistUseCase {
    Optional<Specialist> getSpecialist(UUID id);
    List<Specialist> getAllSpecialists();
}
