package com.cpms.dao;

import com.cpms.model.InterestedClgs;
import com.cpms.model.InterestedStudents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface InterestedStudentsDao extends JpaRepository<InterestedStudents, Integer> {

    public List<InterestedStudents> findByJobId(@Param(value = "jobId") int jobId);
}
