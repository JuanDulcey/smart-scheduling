package com.devv.smartSheduling.infrastructure.repositories;

import com.devv.smartSheduling.infrastructure.entities.SpecialistPolicyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaSpecialistPolicyRepository extends JpaRepository<SpecialistPolicyEntity, UUID> {
}
