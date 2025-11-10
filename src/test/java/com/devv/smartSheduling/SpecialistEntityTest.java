package com.devv.smartSheduling;

import com.devv.smartSheduling.domain.model.Specialist;
import com.devv.smartSheduling.infrastructure.entities.SpecialistEntity;
import com.devv.smartSheduling.infrastructure.entities.SpecialistPolicyEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.time.Instant;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class SpecialistEntityTest {

    private final UUID TEST_ID = UUID.fromString("123e4567-e89b-12d3-a456-426614174000");
    private final UUID TEST_USER_ID = UUID.fromString("223e4567-e89b-12d3-a456-426614174000");
    private final String TEST_NAME = "Dr. Juan Pérez";
    private final String TEST_SPECIALTY = "Cardiología";
    private final Boolean TEST_ACTIVE = true;
    private final Instant TEST_CREATED_AT = Instant.now();

    @Test
    @DisplayName("Debería crear SpecialistEntity con constructor por defecto")
    void shouldCreateSpecialistEntityWithDefaultConstructor() {
        // Act
        SpecialistEntity entity = new SpecialistEntity();

        // Assert
        assertNotNull(entity);
        assertNull(entity.getId());
        assertNull(entity.getUserId());
        assertNull(entity.getName());
        assertNull(entity.getSpecialty());
        assertNull(entity.getActive());
        assertNull(entity.getCreatedAt());
        assertNotNull(entity.getSpecialistPolicies());
        assertTrue(entity.getSpecialistPolicies().isEmpty());
    }

    @Test
    @DisplayName("Debería crear SpecialistEntity con constructor parametrizado")
    void shouldCreateSpecialistEntityWithParameterizedConstructor() {
        // Act
        SpecialistEntity entity = new SpecialistEntity(
                TEST_ID, TEST_USER_ID, TEST_NAME, TEST_SPECIALTY, TEST_ACTIVE, TEST_CREATED_AT
        );

        // Assert
        assertNotNull(entity);
        assertEquals(TEST_ID, entity.getId());
        assertEquals(TEST_USER_ID, entity.getUserId());
        assertEquals(TEST_NAME, entity.getName());
        assertEquals(TEST_SPECIALTY, entity.getSpecialty());
        assertEquals(TEST_ACTIVE, entity.getActive());
        assertEquals(TEST_CREATED_AT, entity.getCreatedAt());
    }

    @Test
    @DisplayName("Debería convertir SpecialistEntity a Domain Model correctamente")
    void shouldConvertEntityToDomainModel() {
        // Arrange
        SpecialistEntity entity = new SpecialistEntity(
                TEST_ID, TEST_USER_ID, TEST_NAME, TEST_SPECIALTY, TEST_ACTIVE, TEST_CREATED_AT
        );

        // Act
        Specialist domainModel = entity.toDomainModel();

        // Assert
        assertNotNull(domainModel);
        assertEquals(TEST_ID, domainModel.getId());
        assertEquals(TEST_USER_ID, domainModel.getUserId());
        assertEquals(TEST_NAME, domainModel.getName());
        assertEquals(TEST_SPECIALTY, domainModel.getSpecialty());
        assertEquals(TEST_ACTIVE, domainModel.isActive());
        assertEquals(TEST_CREATED_AT, domainModel.getCreatedAt());
    }

    @Test
    @DisplayName("Debería convertir Domain Model a SpecialistEntity correctamente")
    void shouldConvertDomainModelToEntity() {
        // Arrange
        Specialist domainModel = new Specialist(
                TEST_ID, TEST_USER_ID, null, TEST_NAME, TEST_SPECIALTY, TEST_ACTIVE, TEST_CREATED_AT
        );

        // Act
        SpecialistEntity entity = SpecialistEntity.fromDomainModel(domainModel);

        // Assert
        assertNotNull(entity);
        assertEquals(TEST_ID, entity.getId());
        assertEquals(TEST_USER_ID, entity.getUserId());
        assertEquals(TEST_NAME, entity.getName());
        assertEquals(TEST_SPECIALTY, entity.getSpecialty());
        assertEquals(TEST_ACTIVE, entity.getActive());
        assertEquals(TEST_CREATED_AT, entity.getCreatedAt());
    }

    @Test
    @DisplayName("Debería setear y obtener valores correctamente")
    void shouldSetAndGetValuesCorrectly() {
        // Arrange
        SpecialistEntity entity = new SpecialistEntity();
        UUID newId = UUID.randomUUID();
        UUID newUserId = UUID.randomUUID();
        Instant newCreatedAt = Instant.now().minusSeconds(3600);

        // Act
        entity.setId(newId);
        entity.setUserId(newUserId);
        entity.setName("Nuevo Especialista");
        entity.setSpecialty("Neurología");
        entity.setActive(false);
        entity.setCreatedAt(newCreatedAt);

        // Assert
        assertEquals(newId, entity.getId());
        assertEquals(newUserId, entity.getUserId());
        assertEquals("Nuevo Especialista", entity.getName());
        assertEquals("Neurología", entity.getSpecialty());
        assertFalse(entity.getActive());
        assertEquals(newCreatedAt, entity.getCreatedAt());
    }

    @Test
    @DisplayName("Debería mantener igualdad de datos en conversión bidireccional")
    void shouldMaintainDataEqualityInBidirectionalConversion() {
        // Arrange
        Specialist originalDomainModel = new Specialist(
                TEST_ID, TEST_USER_ID, null, TEST_NAME, TEST_SPECIALTY, TEST_ACTIVE, TEST_CREATED_AT
        );

        // Act
        SpecialistEntity entity = SpecialistEntity.fromDomainModel(originalDomainModel);
        Specialist convertedDomainModel = entity.toDomainModel();

        // Assert
        assertEquals(originalDomainModel.getId(), convertedDomainModel.getId());
        assertEquals(originalDomainModel.getUserId(), convertedDomainModel.getUserId());
        assertEquals(originalDomainModel.getName(), convertedDomainModel.getName());
        assertEquals(originalDomainModel.getSpecialty(), convertedDomainModel.getSpecialty());
        assertEquals(originalDomainModel.isActive(), convertedDomainModel.isActive());
        assertEquals(originalDomainModel.getCreatedAt(), convertedDomainModel.getCreatedAt());
    }

    @Test
    @DisplayName("Debería manejar colección de políticas correctamente")
    void shouldHandlePoliciesCollectionCorrectly() {
        // Arrange
        SpecialistEntity entity = new SpecialistEntity();
        SpecialistPolicyEntity policy = new SpecialistPolicyEntity();

        // Act
        entity.getSpecialistPolicies().add(policy);

        // Assert
        assertNotNull(entity.getSpecialistPolicies());
        assertEquals(1, entity.getSpecialistPolicies().size());
        assertTrue(entity.getSpecialistPolicies().contains(policy));
    }
}