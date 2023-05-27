package com.cpms.services;

import com.cpms.model.InterestedClgs;
import com.cpms.model.InterestedStudents;

import java.util.List;

public interface InterestedStudentsServices {

    void addStudent(InterestedStudents std);

    void modifyStd(InterestedStudents std);

    void removeById(int id);

    InterestedStudents getById(int id);

    List<InterestedStudents> getAllStds();

    List<InterestedStudents> getAllJobId(int id);
}
