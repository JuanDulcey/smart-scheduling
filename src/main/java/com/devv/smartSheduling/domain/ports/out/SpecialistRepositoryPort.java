package com.devv.smartSheduling.domain.ports.out;

import com.devv.smartSheduling.domain.model.Specialist;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Puerto de salida para operaciones de persistencia de especialistas.
 */
public interface SpecialistRepositoryPort {

    /**
     * Guarda o actualiza un especialista.
     * @param specialist Entidad a persistir.
     * @return Entidad persistida.
     */
    Specialist save(Specialist specialist);

    /**
     * Busca un especialista por su ID.
     * @param id Identificador único.
     * @return Optional con el especialista si existe.
     */
    Optional<Specialist> findById(UUID id);

    /**
     * Obtiene todos los especialistas.
     * @return Lista completa.
     */
    List<Specialist> findAll();

    /**
     * Elimina un especialista por ID.
     * @param id Identificador único.
     * @return true si se eliminó, false si no existía.
     */
    boolean deleteById(UUID id);

    /**
     * Actualiza un especialista existente.
     * @param specialist Entidad con datos actualizados.
     * @return Optional con el especialista actualizado si existía.
     */
    Optional<Specialist> update(Specialist specialist);


    /**
     * Busca un especialista y carga también su usuario asociado.
     * @param id Identificador único del especialista.
     * @return Optional con el especialista y su usuario si existe.
     */
    Optional<Specialist> findByIdWithUser(UUID id);

    /**
     * Obtiene todos los especialistas junto con sus usuarios.
     * @return Lista de especialistas con datos de usuario.
     */
    List<Specialist> findAllWithUser();
}
