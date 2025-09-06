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

@Repository
public class JpaSpecialistPolicyRepositoryAdapter implements SpecialistPolicyRepositoryPort {

    private final JpaSpecialistPolicyRepository jpaSpecialistPolicyRepository;
    private final JpaSpecialistRepository jpaSpecialistRepository;

    public JpaSpecialistPolicyRepositoryAdapter(
            JpaSpecialistPolicyRepository jpaSpecialistPolicyRepository,
            JpaSpecialistRepository jpaSpecialistRepository
    ) {
        this.jpaSpecialistPolicyRepository = jpaSpecialistPolicyRepository;
        this.jpaSpecialistRepository = jpaSpecialistRepository;
    }

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

    @Override
    public Optional<SpecialistPolicy> findById(UUID id) {
        return jpaSpecialistPolicyRepository.findById(id)
                .map(SpecialistPolicyEntity::toDomainModel);
    }

    @Override
    public List<SpecialistPolicy> findAll() {
        return jpaSpecialistPolicyRepository.findAll().stream()
                .map(SpecialistPolicyEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteById(UUID id) {
        if (jpaSpecialistPolicyRepository.existsById(id)) {
            jpaSpecialistPolicyRepository.deleteById(id);
            return true;
        }
        return false;
    }

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