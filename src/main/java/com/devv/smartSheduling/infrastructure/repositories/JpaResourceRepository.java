package com.devv.smartSheduling.infrastructure.repositories;

import com.devv.smartSheduling.infrastructure.entities.ResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaResourceRepository extends JpaRepository<ResourceEntity, UUID> {
}
