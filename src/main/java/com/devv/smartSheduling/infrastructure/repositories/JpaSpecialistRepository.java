package com.devv.smartSheduling.infrastructure.repositories;

import com.devv.smartSheduling.infrastructure.entities.SpecialistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface JpaSpecialistRepository extends JpaRepository<SpecialistEntity, UUID> {

}
