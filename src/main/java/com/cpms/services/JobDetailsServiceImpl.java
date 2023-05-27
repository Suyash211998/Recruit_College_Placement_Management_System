package com.cpms.services;

import com.cpms.dao.JobDetailsUserDao;
import com.cpms.exceptions.ResourceNotFoundException;
import com.cpms.model.InstituteStudents;
import com.cpms.model.JobDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobDetailsServiceImpl implements JobDetailsServices{

    @Autowired
    private JobDetailsUserDao jobDetailsUserDao;


    @Override
    public void addJob(JobDetails job) {
        jobDetailsUserDao.save(job);
    }

    @Override
    public void modifyJob(JobDetails user) {
        JobDetails job = jobDetailsUserDao.getById(user.getJobId());
        if(user.getJobDetails() !=null){user.setJobDetails(job.getJobDetails());}
        if(user.getSsc() !=0){user.setSsc(job.getSsc());}
        if(user.getHsc() !=0){user.setHsc(job.getHsc());}
        if(user.getBe() !=0){user.setBe(job.getBe());}
        if(user.getJobRole() !=null){user.setJobRole(job.getJobRole());}
        if(user.getLocation() !=null){user.setLocation(job.getLocation());}
        if(user.getCtc() !=null){user.setCtc(job.getCtc());}
        if(user.getReqSkills() !=null){user.setReqSkills(job.getReqSkills());}
        if(user.getVacancy() !=0){user.setVacancy(job.getVacancy());}
        if(user.getSelectionProcess() !=null){user.setSelectionProcess(job.getSelectionProcess());}
        if(user.getInterestedClgs() !=null){user.setInterestedClgs(job.getInterestedClgs());}
        if(user.getAppliedColleges() !=null){user.setAppliedColleges(job.getAppliedColleges());}
        if(user.getAppliedStudents() !=null){user.setAppliedStudents(job.getAppliedStudents());}
        jobDetailsUserDao.save(job);
    }


    @Override
    public void removeById(int id) {
        jobDetailsUserDao.deleteById(id);
    }

    @Override
    public JobDetails getById(int id) {
        JobDetails job = jobDetailsUserDao.findById(id).orElseThrow(()-> new ResourceNotFoundException("Job", "id", id));
        return job;
    }

    @Override
    public List<JobDetails> getAllJobs() {
        return jobDetailsUserDao.findAll();
    }

    @Override
    public List<JobDetails> getByRecruiterUsername(String recruiterUsername) {
        return jobDetailsUserDao.findByRecruiterUsername(recruiterUsername);
    }
}
