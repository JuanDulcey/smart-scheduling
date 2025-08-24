package com.devv.smartSheduling.domain.ports.in.resource;

import java.util.UUID;

public interface DeleteResourceUseCase {
    boolean deleteResource(UUID id);
}
