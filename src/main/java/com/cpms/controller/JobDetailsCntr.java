package com.cpms.controller;
import com.cpms.model.JobDetails;
import com.cpms.services.JobDetailsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class JobDetailsCntr {

    @Autowired
    private JobDetailsServices jobDetailsServices;

    @PostMapping(value = {"/recruiter/job"})
    public String createJob(@Valid @RequestBody JobDetails job){
        jobDetailsServices.addJob(job);
        return "success";
    }

    @PutMapping(value = {"/recruiter/job"})
    public String userUpdate(@Valid @RequestBody JobDetails user) {
        jobDetailsServices.modifyJob(user);
        return "success";
    }

    @DeleteMapping(value = {"/recruiter/job/{id}"})
    public String userDelete(@PathVariable int id) {
        JobDetails user = jobDetailsServices.getById(id);
        jobDetailsServices.removeById(id);
        return "success";
    }


    @GetMapping(value = {"/recruiter/job/{id}"})
    public JobDetails userGet(@PathVariable int id) {
        return jobDetailsServices.getById(id);
    }

    @GetMapping(value = {"/recruiter/job/username/{recruiterUsername}"})
    public List<JobDetails> userGetUsername(@PathVariable String recruiterUsername) {
        System.out.println(jobDetailsServices.getByRecruiterUsername(recruiterUsername));
        return jobDetailsServices.getByRecruiterUsername(recruiterUsername);
    }


    @GetMapping(value = {"/recruiter/job"})
    public List<JobDetails> users(){
        return jobDetailsServices.getAllJobs();
    }

}
