package com.devv.smartSheduling.domain.ports.in.specialist;

import com.devv.smartSheduling.domain.model.Specialist;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RetrieveSpecialistWithUserUseCase {
    Optional<Specialist> getSpecialistWithUser(UUID id);
    List<Specialist> getAllSpecialistsWithUser();
}
