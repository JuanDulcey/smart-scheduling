package com.devv.smartSheduling.infrastructure.entities;

import com.devv.smartSheduling.domain.model.Resource;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.UUID;

/**
 * JPA entity for the Resource table.
 * <p>
 * Maps the {@link Resource} domain model to the database table "resources"
 * in the schema "directory_service".
 * </p>
 */
@Getter
@Setter
@Entity
@Table(name = "resources", schema = "directory_service")
public class ResourceEntity {

    /**
     * Unique identifier for the resource.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    /**
     * Identifier of the site the resource belongs to.
     */
    @Column(name = "site_id")
    private UUID siteId;

    /**
     * Name of the resource. Cannot be null.
     */
    @NotNull
    @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
    private String name;

    /**
     * Type of the resource (optional).
     */
    @Column(name = "type", length = Integer.MAX_VALUE)
    private String type;

    /**
     * Active status of the resource. Defaults to true.
     */
    @ColumnDefault("true")
    @Column(name = "active")
    private Boolean active;

    /**
     * Default constructor.
     */
    public ResourceEntity() {}

    /**
     * Constructor with all fields.
     *
     * @param id resource ID
     * @param siteId site ID
     * @param name resource name
     * @param type resource type
     * @param active resource active status
     */
    public ResourceEntity(UUID id, UUID siteId, String name, String type, Boolean active) {
        this.id = id;
        this.siteId = siteId;
        this.name = name;
        this.type = type;
        this.active = active;
    }

    /**
     * Convert a domain model {@link Resource} to an entity.
     *
     * @param resource domain resource
     * @return corresponding {@link ResourceEntity}
     */
    public static ResourceEntity fromDomainModel(Resource resource) {
        return new ResourceEntity(
                resource.getId(),
                resource.getSiteId(),
                resource.getName(),
                resource.getType(),
                resource.getActive()
        );
    }

    /**
     * Convert this entity to the domain model {@link Resource}.
     *
     * @return domain resource
     */
    public Resource toDomainModel() {
        return new Resource(id, siteId, name, type, active);
    }

}