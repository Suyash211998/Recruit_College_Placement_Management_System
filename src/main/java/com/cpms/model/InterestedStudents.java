package com.cpms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.transaction.Transactional;

@Entity
public class InterestedStudents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int interestedStudentId;

    private int jobId;

    private String clgName;

    private int studentId;

    private String status;

    public int getInterestedStudentId() {
        return interestedStudentId;
    }

    public void setInterestedStudentId(int interestedStudentId) {
        this.interestedStudentId = interestedStudentId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getClgName() {
        return clgName;
    }

    public void setClgName(String clgName) {
        this.clgName = clgName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
