package com.devv.smartSheduling.domain.ports.in.specialistpolicy;

import java.util.UUID;

public interface DeleteSpecialistPolicyUseCase {
    boolean deleteSpecialistPolicy(UUID id);
}
