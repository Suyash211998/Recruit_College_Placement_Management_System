package com.cpms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InterestedClgs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int intetestedClgId;
    private int jobId;

    private int instituteId;

    private String status;

    public int getIntetestedClgId() {
        return intetestedClgId;
    }

    public void setIntetestedClgId(int intetestedClgId) {
        this.intetestedClgId = intetestedClgId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getInstituteId() {
        return instituteId;
    }

    public void setInstituteId(int instituteId) {
        this.instituteId = instituteId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
