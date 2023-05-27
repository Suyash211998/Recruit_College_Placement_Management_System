package com.cpms.dao;

import com.cpms.model.InterestedClgs;
import com.cpms.model.JobDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterstedClgsDao extends JpaRepository<InterestedClgs, Integer> {

    public List<InterestedClgs> findByJobId(@Param(value = "jobId") int jobId);
}
