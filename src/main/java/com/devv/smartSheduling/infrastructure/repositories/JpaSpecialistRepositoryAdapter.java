package com.devv.smartSheduling.infrastructure.repositories;

import com.devv.smartSheduling.domain.model.Specialist;
import com.devv.smartSheduling.domain.ports.out.SpecialistRepositoryPort;
import com.devv.smartSheduling.infrastructure.entities.SpecialistEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * JPA adapter for the {@link SpecialistRepositoryPort} interface.
 * <p>
 * This class connects the domain model {@link Specialist}
 * with the database using JPA entities.
 * It handles basic operations like save, find, update and delete.
 * </p>
 */
@Repository
public class JpaSpecialistRepositoryAdapter implements SpecialistRepositoryPort {

    /**
     * JPA repository for SpecialistEntity.
     */
    private final JpaSpecialistRepository jpaSpecialistRepository;

    /**
     * Constructor with required repository.
     *
     * @param jpaSpecialistRepository JPA repository for specialists
     */
    public JpaSpecialistRepositoryAdapter(JpaSpecialistRepository jpaSpecialistRepository) {
        this.jpaSpecialistRepository = jpaSpecialistRepository;
    }

    /**
     * Saves a new specialist.
     * <p>
     * Converts the domain model to entity and stores it.
     * </p>
     *
     * @param specialist Domain model to save
     * @return Saved domain model
     */
    @Override
    public Specialist save(Specialist specialist) {
        SpecialistEntity specialistEntity = SpecialistEntity.fromDomainModel(specialist);
        SpecialistEntity savedSpecialistEntity = jpaSpecialistRepository.save(specialistEntity);
        return savedSpecialistEntity.toDomainModel();
    }

    /**
     * Finds a specialist by ID.
     *
     * @param id Specialist ID
     * @return Optional with domain model
     */
    @Override
    public Optional<Specialist> findById(UUID id) {
        return jpaSpecialistRepository.findById(id).map(SpecialistEntity::toDomainModel);
    }

    /**
     * Returns all specialists.
     *
     * @return List of domain models
     */
    @Override
    public List<Specialist> findAll() {
        return jpaSpecialistRepository.findAll().stream()
                .map(SpecialistEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    /**
     * Deletes a specialist by ID.
     *
     * @param id Specialist ID
     * @return true if deleted, false if not found
     */
    @Override
    public boolean deleteById(UUID id) {
        if (jpaSpecialistRepository.existsById(id)) {
            jpaSpecialistRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Updates an existing specialist.
     * <p>
     * Finds the entity, updates fields, and saves it.
     * </p>
     *
     * @param specialist Domain model to update
     * @return Optional with updated domain model
     */
    @Override
    public Optional<Specialist> update(Specialist specialist) {
        return jpaSpecialistRepository.findById(specialist.getId()).map(existing -> {
            existing.setName(specialist.getName());
            existing.setSpecialty(specialist.getSpecialty());
            existing.setActive(specialist.isActive());

            SpecialistEntity updated = jpaSpecialistRepository.save(existing);
            return updated.toDomainModel();
        });

    }

    /**
     * Finds a specialist by ID including user data.
     *
     * @param id Specialist ID
     * @return Optional with domain model
     */
    @Override
    public Optional<Specialist> findByIdWithUser(UUID id) {
        return jpaSpecialistRepository.findById(id)
                .map(SpecialistEntity::toDomainModel);
    }

    /**
     * Returns all specialists including user data.
     *
     * @return List of domain models
     */
    @Override
    public List<Specialist> findAllWithUser() {
        return jpaSpecialistRepository.findAll()
                .stream()
                .map(SpecialistEntity::toDomainModel)
                .collect(Collectors.toList());
    }
}
