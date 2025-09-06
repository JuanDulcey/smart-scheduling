package com.devv.smartSheduling.infrastructure.config;

import com.devv.smartSheduling.application.services.ResourceService;
import com.devv.smartSheduling.application.services.SpecialistPolicyService;
import com.devv.smartSheduling.application.services.SpecialistService;
import com.devv.smartSheduling.application.services.UserService;
import com.devv.smartSheduling.application.usecases.resource.CreateResourceUseCaseImpl;
import com.devv.smartSheduling.application.usecases.resource.DeleteResourceUseCaseImpl;
import com.devv.smartSheduling.application.usecases.resource.RetrieveResourceUseCaseImpl;
import com.devv.smartSheduling.application.usecases.resource.UpdateResourceUseCaseImpl;
import com.devv.smartSheduling.application.usecases.specialist.*;
import com.devv.smartSheduling.application.usecases.specialistpolicy.CreateSpecialistPolicyUseCaseImpl;
import com.devv.smartSheduling.application.usecases.specialistpolicy.DeleteSpecialistPolicyUseCaseImpl;
import com.devv.smartSheduling.application.usecases.specialistpolicy.RetriveSpecialistPolicyUseCaseImpl;
import com.devv.smartSheduling.application.usecases.specialistpolicy.UpdateSpecialistPolicyUseCaseImpl;
import com.devv.smartSheduling.application.usecases.user.CreateUserUseCaseImpl;
import com.devv.smartSheduling.application.usecases.user.DeleteUserUseCaseImpl;
import com.devv.smartSheduling.application.usecases.user.RetriveUserUseCaseImpl;
import com.devv.smartSheduling.application.usecases.user.UpdateUserUseCaseImpl;
import com.devv.smartSheduling.domain.ports.out.ResourceRepositoryPort;
import com.devv.smartSheduling.domain.ports.out.SpecialistPolicyRepositoryPort;
import com.devv.smartSheduling.domain.ports.out.SpecialistRepositoryPort;
import com.devv.smartSheduling.domain.ports.out.UserRepositoryPort;
import com.devv.smartSheduling.infrastructure.repositories.JpaResourceRepositoryAdapter;
import com.devv.smartSheduling.infrastructure.repositories.JpaSpecialistPolicyRepositoryAdapter;
import com.devv.smartSheduling.infrastructure.repositories.JpaSpecialistRepositoryAdapter;
import com.devv.smartSheduling.infrastructure.repositories.JpaUserRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public UserService userService(UserRepositoryPort userRepositoryPort) {
        return new UserService(
                new CreateUserUseCaseImpl(userRepositoryPort),
                new RetriveUserUseCaseImpl(userRepositoryPort),
                new UpdateUserUseCaseImpl(userRepositoryPort),
                new DeleteUserUseCaseImpl(userRepositoryPort)
        );
    }

    @Bean
    public UserRepositoryPort userRepositoryPort(JpaUserRepositoryAdapter userRepositoryAdapter) {
        return userRepositoryAdapter;
    }

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
                new DeleteSpecialistUseCaseImpl(specialistRepositoryPort),
                new RetrieveSpecialistWithUserUseCaseImpl(specialistRepositoryPort)
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
