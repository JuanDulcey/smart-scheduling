package com.devv.smartSheduling.infrastructure.repositories;

import com.devv.smartSheduling.domain.model.User;
import com.devv.smartSheduling.domain.ports.out.UserRepositoryPort;
import com.devv.smartSheduling.infrastructure.entities.SpecialistEntity;
import com.devv.smartSheduling.infrastructure.entities.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class JpaUserRepositoryAdapter implements UserRepositoryPort {

    private final JpaUserRepository jpaUserRepository;

    public JpaUserRepositoryAdapter(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @Override
    public User save(User user) {
        UserEntity userEntity = UserEntity.fromDomainModel(user);
        UserEntity savedUserEntity = jpaUserRepository.save(userEntity);
        return savedUserEntity.toDomainModel();
    }

    @Override
    public Optional<User> findById(UUID id) {
        return jpaUserRepository.findById(id).map(UserEntity::toDomainModel);
    }

    @Override
    public List<User> findAll() {
        return jpaUserRepository.findAll().stream()
                .map(UserEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteById(UUID id) {
        if (jpaUserRepository.existsById(id)) {
            jpaUserRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<User> update(User user) {
        if (jpaUserRepository.existsById(user.getId())) {
            UserEntity userEntity = UserEntity.fromDomainModel(user);
            UserEntity updatedUserEntity = jpaUserRepository.save(userEntity);
            return Optional.of(updatedUserEntity.toDomainModel());
        }
        return Optional.empty();
    }
}
