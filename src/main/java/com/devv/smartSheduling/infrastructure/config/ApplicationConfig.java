package com.devv.smartSheduling.infrastructure.config;

import com.devv.smartSheduling.application.services.ResourceService;
import com.devv.smartSheduling.application.services.SpecialistPolicyService;
import com.devv.smartSheduling.application.services.SpecialistService;
import com.devv.smartSheduling.application.usecases.resource.CreateResourceUseCaseImpl;
import com.devv.smartSheduling.application.usecases.resource.DeleteResourceUseCaseImpl;
import com.devv.smartSheduling.application.usecases.resource.RetrieveResourceUseCaseImpl;
import com.devv.smartSheduling.application.usecases.resource.UpdateResourceUseCaseImpl;
import com.devv.smartSheduling.application.usecases.specialist.CreateSpecialistUseCaseImpl;
import com.devv.smartSheduling.application.usecases.specialist.DeleteSpecialistUseCaseImpl;
import com.devv.smartSheduling.application.usecases.specialist.RetrieveSpecialistUseCaseImpl;
import com.devv.smartSheduling.application.usecases.specialist.UpdateSpecialistUseCaseImpl;
import com.devv.smartSheduling.application.usecases.specialistpolicy.CreateSpecialistPolicyUseCaseImpl;
import com.devv.smartSheduling.application.usecases.specialistpolicy.DeleteSpecialistPolicyUseCaseImpl;
import com.devv.smartSheduling.application.usecases.specialistpolicy.RetriveSpecialistPolicyUseCaseImpl;
import com.devv.smartSheduling.application.usecases.specialistpolicy.UpdateSpecialistPolicyUseCaseImpl;
import com.devv.smartSheduling.domain.ports.out.ResourceRepositoryPort;
import com.devv.smartSheduling.domain.ports.out.SpecialistPolicyRepositoryPort;
import com.devv.smartSheduling.domain.ports.out.SpecialistRepositoryPort;
import com.devv.smartSheduling.infrastructure.repositories.JpaResourceRepositoryAdapter;
import com.devv.smartSheduling.infrastructure.repositories.JpaSpecialistPolicyRepositoryAdapter;
import com.devv.smartSheduling.infrastructure.repositories.JpaSpecialistRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public SpecialistPolicyService  specialistPolicyService(SpecialistPolicyRepositoryPort specialistPolicyRepositoryPort) {
        return new SpecialistPolicyService(
                new CreateSpecialistPolicyUseCaseImpl(specialistPolicyRepositoryPort),
                new DeleteSpecialistPolicyUseCaseImpl(specialistPolicyRepositoryPort),
                new RetriveSpecialistPolicyUseCaseImpl(specialistPolicyRepositoryPort),
                new UpdateSpecialistPolicyUseCaseImpl(specialistPolicyRepositoryPort)
        );
    }

    @Bean
    public SpecialistPolicyRepositoryPort specialistPolicyRepositoryPort(JpaSpecialistPolicyRepositoryAdapter  specialistPolicyRepositoryAdapter) {
        return specialistPolicyRepositoryAdapter;
    }

    @Bean
    public SpecialistService specialistService(SpecialistRepositoryPort specialistRepositoryPort) {
        return new SpecialistService(
                new CreateSpecialistUseCaseImpl(specialistRepositoryPort),
                new RetrieveSpecialistUseCaseImpl(specialistRepositoryPort),
                new UpdateSpecialistUseCaseImpl(specialistRepositoryPort),
                new DeleteSpecialistUseCaseImpl(specialistRepositoryPort)
        );
    }

    @Bean
    public SpecialistRepositoryPort specialistRepositoryPort(JpaSpecialistRepositoryAdapter jpaSpecialistRepositoryAdapter) {
        return jpaSpecialistRepositoryAdapter;
    }

    @Bean
    public ResourceService resourceService(ResourceRepositoryPort resourceRepositoryPort) {
        return new ResourceService(
                new CreateResourceUseCaseImpl(resourceRepositoryPort),
                new DeleteResourceUseCaseImpl(resourceRepositoryPort),
                new RetrieveResourceUseCaseImpl(resourceRepositoryPort),
                new UpdateResourceUseCaseImpl(resourceRepositoryPort)
        );
    }

    @Bean
    public ResourceRepositoryPort resourceRepositoryPort(JpaResourceRepositoryAdapter jpaResourceRepositoryAdapter) {
        return jpaResourceRepositoryAdapter;
    }
}
