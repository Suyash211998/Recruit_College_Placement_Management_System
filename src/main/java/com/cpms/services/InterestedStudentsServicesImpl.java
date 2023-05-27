package com.cpms.services;

import com.cpms.dao.InterestedStudentsDao;
import com.cpms.exceptions.ResourceNotFoundException;
import com.cpms.model.InterestedClgs;
import com.cpms.model.InterestedStudents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterestedStudentsServicesImpl implements InterestedStudentsServices{


    @Autowired
    private InterestedStudentsDao interestedStudentsDao;
    @Override
    public void addStudent(InterestedStudents std) {
        interestedStudentsDao.save(std);
    }

    @Override
    public void modifyStd(InterestedStudents std) {
        interestedStudentsDao.save(std);
    }

    @Override
    public void removeById(int id) {
        interestedStudentsDao.deleteById(id);
    }

    @Override
    public InterestedStudents getById(int id) {
        InterestedStudents job = interestedStudentsDao.findById(id).orElseThrow(()-> new ResourceNotFoundException("Job", "id", id));
        return job;
    }

    @Override
    public List<InterestedStudents> getAllStds() {
        return interestedStudentsDao.findAll();
    }

    @Override
    public List<InterestedStudents> getAllJobId(int id) {
        return interestedStudentsDao.findByJobId(id);
    }
}
