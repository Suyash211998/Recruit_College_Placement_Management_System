package com.cpms.controller;


import com.cpms.model.InstituteStudents;

import com.cpms.model.InterestedStudents;
import com.cpms.services.InterestedStudentsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class InterestedStudentsCntr {

    @Autowired
    private InterestedStudentsServices interestedStudentsServices;

    @Autowired
    private InstituteStudentCntr instituteStudentCntr;

    @PostMapping(value = {"/student/interestedstudents"})
    public String addStd1(@Valid @RequestBody InterestedStudents std){
        ArrayList<InterestedStudents> list = (ArrayList<InterestedStudents>) getAllJobById(std.getJobId());
        for(InterestedStudents clg1: list){
            if(clg1.getJobId()==std.getJobId() && clg1.getStudentId()==std.getStudentId()){
                return "AlreadyExits";
            }
        }
        interestedStudentsServices.addStudent(std);

        return "success";
    }

    @PutMapping(value = {"/student/interestedstudents"})
    public String putStd(@Valid @RequestBody InterestedStudents std){
        interestedStudentsServices.modifyStd(std);
        return "success";
    }

    @DeleteMapping(value = {"/student/interestedstudents/{id}"})
    public String deleteStd(@PathVariable int id){
        interestedStudentsServices.removeById(id);
        return "success";
    }

    @GetMapping(value = {"/student/interestedstudents/{id}"})
    public String getStd(@PathVariable int id){
        interestedStudentsServices.getById(id);
        return "success";
    }

    @GetMapping(value = {"/student/interestedstudents"})
    public List<InterestedStudents> getStdAll(){
        return interestedStudentsServices.getAllStds();

    }

    @GetMapping(value = {"/student/interestedstudents/byjobid/{jobid}"})
    public List<InterestedStudents> getAllJobById(@PathVariable int jobid){
        return interestedStudentsServices.getAllJobId(jobid);
    }

    @GetMapping(value = {"/student/interestedstudents/bystudent/{jobid}"})
    public List<InstituteStudents> getAllInstById(@PathVariable int jobid){
        ArrayList<InterestedStudents> allStds = (ArrayList<InterestedStudents>) interestedStudentsServices.getAllJobId(jobid);
        ArrayList<InstituteStudents> allInstituteStudents = new ArrayList<>();
        for(InterestedStudents std : allStds){
            allInstituteStudents.add(instituteStudentCntr.studentById(std.getStudentId()));
        }
        System.out.println(allInstituteStudents);
        return allInstituteStudents;
    }

    @GetMapping(value = {"/student/interestedstudents/byInstitiutestudent/{jobid}/{institutename}"})
    public List<InstituteStudents> getAllStudentByInstId(@PathVariable int jobid, @PathVariable String institutename){
        ArrayList<InstituteStudents> getAllStd = (ArrayList<InstituteStudents>) getAllInstById(jobid);
        ArrayList<InstituteStudents> allInstituteStudents = new ArrayList<>();
        for(InstituteStudents std : getAllStd){
            if(std.getInstituteName().equals(institutename)) allInstituteStudents.add(std);
        }
        System.out.println(allInstituteStudents);
        return allInstituteStudents;
    }


}
