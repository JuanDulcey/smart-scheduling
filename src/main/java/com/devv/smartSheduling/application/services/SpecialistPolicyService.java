package com.devv.smartSheduling.application.services;

import com.devv.smartSheduling.domain.model.SpecialistPolicy;
import com.devv.smartSheduling.domain.ports.in.specialistpolicy.CreateSpecialistPolicyUseCase;
import com.devv.smartSheduling.domain.ports.in.specialistpolicy.DeleteSpecialistPolicyUseCase;
import com.devv.smartSheduling.domain.ports.in.specialistpolicy.RetrieveSpecialistPolicyUseCase;
import com.devv.smartSheduling.domain.ports.in.specialistpolicy.UpdateSpecialistPolicyUseCase;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Service class that manages the operations for {@link SpecialistPolicy}.
 * <p>
 * This class connects the use cases for creating, updating,
 * retrieving and deleting specialist policies.
 * </p>
 */
public class SpecialistPolicyService implements
        CreateSpecialistPolicyUseCase,
        DeleteSpecialistPolicyUseCase,
        RetrieveSpecialistPolicyUseCase,
        UpdateSpecialistPolicyUseCase{

    private final CreateSpecialistPolicyUseCase createSpecialistPolicyUseCase;
    private final DeleteSpecialistPolicyUseCase deleteSpecialistPolicyUseCase;
    private final RetrieveSpecialistPolicyUseCase retrieveSpecialistPolicyUseCase;
    private final UpdateSpecialistPolicyUseCase updateSpecialistPolicyUseCase;

    /**
     * Constructor for {@code SpecialistPolicyService}.
     *
     * @param createSpecialistPolicyUseCase   use case for creating a policy
     * @param deleteSpecialistPolicyUseCase   use case for deleting a policy
     * @param retrieveSpecialistPolicyUseCase use case for getting policies
     * @param updateSpecialistPolicyUseCase   use case for updating a policy
     */
    public SpecialistPolicyService(CreateSpecialistPolicyUseCase createSpecialistPolicyUseCase, DeleteSpecialistPolicyUseCase deleteSpecialistPolicyUseCase, RetrieveSpecialistPolicyUseCase retrieveSpecialistPolicyUseCase, UpdateSpecialistPolicyUseCase updateSpecialistPolicyUseCase) {
        this.createSpecialistPolicyUseCase = createSpecialistPolicyUseCase;
        this.deleteSpecialistPolicyUseCase = deleteSpecialistPolicyUseCase;
        this.retrieveSpecialistPolicyUseCase = retrieveSpecialistPolicyUseCase;
        this.updateSpecialistPolicyUseCase = updateSpecialistPolicyUseCase;
    }

    /**
     * Create a new {@link SpecialistPolicy}.
     *
     * @param specialistPolicy the policy to create
     * @return the created {@link SpecialistPolicy}
     */
    @Override
    public SpecialistPolicy createSpecialistPolicy(SpecialistPolicy specialistPolicy) {
        return createSpecialistPolicyUseCase.createSpecialistPolicy(specialistPolicy);
    }

    /**
     * Delete a {@link SpecialistPolicy} by its ID.
     *
     * @param id the ID of the policy
     * @return {@code true} if deleted, {@code false} if not found
     */
    @Override
    public boolean deleteSpecialistPolicy(UUID id) {
        return deleteSpecialistPolicyUseCase.deleteSpecialistPolicy(id);
    }

    /**
     * Get one {@link SpecialistPolicy} by ID.
     *
     * @param id the ID of the policy
     * @return an {@link Optional} with the policy if found
     */
    @Override
    public Optional<SpecialistPolicy> getSpecialistPolicy(UUID id) {
        return retrieveSpecialistPolicyUseCase.getSpecialistPolicy(id);
    }

    /**
     * Get all {@link SpecialistPolicy} records.
     *
     * @return a list of all specialist policies
     */
    @Override
    public List<SpecialistPolicy> getAllSpecialistPolicies() {
        return retrieveSpecialistPolicyUseCase.getAllSpecialistPolicies();
    }

    /**
     * Update an existing {@link SpecialistPolicy}.
     *
     * @param id          the ID of the policy to update
     * @param updatedData new data for the policy
     * @return an {@link Optional} with the updated policy if successful
     */
    @Override
    public Optional<SpecialistPolicy> updateSpecialistPolicy(UUID id, SpecialistPolicy updatedData) {
        return updateSpecialistPolicyUseCase.updateSpecialistPolicy(id, updatedData);
    }
}
