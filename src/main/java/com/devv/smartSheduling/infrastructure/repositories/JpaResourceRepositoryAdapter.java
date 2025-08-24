package com.devv.smartSheduling.infrastructure.repositories;

import com.devv.smartSheduling.domain.model.Resource;
import com.devv.smartSheduling.domain.ports.out.ResourceRepositoryPort;
import com.devv.smartSheduling.infrastructure.entities.ResourceEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class JpaResourceRepositoryAdapter implements ResourceRepositoryPort {

    private final JpaResourceRepository jpaResourceRepository;

    public JpaResourceRepositoryAdapter(JpaResourceRepository jpaResourceRepository) {
        this.jpaResourceRepository = jpaResourceRepository;
    }

    @Override
    public Resource save(Resource resource) {
        ResourceEntity resourceEntity = ResourceEntity.fromDomainModel(resource);
        ResourceEntity savedResourceEntity = jpaResourceRepository.save(resourceEntity);
        return savedResourceEntity.toDomainModel();
    }

    @Override
    public Optional<Resource> findById(UUID id) {
        return jpaResourceRepository.findById(id).map(ResourceEntity::toDomainModel);
    }

    @Override
    public List<Resource> findAll() {
        return jpaResourceRepository.findAll().stream()
                .map(ResourceEntity::toDomainModel).collect(Collectors.toList());
    }

    @Override
    public boolean deleteById(UUID id) {
        if (jpaResourceRepository.existsById(id)) {
            jpaResourceRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Resource> update(Resource resource) {
        if (jpaResourceRepository.existsById(resource.getId())) {
            ResourceEntity resourceEntity = ResourceEntity.fromDomainModel(resource);
            ResourceEntity updateResourceEntity = jpaResourceRepository.save(resourceEntity);
            return Optional.of(updateResourceEntity.toDomainModel());
        }
        return Optional.empty();
    }
}
