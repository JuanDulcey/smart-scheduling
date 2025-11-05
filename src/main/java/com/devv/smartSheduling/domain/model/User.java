package com.devv.smartSheduling.domain.model;

import java.util.UUID;

/**
 * Represents a system user.
 * <p>
 * A user has an email, full name, phone number, and active status.
 * </p>
 */
public class User {

    /** Unique ID of the user. */
    private UUID id;

    /** Email address of the user. */
    private String email;

    /** Full name of the user. */
    private String fullName;

    /** Phone number of the user. */
    private String phone;

    /** True if the user is active, false otherwise. */
    private boolean isActive;

    /**
     * Empty constructor.
     * <p>
     * Used when creating an empty user object.
     * </p>
     */

    public User() {}

    /**
     * Full constructor to create a user with all fields.
     *
     * @param id        unique ID of the user
     * @param email     email address of the user
     * @param fullName  full name of the user
     * @param phone     phone number of the user
     * @param isActive  true if the user is active
     */
    public User(UUID id, String email, String fullName, String phone, boolean isActive) {
        this.id = id;
        this.email = email;
        this.fullName = fullName;
        this.phone = phone;
        this.isActive = isActive;
    }

    /** @return the unique ID of the user */
    public UUID getId() {
        return id;
    }

    /** @param id sets the unique ID of the user */
    public void setId(UUID id) {
        this.id = id;
    }

    /** @return the email address of the user */
    public String getEmail() {
        return email;
    }

    /** @param email sets the email address of the user */
    public void setEmail(String email) {
        this.email = email;
    }

    /** @return the full name of the user */
    public String getFullName() {
        return fullName;
    }

    /** @param fullName sets the full name of the user */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /** @return the phone number of the user */
    public String getPhone() {
        return phone;
    }

    /** @param phone sets the phone number of the user */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /** @return true if the user is active */
    public boolean isActive() {
        return isActive;
    }

    /** @param active sets if the user is active or not */
    public void setActive(boolean active) {
        isActive = active;
    }
}
