package com.cpms.dao;

import com.cpms.model.JobDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface JobDetailsUserDao extends JpaRepository<JobDetails, Integer> {

    public List<JobDetails> findByRecruiterUsername(@Param(value = "recruiterUsername") String recruiterUsername);



}
