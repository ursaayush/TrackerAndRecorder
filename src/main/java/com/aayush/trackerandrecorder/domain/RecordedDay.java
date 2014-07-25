package com.aayush.trackerandrecorder.domain;

import com.aayush.trackerandrecorder.domain.commons.BaseEntity;
import org.joda.time.DateTime;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
public class RecordedDay extends BaseEntity {

    private String title;

    @Temporal(TemporalType.DATE)
    private Date time;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
