package com.devv.smartSheduling.domain.ports.in.specialist;

import java.util.UUID;

public interface DeleteSpecialistUseCase {
    boolean deleteSpecialist(UUID id);
}
