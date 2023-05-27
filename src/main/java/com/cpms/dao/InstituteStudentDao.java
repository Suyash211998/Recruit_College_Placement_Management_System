package com.cpms.dao;

import com.cpms.model.InstituteStudents;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstituteStudentDao extends JpaRepository<InstituteStudents, Integer> {

    public InstituteStudents findByUsername(@Param(value = "username") String username);

    public List<InstituteStudents> findByInstituteName(@Param(value = "instituteName") String instituteName);

}
