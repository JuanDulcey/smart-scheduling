package com.devv.smartSheduling;

import com.devv.smartSheduling.domain.model.SpecialistPolicy;
import com.devv.smartSheduling.infrastructure.entities.SpecialistEntity;
import com.devv.smartSheduling.infrastructure.entities.SpecialistPolicyEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class SpecialistPolicyEntityTest {

    private final UUID TEST_ID = UUID.fromString("333e4567-e89b-12d3-a456-426614174000");
    private final Integer TEST_MIN_DURATION = 30;
    private final Integer TEST_BUFFER_TIME = 10;
    private final Integer TEST_MAX_DAILY = 15;

    @Test
    @DisplayName("Debería crear SpecialistPolicyEntity con constructor por defecto")
    void shouldCreateSpecialistPolicyEntityWithDefaultConstructor() {
        // Act
        SpecialistPolicyEntity entity = new SpecialistPolicyEntity();

        // Assert
        assertNotNull(entity);
        assertNull(entity.getId());
        assertNull(entity.getMinDuration());
        assertNull(entity.getBufferTime());
        assertNull(entity.getMaxDaily());
        assertNull(entity.getRules());
        assertNull(entity.getSpecialist());
    }

    @Test
    @DisplayName("Debería crear SpecialistPolicyEntity con constructor parametrizado")
    void shouldCreateSpecialistPolicyEntityWithParameterizedConstructor() {
        // Arrange
        Map<String, Object> testRules = new HashMap<>();
        testRules.put("allowWeekends", false);
        testRules.put("maxConcurrent", 2);

        SpecialistEntity specialistEntity = new SpecialistEntity();

        // Act
        SpecialistPolicyEntity entity = new SpecialistPolicyEntity(
                TEST_ID, TEST_MIN_DURATION, TEST_BUFFER_TIME, TEST_MAX_DAILY,
                testRules, specialistEntity
        );

        // Assert
        assertNotNull(entity);
        assertEquals(TEST_ID, entity.getId());
        assertEquals(TEST_MIN_DURATION, entity.getMinDuration());
        assertEquals(TEST_BUFFER_TIME, entity.getBufferTime());
        assertEquals(TEST_MAX_DAILY, entity.getMaxDaily());
        assertEquals(testRules, entity.getRules());
        assertEquals(specialistEntity, entity.getSpecialist());
    }

    @Test
    @DisplayName("Debería convertir Domain Model a SpecialistPolicyEntity correctamente")
    void shouldConvertDomainModelToEntity() {
        // Arrange
        Map<String, Object> testRules = new HashMap<>();
        testRules.put("maxOvertime", 60);

        SpecialistPolicy domainModel = new SpecialistPolicy(
                TEST_ID, null, TEST_MIN_DURATION, TEST_BUFFER_TIME,
                TEST_MAX_DAILY, testRules
        );

        SpecialistEntity specialistEntity = new SpecialistEntity();

        // Act
        SpecialistPolicyEntity entity = SpecialistPolicyEntity.fromDomainModel(domainModel, specialistEntity);

        // Assert
        assertNotNull(entity);
        assertEquals(TEST_ID, entity.getId());
        assertEquals(TEST_MIN_DURATION, entity.getMinDuration());
        assertEquals(TEST_BUFFER_TIME, entity.getBufferTime());
        assertEquals(TEST_MAX_DAILY, entity.getMaxDaily());
        assertEquals(testRules, entity.getRules());
        assertEquals(specialistEntity, entity.getSpecialist());
    }

    @Test
    @DisplayName("Debería manejar valores nulos en campos de reglas")
    void shouldHandleNullValuesInRules() {
        // Arrange
        SpecialistPolicyEntity entity = new SpecialistPolicyEntity();
        entity.setId(TEST_ID);
        entity.setMinDuration(TEST_MIN_DURATION);
        // rules y specialist son null

        // Act
        SpecialistPolicy domainModel = entity.toDomainModel();

        // Assert
        assertNotNull(domainModel);
        assertEquals(TEST_ID, domainModel.getId());
        assertEquals(TEST_MIN_DURATION, domainModel.getMinDuration());
        assertNull(domainModel.getRules());
        assertNull(domainModel.getSpecialist());
    }

    @Test
    @DisplayName("Debería setear y obtener valores correctamente")
    void shouldSetAndGetValuesCorrectly() {
        // Arrange
        SpecialistPolicyEntity entity = new SpecialistPolicyEntity();
        UUID newId = UUID.randomUUID();
        Map<String, Object> newRules = new HashMap<>();
        newRules.put("breakTime", 45);
        newRules.put("autoConfirm", true);

        SpecialistEntity newSpecialist = new SpecialistEntity();
        newSpecialist.setId(UUID.randomUUID());

        // Act
        entity.setId(newId);
        entity.setMinDuration(45);
        entity.setBufferTime(15);
        entity.setMaxDaily(20);
        entity.setRules(newRules);
        entity.setSpecialist(newSpecialist);

        // Assert
        assertEquals(newId, entity.getId());
        assertEquals(45, entity.getMinDuration());
        assertEquals(15, entity.getBufferTime());
        assertEquals(20, entity.getMaxDaily());
        assertEquals(newRules, entity.getRules());
        assertEquals(newSpecialist, entity.getSpecialist());
        assertTrue(entity.getRules().containsKey("breakTime"));
        assertTrue((Boolean) entity.getRules().get("autoConfirm"));
    }

    @Test
    @DisplayName("Debería manejar reglas JSON complejas correctamente")
    void shouldHandleComplexJsonRulesCorrectly() {
        // Arrange
        Map<String, Object> complexRules = new HashMap<>();
        Map<String, Object> schedule = new HashMap<>();
        schedule.put("monday", true);
        schedule.put("friday", true);
        schedule.put("weekend", false);

        complexRules.put("schedule", schedule);
        complexRules.put("priorities", new String[]{"emergency", "follow-up", "regular"});
        complexRules.put("settings", Map.of("timezone", "UTC-5", "notifications", true));

        SpecialistPolicyEntity entity = new SpecialistPolicyEntity();
        entity.setRules(complexRules);

        // Act
        SpecialistPolicy domainModel = entity.toDomainModel();

        // Assert
        assertNotNull(domainModel.getRules());
        assertTrue(domainModel.getRules().containsKey("schedule"));
        assertTrue(domainModel.getRules().containsKey("priorities"));
        assertTrue(domainModel.getRules().containsKey("settings"));

        @SuppressWarnings("unchecked")
        Map<String, Object> retrievedSchedule = (Map<String, Object>) domainModel.getRules().get("schedule");
        assertTrue((Boolean) retrievedSchedule.get("monday"));
        assertFalse((Boolean) retrievedSchedule.get("weekend"));
    }
}
