package com.aayush.trackerandrecorder.domain.commons;

import com.aayush.trackerandrecorder.domain.User;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public class BaseEntity implements Serializable{

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(nullable = false,name = "linked_user")
    private User linkedUser;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creationTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationTime;

    public BaseEntity() {
    }

    @PrePersist
    void onCreate() {
        this.creationTime = new Date();
    }

    @PreUpdate
    void onPersist() {
        this.modificationTime = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getModificationTime() {
        return modificationTime;
    }

    public void setModificationTime(Date modificationTime) {
        this.modificationTime = modificationTime;
    }

    public User getLinkedUser() {
        return linkedUser;
    }

    public void setLinkedUser(User linkedUser) {
        this.linkedUser = linkedUser;
    }
}
