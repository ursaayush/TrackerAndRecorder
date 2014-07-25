package com.aayush.trackerandrecorder.domain;

import com.aayush.trackerandrecorder.domain.commons.BaseEntity;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.Date;

@Entity
public class RecordedMoment extends BaseEntity {

    @Temporal(TemporalType.TIMESTAMP)
    private Date time;

    @Column(columnDefinition = "TEXT")
    private String textContent;

    @ManyToOne
    private RecordedDay parentDay;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public RecordedDay getParentDay() {
        return parentDay;
    }

    public void setParentDay(RecordedDay parentDay) {
        this.parentDay = parentDay;
    }
}
