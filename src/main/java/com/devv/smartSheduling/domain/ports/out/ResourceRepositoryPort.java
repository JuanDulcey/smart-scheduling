package com.devv.smartSheduling.domain.ports.out;

import com.devv.smartSheduling.domain.model.Resource;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Puerto de salida para la persistencia de recursos.
 * <p>
 * Define las operaciones que cualquier implementación de repositorio
 * (por ejemplo, basada en JPA, JDBC, o cualquier otra tecnología de almacenamiento)
 * debe cumplir para interactuar con la entidad de dominio {@link Resource}.
 */

public interface ResourceRepositoryPort {
    /**
     * Persiste un recurso en el almacenamiento.
     * <p>
     * Si el recurso ya existe (por ID), se actualiza; si no existe, se inserta.
     *
     * @param resource recurso de dominio a persistir.
     * @return el recurso persistido con posibles valores actualizados (ej: ID autogenerado).
     */
    Resource save(Resource resource);

    /**
     * Busca un recurso por su identificador único.
     *
     * @param id identificador único del recurso.
     * @return un {@link Optional} que contiene el recurso si se encuentra,
     * o vacío en caso contrario.
     */
    Optional<Resource> findById(UUID id);

    /**
     * Obtiene todos los recursos almacenados.
     *
     * @return lista completa de recursos.
     */
    List<Resource> findAll();

    /**
     * Elimina un recurso según su identificador único.
     *
     * @param id identificador único del recurso.
     * @return {@code true} si el recurso existía y fue eliminado,
     * {@code false} si no se encontró.
     */
    boolean deleteById(UUID id);

    /**
     * Actualiza los datos de un recurso existente.
     *
     * @param resource recurso de dominio con los datos actualizados.
     * @return un {@link Optional} que contiene el recurso actualizado si existía,
     * o vacío en caso contrario.
     */
    Optional<Resource> update(Resource resource);
}
