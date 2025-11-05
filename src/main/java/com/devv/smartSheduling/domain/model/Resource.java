package com.devv.smartSheduling.domain.model;

import java.util.UUID;

/**
 * Represents a resource in the system.
 * <p>
 * A resource can be a tool, space, or item that belongs to a specific site.
 * Each resource has an ID, a name, a type, and an active status.
 * </p>
 */
public class Resource {

    /** Unique ID of the resource. */
    private UUID id;

    /** ID of the site where this resource belongs. */
    private UUID siteId;

    /** Name of the resource. */
    private String name;

    /** Type of the resource (for example: "room", "equipment", etc.). */
    private String type;

    /** Shows if the resource is active or not. */
    private Boolean active = true;

    /**
     * Empty constructor.
     * <p>
     * Used when creating an empty resource object.
     * </p>
     */
    public Resource() {}

    /**
     * Full constructor to create a complete resource.
     *
     * @param id      the unique ID of the resource
     * @param siteId  the site ID related to the resource
     * @param name    the name of the resource
     * @param type    the type of the resource
     * @param active  true if the resource is active
     */
    public Resource(UUID id, UUID siteId, String name, String type, Boolean active) {
        this.id = id;
        this.siteId = siteId;
        this.name = name;
        this.type = type;
        this.active = active;
    }

    /** @return the unique ID of the resource */
    public UUID getId() {
        return id;
    }

    /** @param id sets the unique ID of the resource */
    public void setId(UUID id) {
        this.id = id;
    }

    /** @return the ID of the site related to this resource */
    public UUID getSiteId() {
        return siteId;
    }

    /** @param siteId sets the ID of the site related to this resource */
    public void setSiteId(UUID siteId) {
        this.siteId = siteId;
    }

    /** @return the name of the resource */
    public String getName() {
        return name;
    }

    /** @param name sets the name of the resource */
    public void setName(String name) {
        this.name = name;
    }

    /** @return the type of the resource */
    public String getType() {
        return type;
    }

    /** @param type sets the type of the resource */
    public void setType(String type) {
        this.type = type;
    }

    /** @return true if the resource is active */
    public Boolean getActive() {
        return active;
    }

    /** @return true if the resource is active */
    public void setActive(Boolean active) {
        this.active = active;
    }
}