package com.aayush.trackerandrecorder.domain;

import com.aayush.trackerandrecorder.domain.commons.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class TrackerType extends BaseEntity{

    private String name;

    private boolean fixedForDay;

    private String unit;

    private Double defaultIncrement;

    private boolean enabled;

    // TODO : fix this unique constraint
    @Column(unique = true)
    private String accessCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFixedForDay() {
        return fixedForDay;
    }

    public void setFixedForDay(boolean fixedForDay) {
        this.fixedForDay = fixedForDay;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getDefaultIncrement() {
        return defaultIncrement;
    }

    public void setDefaultIncrement(Double defaultIncrement) {
        this.defaultIncrement = defaultIncrement;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(String accessCode) {
        this.accessCode = accessCode;
    }
}
