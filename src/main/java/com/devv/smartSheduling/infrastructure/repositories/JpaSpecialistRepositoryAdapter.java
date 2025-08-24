package com.devv.smartSheduling.infrastructure.repositories;

import com.devv.smartSheduling.domain.model.Specialist;
import com.devv.smartSheduling.domain.ports.out.SpecialistRepositoryPort;
import com.devv.smartSheduling.infrastructure.entities.SpecialistEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class JpaSpecialistRepositoryAdapter implements SpecialistRepositoryPort {

    private final JpaSpecialistRepository jpaSpecialistRepository;

    public JpaSpecialistRepositoryAdapter(JpaSpecialistRepository jpaSpecialistRepository) {
        this.jpaSpecialistRepository = jpaSpecialistRepository;
    }

    @Override
    public Specialist save(Specialist specialist) {
        SpecialistEntity specialistEntity = SpecialistEntity.fromDomainModel(specialist);
        SpecialistEntity savedSpecialistEntity = jpaSpecialistRepository.save(specialistEntity);
        return savedSpecialistEntity.toDomainModel();
    }

    @Override
    public Optional<Specialist> findById(UUID id) {
        return jpaSpecialistRepository.findById(id).map(SpecialistEntity::toDomainModel);
    }

    @Override
    public List<Specialist> findAll() {
        return jpaSpecialistRepository.findAll().stream()
                .map(SpecialistEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteById(UUID id) {
        if (jpaSpecialistRepository.existsById(id)) {
            jpaSpecialistRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Specialist> update(Specialist specialist) {
        if (jpaSpecialistRepository.existsById(specialist.getId())) {
            SpecialistEntity specialistEntity = SpecialistEntity.fromDomainModel(specialist);
            SpecialistEntity updateSpecialistEntity = jpaSpecialistRepository.save(specialistEntity);
            return Optional.of(updateSpecialistEntity.toDomainModel());
        }
        return Optional.empty();
    }
}
