package com.devv.smartSheduling.infrastructure.repositories;

import com.devv.smartSheduling.domain.model.SpecialistPolicy;
import com.devv.smartSheduling.domain.ports.out.SpecialistPolicyRepositoryPort;
import com.devv.smartSheduling.infrastructure.entities.SpecialistEntity;
import com.devv.smartSheduling.infrastructure.entities.SpecialistPolicyEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Adapter for the SpecialistPolicyRepositoryPort interface using JPA.
 * <p>
 * This class implements the output port for persistence operations
 * related to {@link SpecialistPolicy} and handles the mapping
 * between domain models and JPA entities.
 * </p>
 */
@Repository
public class JpaSpecialistPolicyRepositoryAdapter implements SpecialistPolicyRepositoryPort {

    /**
     * Repository for SpecialistPolicyEntity.
     */
    private final JpaSpecialistPolicyRepository jpaSpecialistPolicyRepository;

    /**
     * Repository for SpecialistEntity.
     */
    private final JpaSpecialistRepository jpaSpecialistRepository;

    /**
     * Constructor with required repositories.
     *
     * @param jpaSpecialistPolicyRepository JPA repository for policies
     * @param jpaSpecialistRepository       JPA repository for specialists
     */
    public JpaSpecialistPolicyRepositoryAdapter(
            JpaSpecialistPolicyRepository jpaSpecialistPolicyRepository,
            JpaSpecialistRepository jpaSpecialistRepository
    ) {
        this.jpaSpecialistPolicyRepository = jpaSpecialistPolicyRepository;
        this.jpaSpecialistRepository = jpaSpecialistRepository;
    }

    /**
     * Saves a new specialist policy.
     * <p>
     * It checks if the specialist exists and maps the domain model to entity.
     * </p>
     *
     * @param specialistPolicy Domain model to save
     * @return Saved domain model
     */
    @Override
    public SpecialistPolicy save(SpecialistPolicy specialistPolicy) {
        if (specialistPolicy.getSpecialist() == null || specialistPolicy.getSpecialist().getId() == null) {
            throw new IllegalArgumentException("Specialist must not be null and must contain a valid ID");
        }

        SpecialistEntity specialistEntity = jpaSpecialistRepository.findById(specialistPolicy.getSpecialist().getId())
                .orElseThrow(() -> new RuntimeException("Specialist not found with ID: " + specialistPolicy.getSpecialist().getId()));

        SpecialistPolicyEntity specialistPolicyEntity = SpecialistPolicyEntity.fromDomainModel(specialistPolicy, specialistEntity);
        SpecialistPolicyEntity savedEntity = jpaSpecialistPolicyRepository.save(specialistPolicyEntity);
        return savedEntity.toDomainModel();
    }

    /**
     * Finds a specialist policy by ID.
     *
     * @param id Policy ID
     * @return Optional with domain model
     */
    @Override
    public Optional<SpecialistPolicy> findById(UUID id) {
        return jpaSpecialistPolicyRepository.findById(id)
                .map(SpecialistPolicyEntity::toDomainModel);
    }

    /**
     * Returns all specialist policies.
     *
     * @return List of domain models
     */
    @Override
    public List<SpecialistPolicy> findAll() {
        return jpaSpecialistPolicyRepository.findAll().stream()
                .map(SpecialistPolicyEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    /**
     * Deletes a specialist policy by ID.
     *
     * @param id Policy ID
     * @return true if deleted, false if not found
     */
    @Override
    public boolean deleteById(UUID id) {
        if (jpaSpecialistPolicyRepository.existsById(id)) {
            jpaSpecialistPolicyRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Updates an existing specialist policy.
     * <p>
     * It checks if the policy exists and maps the domain model to entity.
     * </p>
     *
     * @param specialistPolicy Domain model to update
     * @return Optional with updated domain model
     */
    @Override
    public Optional<SpecialistPolicy> update(SpecialistPolicy specialistPolicy) {
        if (jpaSpecialistPolicyRepository.existsById(specialistPolicy.getId())) {
            if (specialistPolicy.getSpecialist() == null || specialistPolicy.getSpecialist().getId() == null) {
                throw new IllegalArgumentException("Specialist must not be null and must contain a valid ID");
            }

            SpecialistEntity specialistEntity = jpaSpecialistRepository.findById(specialistPolicy.getSpecialist().getId())
                    .orElseThrow(() -> new RuntimeException("Specialist not found with ID: " + specialistPolicy.getSpecialist().getId()));

            SpecialistPolicyEntity specialistPolicyEntity = SpecialistPolicyEntity.fromDomainModel(specialistPolicy, specialistEntity);
            SpecialistPolicyEntity updatedEntity = jpaSpecialistPolicyRepository.save(specialistPolicyEntity);
            return Optional.of(updatedEntity.toDomainModel());
        }
        return Optional.empty();
    }
}