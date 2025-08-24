package com.devv.smartSheduling.domain.ports.in.resource;

import com.devv.smartSheduling.domain.model.Resource;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RetrieveResourceUseCase {
    Optional<Resource> getResource(UUID id);
    List<Resource> getAllResources();
}
