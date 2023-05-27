package com.cpms.services;

import com.cpms.dao.InstituteStudentDao;
import com.cpms.exceptions.ResourceNotFoundException;
import com.cpms.model.InstituteStudents;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstituteStudentServicesImpl implements InstituteStudentServices {

    @Autowired
    private InstituteStudentDao studentDao;
    @Override
    public void add(InstituteStudents student) {
        String encPassword = hashPassword(student.getPassword());
        student.setPassword(encPassword);
        studentDao.save(student);
    }

    public String hashPassword(String plainTextPassword){
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }
    @Override
    public void modify(InstituteStudents user) {
        InstituteStudents student = studentDao.getById(user.getStudentId());
//        if(user.getEmail() !=null){student.setEmail(user.getEmail());}
//        if(user.getName() !=null){student.setName(user.getName());}
//        if(user.getPhone() !=null){student.setPhone(user.getPhone());}
//        if(user.getLocation() !=null){student.setLocation(user.getLocation());}
//        if(user.getBirthDate() !=null){student.setBirthDate(user.getBirthDate());}
//
//        if(user.getInstituteName() !=null){student.setInstituteName(user.getInstituteName());}
//        if(user.getSkills() !=null){student.setSkills(user.getSkills());}
//        if(user.getExtraActivities() !=null){student.setExtraActivities(user.getExtraActivities());}
//        if(user.getUsername() !=null){user.setUsername(student.getUsername());}
//        if(user.getPassword() !=null){user.setPassword(student.getPassword());}

        studentDao.save(user);

    }

    @Override
    public void removeById(int id) {
        studentDao.deleteById(id);
    }

    @Override
    public InstituteStudents getById(int id) {
        InstituteStudents opt = studentDao.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "id", id));
        return opt;
    }

    @Override
    public boolean existsById(int id) {
        return studentDao.existsById(id);
    }

    @Override
    public InstituteStudents findUserByUsername(String username) throws ResourceNotFoundException {

        InstituteStudents student = studentDao.findByUsername(username);
        return student;
    }

    @Override
    public List<InstituteStudents> findAllUsers() {
        return studentDao.findAll();
    }

    @Override
    public List<InstituteStudents> findAllByInstitute(String instituteName) {
        return studentDao.findByInstituteName(instituteName);
    }
}
