package com.devv.smartSheduling.domain.ports.in.specialist;

import com.devv.smartSheduling.domain.model.Specialist;

public interface CreateSpecialistUseCase {

    /**
     * Crea un nuevo especialista en el sistema.
     * @param specialist entidad con datos del especialista
     * @return especialista creado con ID asignado
     */
    Specialist createSpecialist(Specialist specialist);
}
