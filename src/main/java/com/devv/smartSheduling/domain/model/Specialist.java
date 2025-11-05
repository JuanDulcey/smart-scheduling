package com.devv.smartSheduling.domain.model;

import java.time.Instant;
import java.util.UUID;

/**
 * Represents a specialist in the system.
 * <p>
 * A specialist is a professional linked to a user and has a name, specialty,
 * and other information such as creation date and active status.
 * </p>
 */
public class Specialist {

    /** Unique ID of the specialist. */
    private UUID id;

    /** ID of the user connected to this specialist. */
    private UUID userId;

    /** Embedded user object with personal data. */
    private User user;

    /** Name of the specialist. */
    private String name;

    /** Area of specialty (for example: "Electrician", "Engineer"). */
    private String specialty;

    /** Shows if the specialist is active or not. */
    private boolean active = true;

    /** Date and time when the specialist was created. */
    private Instant createdAt = Instant.now();

    /**
     * Empty constructor.
     * <p>
     * Used when creating an empty specialist object.
     * </p>
     */
    public Specialist() {}

    /**
     * Full constructor to create a specialist with all fields.
     *
     * @param id          unique ID of the specialist
     * @param userId      ID of the linked user
     * @param user        user object with user details
     * @param name        name of the specialist
     * @param specialty   type of specialty
     * @param active      true if the specialist is active
     * @param createdAt   creation date of the specialist
     */
    public Specialist(UUID id, UUID userId, User user, String name, String specialty, boolean active, Instant createdAt) {
        this.id = id;
        this.userId = userId;
        this.user = user;
        this.name = name;
        this.specialty = specialty;
        this.active = active;
        this.createdAt = createdAt;
    }

    /** @return the unique ID of the specialist */
    public UUID getId() {
        return id;
    }

    /** @param id sets the unique ID of the specialist */
    public void setId(UUID id) {
        this.id = id;
    }

    /** @return the ID of the linked user */
    public UUID getUserId() {
        return userId;
    }

    /** @param userId sets the ID of the linked user */
    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    /** @return the embedded user object */
    public User getUser() {
        return user;
    }

    /** @param user sets the embedded user object */
    public void setUser(User user) {
        this.user = user;
    }

    /** @return the name of the specialist */
    public String getName() {
        return name;
    }

    /** @param name sets the name of the specialist */
    public void setName(String name) {
        this.name = name;
    }

    /** @return the specialty of the specialist */
    public String getSpecialty() {
        return specialty;
    }

    /** @param specialty sets the specialty of the specialist */
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    /** @return true if the specialist is active */
    public boolean isActive() {
        return active;
    }

    /** @param active sets if the specialist is active */
    public void setActive(boolean active) {
        this.active = active;
    }

    /** @return the creation date of the specialist */
    public Instant getCreatedAt() {
        return createdAt;
    }

    /** @param createdAt sets the creation date of the specialist */
    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
