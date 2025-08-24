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

@Getter
@Setter
@Entity
@Table(name = "specialist_policies", schema = "directory_service")
public class SpecialistPolicyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @NotNull
    @Column(name = "min_duration", nullable = false)
    private Integer minDuration;

    @ColumnDefault("0")
    @Column(name = "buffer_time")
    private Integer bufferTime;

    @ColumnDefault("10")
    @Column(name = "max_daily")
    private Integer maxDaily;

    @Column(name = "rules")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> rules;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "specialist_id")
    private SpecialistEntity specialist;

    public SpecialistPolicyEntity() {}

    public SpecialistPolicyEntity(UUID id, Integer minDuration, Integer bufferTime, Integer maxDaily, Map<String, Object> rules, SpecialistEntity specialist) {
        this.id = id;
        this.minDuration = minDuration;
        this.bufferTime = bufferTime;
        this.maxDaily = maxDaily;
        this.rules = rules;
        this.specialist = specialist;
    }

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