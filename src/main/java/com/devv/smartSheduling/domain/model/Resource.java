package com.devv.smartSheduling.domain.model;

import java.util.UUID;

public class Resource {

    private UUID id;
    private UUID siteId;
    private String name;
    private String type;
    private Boolean active = true;

    public Resource() {}

    public Resource(UUID id, UUID siteId, String name, String type, Boolean active) {
        this.id = id;
        this.siteId = siteId;
        this.name = name;
        this.type = type;
        this.active = active;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getSiteId() {
        return siteId;
    }

    public void setSiteId(UUID siteId) {
        this.siteId = siteId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}