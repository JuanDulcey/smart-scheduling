package com.devv.smartSheduling.domain.ports.in.specialistpolicy;

import com.devv.smartSheduling.domain.model.SpecialistPolicy;

public interface CreateSpecialistPolicyUseCase {
    SpecialistPolicy createSpecialistPolicy(SpecialistPolicy specialistPolicy);
}
