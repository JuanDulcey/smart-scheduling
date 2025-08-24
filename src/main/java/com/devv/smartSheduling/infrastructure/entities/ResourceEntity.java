package com.devv.smartSheduling.infrastructure.entities;

import com.devv.smartSheduling.domain.model.Resource;
import com.devv.smartSheduling.domain.model.Specialist;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "resources", schema = "directory_service")
public class ResourceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "site_id")
    private UUID siteId;

    @NotNull
    @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
    private String name;

    @Column(name = "type", length = Integer.MAX_VALUE)
    private String type;

    @ColumnDefault("true")
    @Column(name = "active")
    private Boolean active;

    public ResourceEntity() {}

    public ResourceEntity(UUID id, UUID siteId, String name, String type, Boolean active) {
        this.id = id;
        this.siteId = siteId;
        this.name = name;
        this.type = type;
        this.active = active;
    }

    public static ResourceEntity fromDomainModel(Resource resource) {
        return new ResourceEntity(
                resource.getId(),
                resource.getSiteId(),
                resource.getName(),
                resource.getType(),
                resource.getActive()
        );
    }

    public Resource toDomainModel() {
        return new Resource(id, siteId, name, type, active);
    }

}