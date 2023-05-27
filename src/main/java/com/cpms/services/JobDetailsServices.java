package com.cpms.services;

import com.cpms.model.JobDetails;
import org.springframework.stereotype.Service;

import java.util.List;

public interface JobDetailsServices {

    void addJob(JobDetails job);

    void modifyJob(JobDetails job);

    void removeById(int id);

    JobDetails getById(int id);

    List<JobDetails> getByRecruiterUsername(String recruiterUsername);

    List<JobDetails> getAllJobs();


}
