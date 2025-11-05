package com.devv.smartSheduling.domain.ports.out;

import com.devv.smartSheduling.domain.model.Resource;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Output port for resource persistence.
 * <p>
 * Defines the operations that any repository implementation
 * (for example, JPA, JDBC, or another storage technology)
 * must provide to interact with the {@link Resource} domain entity.
 * </p>
 */
public interface ResourceRepositoryPort {

    /**
     * Save a resource into the storage.
     * <p>
     * If the resource already exists (by ID), it is updated.
     * If not, a new one is created.
     * </p>
     *
     * @param resource the domain resource to save
     * @return the saved resource with possible updated values (e.g., generated ID)
     */
    Resource save(Resource resource);

    /**
     * Find a resource by its unique ID.
     *
     * @param id the unique identifier of the resource
     * @return an {@link Optional} with the resource if found, or empty if not
     */
    Optional<Resource> findById(UUID id);

    /**
     * Get all resources stored in the system.
     *
     * @return list of all resources
     */
    List<Resource> findAll();

    /**
     * Delete a resource by its unique ID.
     *
     * @param id the unique identifier of the resource
     * @return {@code true} if the resource existed and was deleted, {@code false} otherwise
     */
    boolean deleteById(UUID id);

    /**
     * Update an existing resource.
     *
     * @param resource the resource with updated information
     * @return an {@link Optional} with the updated resource if found, or empty if not
     */
    Optional<Resource> update(Resource resource);
}
