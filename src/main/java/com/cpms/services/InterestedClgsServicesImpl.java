package com.cpms.services;

import com.cpms.exceptions.ResourceNotFoundException;
import com.cpms.model.InterestedClgs;
import com.cpms.model.JobDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.cpms.dao.InterstedClgsDao;
@Service
public class InterestedClgsServicesImpl implements InterestedClgsServices {

    @Autowired
    private InterstedClgsDao interestedClgs;
    @Override
    public void addClg(InterestedClgs clg) {
        interestedClgs.save(clg);
    }

    @Override
    public void removeById(int id) {
        interestedClgs.deleteById(id);
    }

    @Override
    public InterestedClgs getById(int id) {
        InterestedClgs job = interestedClgs.findById(id).orElseThrow(()-> new ResourceNotFoundException("Job", "id", id));
        return job;
    }

    @Override
    public List<InterestedClgs> getAllClgs() {
        return interestedClgs.findAll();
    }

    @Override
    public List<InterestedClgs> getAllJobId(int id) {
        return interestedClgs.findByJobId(id);
    }

    @Override
    public void modifyClg(InterestedClgs clg) {
        InterestedClgs getClg = interestedClgs.getById(clg.getIntetestedClgId());
        if(clg.getJobId() !=0){getClg.setJobId(clg.getJobId());}
        if(clg.getInstituteId() !=0){getClg.setInstituteId(clg.getInstituteId());}
        if(clg.getStatus() !=null){getClg.setStatus(clg.getStatus());}
        interestedClgs.save(getClg);
    }
}
