package com.aayush.trackerandrecorder.domain;

import com.aayush.trackerandrecorder.domain.commons.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class OutgoingChatMessage extends BaseEntity{

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;
}
