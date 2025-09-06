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

@Getter
@Setter
@Entity
@Table(name = "users", schema = "auth_service")
public class UserEntity {
    @Id
    @ColumnDefault("gen_random_uuid()")
    @Column(name = "id", nullable = false)
    private UUID id;

    @NotNull
    @Column(name = "email", nullable = false, length = Integer.MAX_VALUE)
    private String email;

    @Column(name = "full_name", length = Integer.MAX_VALUE)
    private String fullName;

    @Column(name = "phone", length = Integer.MAX_VALUE)
    private String phone;

    @ColumnDefault("true")
    @Column(name = "is_active")
    private Boolean isActive;

    @OneToMany
    @JoinColumn(name = "user_id")
    private Set<SpecialistEntity> specialists = new LinkedHashSet<>();

    public UserEntity() {}

    public UserEntity(UUID id, String email, String fullName, String phone, Boolean isActive) {
        this.id = id;
        this.email = email;
        this.fullName = fullName;
        this.phone = phone;
        this.isActive = isActive;
    }

    public static UserEntity fromDomainModel(User user) {
        return new UserEntity(
                user.getId(),
                user.getEmail(),
                user.getFullName(),
                user.getPhone(),
                user.isActive()
        );
    }

    public User toDomainModel() {
        return new User(id, email, fullName, phone, isActive);
    }
}