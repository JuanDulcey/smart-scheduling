package com.devv.smartSheduling.infrastructure.entities;

import com.devv.smartSheduling.domain.model.Specialist;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Represents the JPA entity for the "specialists" table.
 * <p>
 * Maps the {@link Specialist} domain model to the database layer.
 * Maintains relations with policies and optionally with a user.
 * </p>
 */
@Getter
@Setter
@Entity
@Table(name = "specialists", schema = "directory_service")
public class SpecialistEntity {

    /**
     * Primary key of the specialist.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    /**
     * ID of the user linked to the specialist.
     */
    @Column(name = "user_id")
    private UUID userId;

    /**
     * Name of the specialist. Cannot be null.
     */
    @NotNull
    @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
    private String name;

    /**
     * Specialty of the specialist. Cannot be null.
     */
    @NotNull
    @Column(name = "specialty", nullable = false, length = Integer.MAX_VALUE)
    private String specialty;

    /**
     * Shows if the specialist is active. Default is true.
     */
    @ColumnDefault("true")
    @Column(name = "active")
    private Boolean active;

    /**
     * Date and time when the specialist was created. Default is now.
     */
    @ColumnDefault("now()")
    @Column(name = "created_at")
    private Instant createdAt;

    /**
     * List of policies linked to this specialist.
     */
    @OneToMany
    @JoinColumn(name = "specialist_id")
    private Set<SpecialistPolicyEntity> specialistPolicies = new LinkedHashSet<>();

    /**
     * User linked to this specialist. Read-only.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private UserEntity user;

    /**
     * Empty constructor for JPA.
     */
    public SpecialistEntity() {}

    /**
     * Constructor with all fields.
     *
     * @param id         Specialist ID
     * @param userId     User ID
     * @param name       Specialist name
     * @param specialty  Specialist specialty
     * @param active     Is active
     * @param createdAt  Creation date
     */
    public SpecialistEntity(UUID id, UUID userId, String name, String specialty, Boolean active, Instant createdAt) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.specialty = specialty;
        this.active = active;
        this.createdAt = createdAt;
    }

    /**
     * Converts a domain model to an entity.
     *
     * @param specialist Domain model
     * @return SpecialistEntity
     */
    public static SpecialistEntity fromDomainModel(Specialist specialist) {
        return new SpecialistEntity(
                specialist.getId(),
                specialist.getUserId(),
                specialist.getName(),
                specialist.getSpecialty(),
                specialist.isActive(),
                specialist.getCreatedAt()
        );
    }

    /**
     * Converts this entity to a domain model.
     *
     * @return Specialist domain model
     */
    public Specialist toDomainModel() {
        return new Specialist(
                id,
                userId,
                user != null ? user.toDomainModel() : null,
                name,
                specialty,
                active,
                createdAt
        );
    }
}