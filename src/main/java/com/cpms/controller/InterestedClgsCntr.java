package com.cpms.controller;

import com.cpms.model.InstituteUser;
import com.cpms.model.InterestedClgs;
import com.cpms.model.JobDetails;
import com.cpms.services.InterestedClgsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class InterestedClgsCntr {

    @Autowired
    private InterestedClgsServices interestedClgsServices;

    @Autowired
    private InstituteUserCntr instituteUserCntr;

    @Autowired
    private JobDetailsCntr jobDetailsCntr;

    @PostMapping(value = {"/institute/interestedclgs"})
    public String addClg(@Valid @RequestBody InterestedClgs clg){
        ArrayList<InterestedClgs> list = (ArrayList<InterestedClgs>) getAllJobById(clg.getJobId());
        for(InterestedClgs clg1: list){
           if(clg1.getJobId()==clg.getJobId() && clg1.getInstituteId()==clg.getInstituteId()){
               return "AlreadyExits";
           }
        }
        interestedClgsServices.addClg(clg);

        return "success";
    }

    @PutMapping(value = {"/institute/interestedclgs"})
    public String modifyClg(@Valid @RequestBody InterestedClgs clg){
        interestedClgsServices.addClg(clg);
        return "success";
    }

    @DeleteMapping(value = {"/institute/interestedclgs/{id}"})
    public String deleteClg(@PathVariable int id){
        interestedClgsServices.removeById(id);
        return "success";
    }
    @GetMapping(value = {"/institute/interestedclgs/{id}"})
    public InterestedClgs getClg(@PathVariable int id){
        return interestedClgsServices.getById(id);

    }

    @GetMapping(value = {"/institute/interestedclgs"})
    public List<InterestedClgs> getAllClgs(){
        return interestedClgsServices.getAllClgs();
    }

    @GetMapping(value = {"/institute/interestedclgs/byjobid/{jobid}"})
    public List<InterestedClgs> getAllJobById(@PathVariable int jobid){
        return interestedClgsServices.getAllJobId(jobid);
    }


    @GetMapping(value = {"/institute/interestedclgs/byinstitute/{jobid}"})
    public List<InstituteUser> getAllInstById(@PathVariable int jobid){
        ArrayList<InterestedClgs> allClgs = (ArrayList<InterestedClgs>) interestedClgsServices.getAllJobId(jobid);
        ArrayList<InstituteUser> allInstitute = new ArrayList<>();
        for(InterestedClgs clg : allClgs){
            allInstitute.add(instituteUserCntr.userGet(clg.getInstituteId()));
        }
        System.out.println(allInstitute);
        if(allInstitute == null){
            System.out.println("Null data");
        }
        return allInstitute;
    }

    @GetMapping(value = {"/institute/interestedclgs/showjobtostudents/{clgname}"})
    public List<JobDetails> getAllInstStudById(@PathVariable String clgname){
        ArrayList<InterestedClgs> clgs = (ArrayList<InterestedClgs>) getAllClgs();
        ArrayList<Integer> jobIds = new ArrayList<>();
        int instituteid = instituteUserCntr.getClgname(clgname);
        for(InterestedClgs clg : clgs){
            if(clg.getInstituteId() == instituteid){
                jobIds.add(clg.getJobId());
            }
        }
        ArrayList<JobDetails> allJobs= new ArrayList<>();
        for( int id : jobIds){
            allJobs.add(jobDetailsCntr.userGet(id));
        }
        return allJobs;
    }



}
