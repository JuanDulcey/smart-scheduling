package com.devv.smartSheduling.domain.ports.in.resource;

import com.devv.smartSheduling.domain.model.Resource;

public interface CreateResourceUseCase {
    Resource createResource(Resource resource);
}
