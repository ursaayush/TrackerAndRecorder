package com.aayush.trackerandrecorder.domain;

import com.aayush.trackerandrecorder.domain.commons.BaseEntity;
import org.joda.time.DateTime;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
public class TrackerEntry extends BaseEntity{

    private Double value;

    @Temporal(TemporalType.TIMESTAMP)
    private Date time;

    @ManyToOne
    private TrackerType parentTrackerType;

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public TrackerType getParentTrackerType() {
        return parentTrackerType;
    }

    public void setParentTrackerType(TrackerType parentTrackerType) {
        this.parentTrackerType = parentTrackerType;
    }
}
