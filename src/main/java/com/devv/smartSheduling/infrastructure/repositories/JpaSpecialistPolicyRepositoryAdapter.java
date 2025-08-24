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

    public JpaSpecialistPolicyRepositoryAdapter(JpaSpecialistPolicyRepository jpaSpecialistPolicyRepository) {
        this.jpaSpecialistPolicyRepository = jpaSpecialistPolicyRepository;
    }


    @Override
    public SpecialistPolicy save(SpecialistPolicy specialistPolicy) {
        SpecialistEntity specialistEntity = SpecialistEntity.fromDomainModel(specialistPolicy.getSpecialist());
        SpecialistPolicyEntity specialistPolicyEntity = SpecialistPolicyEntity.fromDomainModel(specialistPolicy, specialistEntity);
        SpecialistPolicyEntity saveSpecialistPolicyEntity = jpaSpecialistPolicyRepository.save(specialistPolicyEntity);
        return saveSpecialistPolicyEntity.toDomainModel();
    }

    @Override
    public Optional<SpecialistPolicy> findById(UUID id) {
        return jpaSpecialistPolicyRepository.findById(id).map(SpecialistPolicyEntity::toDomainModel);
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
            SpecialistEntity specialistEntity = SpecialistEntity.fromDomainModel(specialistPolicy.getSpecialist());
            SpecialistPolicyEntity specialistPolicyEntity = SpecialistPolicyEntity.fromDomainModel(specialistPolicy, specialistEntity);
            SpecialistPolicyEntity updatedSpecialistPolicyEntity = jpaSpecialistPolicyRepository.save(specialistPolicyEntity);
            return Optional.of(updatedSpecialistPolicyEntity.toDomainModel());
        }
        return Optional.empty();
    }
}
