package com.cpms.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@DynamicInsert
@DynamicUpdate
public class JobDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jobId;

    private int ssc;

    private int hsc;

    private int be;

    private int me;

    private String jobRole;


    private String recruiterUsername;

    @Column(columnDefinition = "LONGTEXT")
    private String jobDetails;

    private String companyName;

    private String branch;

    private String location;

    private String ctc;

    @Column(columnDefinition = "LONGTEXT")
    private String reqSkills;

    private Date postedDate;

    private Date endDate;

    private int vacancy;

    private String selectionProcess;

    private ArrayList<String> interestedClgs;


    @OneToMany(cascade = CascadeType.ALL)
    private List<InstituteUser> appliedColleges;

    @OneToMany(cascade = CascadeType.ALL)
    private List<InstituteStudents> appliedStudents;

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    public String getJobDetails() {
        return jobDetails;
    }

    public void setJobDetails(String jobDetails) {
        this.jobDetails = jobDetails;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }



    public String getCtc() {
        return ctc;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    public void setCtc(String ctc) {
        this.ctc = ctc;
    }

    public String getReqSkills() {
        return reqSkills;
    }

    public void setReqSkills(String reqSkills) {
        this.reqSkills = reqSkills;
    }

    public String getSelectionProcess() {
        return selectionProcess;
    }

    public void setSelectionProcess(String selectionProcess) {
        this.selectionProcess = selectionProcess;
    }

    public List<InstituteUser> getAppliedColleges() {
        return appliedColleges;
    }

    public void setAppliedColleges(List<InstituteUser> appliedColleges) {
        this.appliedColleges = appliedColleges;
    }

    public List<InstituteStudents> getAppliedStudents() {
        return appliedStudents;
    }

    public void setAppliedStudents(List<InstituteStudents> appliedStudents) {
        this.appliedStudents = appliedStudents;
    }



    public int getVacancy() {
        return vacancy;
    }

    public void setVacancy(int vacancy) {
        this.vacancy = vacancy;
    }

    public int getSsc() {
        return ssc;
    }

    public void setSsc(int ssc) {
        this.ssc = ssc;
    }

    public int getHsc() {
        return hsc;
    }

    public void setHsc(int hsc) {
        this.hsc = hsc;
    }

    public int getBe() {
        return be;
    }

    public void setBe(int be) {
        this.be = be;
    }

    public int getMe() {
        return me;
    }

    public void setMe(int me) {
        this.me = me;
    }

    public String getRecruiterUsername() {
        return recruiterUsername;
    }

    public void setRecruiterUsername(String recruiterUsername) {
        this.recruiterUsername = recruiterUsername;
    }

    public ArrayList<String> getInterestedClgs() {
        return interestedClgs;
    }

    public void setInterestedClgs(ArrayList<String> interestedClgs) {
        this.interestedClgs = interestedClgs;
    }
}
