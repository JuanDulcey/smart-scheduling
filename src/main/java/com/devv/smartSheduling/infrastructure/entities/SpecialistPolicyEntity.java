package com.devv.smartSheduling.infrastructure.entities;

import com.devv.smartSheduling.domain.model.SpecialistPolicy;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.type.SqlTypes;

import java.util.Map;
import java.util.UUID;

/**
 * Represents the JPA entity for the "specialist_policies" table.
 * <p>
 * Maps the {@link SpecialistPolicy} domain model to the database layer.
 * Stores scheduling rules and constraints associated with a specialist.
 * </p>
 */
@Getter
@Setter
@Entity
@Table(name = "specialist_policies", schema = "directory_service")
public class SpecialistPolicyEntity {

    /**
     * Primary key for the specialist policy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    /**
     * Minimum duration allowed for appointments in minutes.
     * This field is required and cannot be null.
     */
    @NotNull
    @Column(name = "min_duration", nullable = false)
    private Integer minDuration;

    /**
     * Time buffer between appointments in minutes.
     * Defaults to 0 if not specified.
     */
    @ColumnDefault("0")
    @Column(name = "buffer_time")
    private Integer bufferTime;

    /**
     * Maximum number of appointments per day.
     * Defaults to 10 if not specified.
     */
    @ColumnDefault("10")
    @Column(name = "max_daily")
    private Integer maxDaily;

    /**
     * Flexible JSON-based rules for scheduling.
     * Can store additional constraints or configuration for the specialist.
     */
    @Column(name = "rules")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> rules;

    /**
     * Many-to-one relation with {@link SpecialistEntity}.
     * Each policy belongs to one specialist.
     * Cascade deletion is applied: if the specialist is deleted, associated policies are removed.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "specialist_id")
    private SpecialistEntity specialist;

    /**
     * Default constructor for JPA.
     */
    public SpecialistPolicyEntity() {}

    /**
     * Full constructor for creating a policy entity manually.
     *
     * @param id policy ID
     * @param minDuration minimum duration of appointments
     * @param bufferTime buffer time between appointments
     * @param maxDaily maximum daily appointments
     * @param rules additional scheduling rules as JSON
     * @param specialist associated specialist entity
     */
    public SpecialistPolicyEntity(UUID id, Integer minDuration, Integer bufferTime, Integer maxDaily, Map<String, Object> rules, SpecialistEntity specialist) {
        this.id = id;
        this.minDuration = minDuration;
        this.bufferTime = bufferTime;
        this.maxDaily = maxDaily;
        this.rules = rules;
        this.specialist = specialist;
    }

    /**
     * Converts a domain model {@link SpecialistPolicy} into a JPA entity.
     *
     * @param specialistPolicy the domain object to convert
     * @param specialistEntity the associated specialist entity
     * @return corresponding JPA entity
     */
    public static SpecialistPolicyEntity fromDomainModel(SpecialistPolicy specialistPolicy, SpecialistEntity specialistEntity) {
        return new SpecialistPolicyEntity(
                specialistPolicy.getId(),
                specialistPolicy.getMinDuration(),
                specialistPolicy.getBufferTime(),
                specialistPolicy.getMaxDaily(),
                specialistPolicy.getRules(),
                specialistEntity
        );
    }

    /**
     * Converts this JPA entity into a domain model {@link SpecialistPolicy}.
     *
     * @return corresponding domain model object
     */
    public SpecialistPolicy toDomainModel() {
        return new SpecialistPolicy(
                id,
                specialist != null ? specialist.toDomainModel() : null,
                minDuration,
                bufferTime,
                maxDaily,
                rules
        );
    }
}