package com.devv.smartSheduling;

import com.devv.smartSheduling.domain.model.Resource;
import com.devv.smartSheduling.infrastructure.entities.ResourceEntity;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ResourceEntityTest {

    @Test
    void testCreateResourceEntity() {
        // 1. Preparar datos de prueba
        UUID id = UUID.randomUUID();
        UUID siteId = UUID.randomUUID();
        String name = "Mi Recurso";
        String type = "Servidor";
        Boolean active = true;

        // 2. Crear el objeto
        ResourceEntity entity = new ResourceEntity(id, siteId, name, type, active);

        // 3. Verificar que se creó correctamente
        assertNotNull(entity);
        assertEquals(id, entity.getId());
        assertEquals(siteId, entity.getSiteId());
        assertEquals(name, entity.getName());
        assertEquals(type, entity.getType());
        assertEquals(active, entity.getActive());
    }

    @Test
    void testConvertToDomainModel() {
        // 1. Preparar datos
        UUID id = UUID.randomUUID();
        ResourceEntity entity = new ResourceEntity(id, null, "Test", "Type", true);

        // 2. Convertir a Domain Model
        Resource domainModel = entity.toDomainModel();

        // 3. Verificar conversión
        assertNotNull(domainModel);
        assertEquals(id, domainModel.getId());
        assertEquals("Test", domainModel.getName());
        assertEquals("Type", domainModel.getType());
        assertTrue(domainModel.getActive());
    }
}
