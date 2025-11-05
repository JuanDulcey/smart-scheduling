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
import com.devv.smartSheduling.application.usecases.specialistpolicy.RetrieveSpecialistPolicyUseCaseImpl;
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

    /**
     * User service bean.
     * <p>
     * Provides operations to create, read, update, and delete users.
     * </p>
     *
     * @param userRepositoryPort the user repository
     * @return a UserService instance
     */
    @Bean
    public UserService userService(UserRepositoryPort userRepositoryPort) {
        return new UserService(
                new CreateUserUseCaseImpl(userRepositoryPort),
                new RetriveUserUseCaseImpl(userRepositoryPort),
                new UpdateUserUseCaseImpl(userRepositoryPort),
                new DeleteUserUseCaseImpl(userRepositoryPort)
        );
    }

    /**
     * User repository bean.
     * <p>
     * Provides access to user data persistence operations.
     * </p>
     *
     * @param userRepositoryAdapter the JPA user adapter
     * @return a UserRepositoryPort instance
     */
    @Bean
    public UserRepositoryPort userRepositoryPort(JpaUserRepositoryAdapter userRepositoryAdapter) {
        return userRepositoryAdapter;
    }

    /**
     * Specialist policy service bean.
     * <p>
     * Provides operations to create, read, update, and delete specialist policies.
     * </p>
     *
     * @param specialistPolicyRepositoryPort the specialist policy repository
     * @return a SpecialistPolicyService instance
     */
    @Bean
    public SpecialistPolicyService  specialistPolicyService(SpecialistPolicyRepositoryPort specialistPolicyRepositoryPort) {
        return new SpecialistPolicyService(
                new CreateSpecialistPolicyUseCaseImpl(specialistPolicyRepositoryPort),
                new DeleteSpecialistPolicyUseCaseImpl(specialistPolicyRepositoryPort),
                new RetrieveSpecialistPolicyUseCaseImpl(specialistPolicyRepositoryPort),
                new UpdateSpecialistPolicyUseCaseImpl(specialistPolicyRepositoryPort)
        );
    }

    /**
     * Specialist policy repository bean.
     * <p>
     * Provides access to specialist policy persistence operations.
     * </p>
     *
     * @param specialistPolicyRepositoryAdapter the JPA policy adapter
     * @return a SpecialistPolicyRepositoryPort instance
     */
    @Bean
    public SpecialistPolicyRepositoryPort specialistPolicyRepositoryPort(JpaSpecialistPolicyRepositoryAdapter  specialistPolicyRepositoryAdapter) {
        return specialistPolicyRepositoryAdapter;
    }

    /**
     * Specialist service bean.
     * <p>
     * Provides operations to create, read, update, delete specialists,
     * and get specialists with their user data.
     * </p>
     *
     * @param specialistRepositoryPort the specialist repository
     * @return a SpecialistService instance
     */
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

    /**
     * Specialist repository bean.
     * <p>
     * Provides access to specialist persistence operations.
     * </p>
     *
     * @param jpaSpecialistRepositoryAdapter the JPA specialist adapter
     * @return a SpecialistRepositoryPort instance
     */
    @Bean
    public SpecialistRepositoryPort specialistRepositoryPort(JpaSpecialistRepositoryAdapter jpaSpecialistRepositoryAdapter) {
        return jpaSpecialistRepositoryAdapter;
    }

    /**
     * Resource service bean.
     * <p>
     * Provides operations to create, read, update, and delete resources.
     * </p>
     *
     * @param resourceRepositoryPort the resource repository
     * @return a ResourceService instance
     */
    @Bean
    public ResourceService resourceService(ResourceRepositoryPort resourceRepositoryPort) {
        return new ResourceService(
                new CreateResourceUseCaseImpl(resourceRepositoryPort),
                new DeleteResourceUseCaseImpl(resourceRepositoryPort),
                new RetrieveResourceUseCaseImpl(resourceRepositoryPort),
                new UpdateResourceUseCaseImpl(resourceRepositoryPort)
        );
    }

    /**
     * Resource repository bean.
     * <p>
     * Provides access to resource persistence operations.
     * </p>
     *
     * @param jpaResourceRepositoryAdapter the JPA resource adapter
     * @return a ResourceRepositoryPort instance
     */
    @Bean
    public ResourceRepositoryPort resourceRepositoryPort(JpaResourceRepositoryAdapter jpaResourceRepositoryAdapter) {
        return jpaResourceRepositoryAdapter;
    }
}
