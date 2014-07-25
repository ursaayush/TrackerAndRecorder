package com.aayush.trackerandrecorder.repositories;

import com.aayush.trackerandrecorder.domain.TrackerEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackerEntryRepository extends JpaRepository<TrackerEntry,Long>{
}
