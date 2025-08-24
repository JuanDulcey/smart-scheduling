package com.devv.smartSheduling.domain.ports.in.resource;

import com.devv.smartSheduling.domain.model.Resource;

import java.util.Optional;
import java.util.UUID;

public interface UpdateResourceUseCase {
    Optional<Resource> updateResource(UUID id, Resource updatedData);
}
