package com.devv.smartSheduling.domain.model;

import java.util.Map;
import java.util.UUID;

/**
 * Represents a policy that defines the working rules for a specialist.
 * <p>
 * This policy includes limits like minimum duration, buffer time between
 * appointments, and maximum daily appointments.
 * </p>
 */
public class SpecialistPolicy {

    /** Unique ID of the policy. */
    private UUID id;

    /** The specialist that this policy belongs to. */
    private Specialist specialist;

    /** Minimum duration (in minutes) of each appointment. */
    private Integer minDuration;

    /** Waiting time (in minutes) between two appointments. */
    private Integer bufferTime;

    /** Maximum number of appointments allowed per day. */
    private Integer maxDaily;

    /** Extra rules stored as key-value pairs. */
    private Map<String, Object> rules;

    /**
     * Empty constructor.
     * <p>
     * Used when creating an empty policy object.
     * </p>
     */
    public SpecialistPolicy() {}

    /**
     * Full constructor to create a policy with all fields.
     *
     * @param id          unique ID of the policy
     * @param specialist  specialist linked to this policy
     * @param minDuration minimum time of one appointment (in minutes)
     * @param bufferTime  waiting time between appointments
     * @param maxDaily    max number of appointments per day
     * @param rules       extra policy rules as key-value pairs
     */
    public SpecialistPolicy(UUID id, Specialist specialist, Integer minDuration, Integer bufferTime, Integer maxDaily, Map<String, Object> rules) {
        this.id = id;
        this.specialist = specialist;
        this.minDuration = minDuration;
        this.bufferTime = bufferTime != null ? bufferTime : 0; // default 0
        this.maxDaily = maxDaily != null ? maxDaily : 10;      // default 10
        this.rules = rules;
    }

    /**
     * Constructor without ID, used for creating new entities.
     *
     * @param specialist  specialist linked to this policy
     * @param minDuration minimum time of one appointment
     * @param bufferTime  waiting time between appointments
     * @param maxDaily    max number of appointments per day
     * @param rules       extra policy rules
     */
    public SpecialistPolicy(Specialist specialist, Integer minDuration, Integer bufferTime, Integer maxDaily, Map<String, Object> rules) {
        this(null, specialist, minDuration, bufferTime, maxDaily, rules);
    }

    /** @return the unique ID of the policy */
    public UUID getId() {
        return id;
    }

    /** @param id sets the unique ID of the policy */
    public void setId(UUID id) {
        this.id = id;
    }

    /** @return the specialist linked to this policy */
    public Specialist getSpecialist() {
        return specialist;
    }

    /** @param specialist sets the specialist linked to this policy */
    public void setSpecialist(Specialist specialist) {
        this.specialist = specialist;
    }

    /** @return the minimum duration of one appointment */
    public Integer getMinDuration() {
        return minDuration;
    }

    /** @param minDuration sets the minimum duration of one appointment */
    public void setMinDuration(Integer minDuration) {
        this.minDuration = minDuration;
    }

    /** @return the waiting time between appointments */
    public Integer getBufferTime() {
        return bufferTime;
    }

    /** @param bufferTime sets the waiting time between appointments */
    public void setBufferTime(Integer bufferTime) {
        this.bufferTime = bufferTime;
    }

    /** @return the maximum number of appointments per day */
    public Integer getMaxDaily() {
        return maxDaily;
    }

    /** @param maxDaily sets the maximum number of appointments per day */
    public void setMaxDaily(Integer maxDaily) {
        this.maxDaily = maxDaily;
    }

    /** @return the extra rules of the policy */
    public Map<String, Object> getRules() {
        return rules;
    }

    /** @param rules sets the extra rules of the policy */
    public void setRules(Map<String, Object> rules) {
        this.rules = rules;
    }
}
