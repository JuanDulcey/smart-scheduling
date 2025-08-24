package com.devv.smartSheduling.domain.model;

import java.util.Map;
import java.util.UUID;

public class SpecialistPolicy {

    private UUID id;
    private Specialist specialist;
    private Integer minDuration;
    private Integer bufferTime;
    private Integer maxDaily;
    private Map<String, Object> rules;

    // Constructor completo
    public SpecialistPolicy(UUID id, Specialist specialist, Integer minDuration, Integer bufferTime, Integer maxDaily, Map<String, Object> rules) {
        this.id = id;
        this.specialist = specialist;
        this.minDuration = minDuration;
        this.bufferTime = bufferTime != null ? bufferTime : 0; // default 0
        this.maxDaily = maxDaily != null ? maxDaily : 10;      // default 10
        this.rules = rules;
    }

    // Constructor sin ID (para creación de nuevas entidades)
    public SpecialistPolicy(Specialist specialist, Integer minDuration, Integer bufferTime, Integer maxDaily, Map<String, Object> rules) {
        this(null, specialist, minDuration, bufferTime, maxDaily, rules);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Specialist getSpecialist() {
        return specialist;
    }

    public void setSpecialist(Specialist specialist) {
        this.specialist = specialist;
    }

    public Integer getMinDuration() {
        return minDuration;
    }

    public void setMinDuration(Integer minDuration) {
        this.minDuration = minDuration;
    }

    public Integer getBufferTime() {
        return bufferTime;
    }

    public void setBufferTime(Integer bufferTime) {
        this.bufferTime = bufferTime;
    }

    public Integer getMaxDaily() {
        return maxDaily;
    }

    public void setMaxDaily(Integer maxDaily) {
        this.maxDaily = maxDaily;
    }

    public Map<String, Object> getRules() {
        return rules;
    }

    public void setRules(Map<String, Object> rules) {
        this.rules = rules;
    }
}
