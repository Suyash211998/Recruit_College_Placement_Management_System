package com.cpms.services;

import com.cpms.model.InstituteStudents;

import java.util.List;

public interface InstituteStudentServices {

    void add(InstituteStudents student);
    void modify(InstituteStudents user);
    void removeById(int id);
    InstituteStudents getById(int id);
    boolean existsById(int id);

    InstituteStudents findUserByUsername(String username);
    List<InstituteStudents> findAllUsers();

    List<InstituteStudents> findAllByInstitute(String instituteName);

}
