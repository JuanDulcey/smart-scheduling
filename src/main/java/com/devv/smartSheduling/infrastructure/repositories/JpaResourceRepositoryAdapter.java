package com.devv.smartSheduling.infrastructure.repositories;

import com.devv.smartSheduling.domain.model.Resource;
import com.devv.smartSheduling.domain.ports.out.ResourceRepositoryPort;
import com.devv.smartSheduling.infrastructure.entities.ResourceEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Adapter class that implements {@link ResourceRepositoryPort} using JPA.
 * <p>
 * This class acts as a bridge between the domain layer and the persistence layer,
 * converting domain models to entities and vice versa.
 * </p>
 */
@Repository
public class JpaResourceRepositoryAdapter implements ResourceRepositoryPort {

    /**
     * JPA repository for managing Resource entities.
     * <p>
     * Used to access and store resource data in the database.
     * </p>
     */
    private final JpaResourceRepository jpaResourceRepository;

    /**
     * Constructs the adapter with a JPA repository instance.
     *
     * @param jpaResourceRepository the Spring Data JPA repository for {@link ResourceEntity}
     */
    public JpaResourceRepositoryAdapter(JpaResourceRepository jpaResourceRepository) {
        this.jpaResourceRepository = jpaResourceRepository;
    }

    /**
     * Saves a {@link Resource} in the database.
     * <p>
     * If the resource exists, it updates the entity; otherwise, it inserts a new one.
     * </p>
     *
     * @param resource the domain resource to save
     * @return the saved resource with updated information
     */
    @Override
    public Resource save(Resource resource) {
        ResourceEntity resourceEntity = ResourceEntity.fromDomainModel(resource);
        ResourceEntity savedResourceEntity = jpaResourceRepository.save(resourceEntity);
        return savedResourceEntity.toDomainModel();
    }

    /**
     * Finds a {@link Resource} by its unique ID.
     *
     * @param id the resource identifier
     * @return an {@link Optional} containing the resource if found, or empty otherwise
     */
    @Override
    public Optional<Resource> findById(UUID id) {
        return jpaResourceRepository.findById(id).map(ResourceEntity::toDomainModel);
    }

    /**
     * Retrieves all resources from the database.
     *
     * @return a list of all domain resources
     */
    @Override
    public List<Resource> findAll() {
        return jpaResourceRepository.findAll().stream()
                .map(ResourceEntity::toDomainModel).collect(Collectors.toList());
    }

    /**
     * Deletes a {@link Resource} by its unique ID.
     *
     * @param id the resource identifier
     * @return true if the resource was found and deleted, false otherwise
     */
    @Override
    public boolean deleteById(UUID id) {
        if (jpaResourceRepository.existsById(id)) {
            jpaResourceRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Updates an existing {@link Resource} in the database.
     * <p>
     * Checks if the resource exists by ID, then performs the update.
     * </p>
     *
     * @param resource the domain resource with updated data
     * @return an {@link Optional} containing the updated resource if it existed, or empty otherwise
     */
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
