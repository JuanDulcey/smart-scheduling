package com.devv.smartSheduling.infrastructure.entities;

import com.devv.smartSheduling.domain.model.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Represents the JPA entity for the "users" table in the "auth_service" schema.
 * <p>
 * Maps the {@link User} domain model to the database layer.
 * Stores user account information and links to associated specialists.
 * </p>
 */
@Getter
@Setter
@Entity
@Table(name = "users", schema = "auth_service")
public class UserEntity {

    /**
     * Primary key for the user entity.
     * Defaults to a generated random UUID.
     */
    @Id
    @ColumnDefault("gen_random_uuid()")
    @Column(name = "id", nullable = false)
    private UUID id;

    /**
     * User's email address.
     * Cannot be null and is required for identification.
     */
    @NotNull
    @Column(name = "email", nullable = false, length = Integer.MAX_VALUE)
    private String email;

    /**
     * Full name of the user.
     * Optional field for additional user information.
     */
    @Column(name = "full_name", length = Integer.MAX_VALUE)
    private String fullName;

    /**
     * Contact phone number of the user.
     * Optional field for additional communication.
     */
    @Column(name = "phone", length = Integer.MAX_VALUE)
    private String phone;

    /**
     * Flag indicating whether the user account is active.
     * Defaults to true.
     */
    @ColumnDefault("true")
    @Column(name = "is_active")
    private Boolean isActive;

    /**
     * One-to-many relationship with {@link SpecialistEntity}.
     * Represents all specialists associated with this user.
     */
    @OneToMany
    @JoinColumn(name = "user_id")
    private Set<SpecialistEntity> specialists = new LinkedHashSet<>();

    /**
     * Default constructor for JPA.
     */
    public UserEntity() {}

    /**
     * Full constructor for creating a UserEntity manually.
     *
     * @param id user ID
     * @param email user email
     * @param fullName full name
     * @param phone phone number
     * @param isActive active status
     */
    public UserEntity(UUID id, String email, String fullName, String phone, Boolean isActive) {
        this.id = id;
        this.email = email;
        this.fullName = fullName;
        this.phone = phone;
        this.isActive = isActive;
    }

    /**
     * Converts a {@link User} domain model into a JPA entity.
     *
     * @param user the domain object to convert
     * @return corresponding JPA entity
     */
    public static UserEntity fromDomainModel(User user) {
        return new UserEntity(
                user.getId(),
                user.getEmail(),
                user.getFullName(),
                user.getPhone(),
                user.isActive()
        );
    }

    /**
     * Converts this JPA entity into a {@link User} domain model.
     *
     * @return corresponding domain model object
     */
    public User toDomainModel() {
        return new User(id, email, fullName, phone, isActive);
    }
}