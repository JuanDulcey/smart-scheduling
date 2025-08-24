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

@Getter
@Setter
@Entity
@Table(name = "specialists", schema = "directory_service")
public class SpecialistEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "user_id")
    private UUID userId;

    @NotNull
    @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
    private String name;

    @NotNull
    @Column(name = "specialty", nullable = false, length = Integer.MAX_VALUE)
    private String specialty;

    @ColumnDefault("true")
    @Column(name = "active")
    private Boolean active;

    @ColumnDefault("now()")
    @Column(name = "created_at")
    private Instant createdAt;

    @OneToMany
    @JoinColumn(name = "specialist_id")
    private Set<SpecialistPolicyEntity> specialistPolicies = new LinkedHashSet<>();

    public SpecialistEntity() {}

    public SpecialistEntity(UUID id, UUID userId, String name, String specialty, Boolean active, Instant createdAt) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.specialty = specialty;
        this.active = active;
        this.createdAt = createdAt;
    }

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

    public Specialist toDomainModel() {
        return new Specialist(id, userId, name, specialty, active, createdAt);
    }
}