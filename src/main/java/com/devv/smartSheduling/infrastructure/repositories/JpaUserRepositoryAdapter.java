package com.devv.smartSheduling.infrastructure.repositories;

import com.devv.smartSheduling.domain.model.User;
import com.devv.smartSheduling.domain.ports.out.UserRepositoryPort;
import com.devv.smartSheduling.infrastructure.entities.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * JPA adapter for the {@link UserRepositoryPort} interface.
 * <p>
 * This class connects the domain model {@link User}
 * with the database using JPA entities.
 * It handles basic operations like save, find, update and delete.
 * </p>
 */
@Repository
public class JpaUserRepositoryAdapter implements UserRepositoryPort {

    /**
     * JPA repository for UserEntity.
     */
    private final JpaUserRepository jpaUserRepository;

    /**
     * Constructor with required repository.
     *
     * @param jpaUserRepository JPA repository for users
     */
    public JpaUserRepositoryAdapter(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    /**
     * Saves a new user.
     * <p>
     * Converts the domain model to entity and stores it.
     * </p>
     *
     * @param user Domain model to save
     * @return Saved domain model
     */
    @Override
    public User save(User user) {
        UserEntity userEntity = UserEntity.fromDomainModel(user);
        UserEntity savedUserEntity = jpaUserRepository.save(userEntity);
        return savedUserEntity.toDomainModel();
    }

    /**
     * Finds a user by ID.
     *
     * @param id User ID
     * @return Optional with domain model
     */
    @Override
    public Optional<User> findById(UUID id) {
        return jpaUserRepository.findById(id).map(UserEntity::toDomainModel);
    }

    /**
     * Returns all users.
     *
     * @return List of domain models
     */
    @Override
    public List<User> findAll() {
        return jpaUserRepository.findAll().stream()
                .map(UserEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    /**
     * Deletes a user by ID.
     *
     * @param id User ID
     * @return true if deleted, false if not found
     */
    @Override
    public boolean deleteById(UUID id) {
        if (jpaUserRepository.existsById(id)) {
            jpaUserRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Updates an existing user.
     * <p>
     * Checks if the user exists, then saves the new data.
     * </p>
     *
     * @param user Domain model to update
     * @return Optional with updated domain model
     */
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
