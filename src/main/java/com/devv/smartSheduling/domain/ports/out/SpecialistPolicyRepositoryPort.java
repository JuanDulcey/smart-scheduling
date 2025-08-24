package com.devv.smartSheduling.domain.ports.out;

import com.devv.smartSheduling.domain.model.SpecialistPolicy;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Puerto de salida para la persistencia de políticas de especialistas.
 */

public interface SpecialistPolicyRepositoryPort {

    /**
     * Guarda o actualiza una política de especialista.
     * @param specialistPolicy Entidad a persistir.
     * @return Entidad persistida.
     */
    SpecialistPolicy save(SpecialistPolicy specialistPolicy);

    /**
     * Busca una política por su ID.
     * @param id Identificador único.
     * @return Optional con la política si existe.
     */
    Optional<SpecialistPolicy> findById(UUID id);

    /**
     * Obtiene todas las políticas.
     * @return Lista completa.
     */
    List<SpecialistPolicy> findAll();

    /**
     * Elimina una política por ID.
     * @param id Identificador único.
     * @return true si se eliminó, false si no existía.
     */
    boolean deleteById(UUID id);

    /**
     * Actualiza una política existente.
     * @param specialistPolicy Entidad con datos actualizados.
     * @return Optional con la política actualizada si existía.
     */
    Optional<SpecialistPolicy> update(SpecialistPolicy specialistPolicy);
}

