package com.devv.smartSheduling.domain.model;

import java.time.Instant;
import java.util.UUID;

public class Specialist {

    private UUID id;
    private UUID userId;
    private User user; // ← nuevo campo embebido
    private String name;
    private String specialty;
    private boolean active = true;
    private Instant createdAt = Instant.now();

    public Specialist() {}

    public Specialist(UUID id, UUID userId, User user, String name, String specialty, boolean active, Instant createdAt) {
        this.id = id;
        this.userId = userId;
        this.user = user;
        this.name = name;
        this.specialty = specialty;
        this.active = active;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
