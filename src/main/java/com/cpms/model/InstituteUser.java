package com.cpms.model;


import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.sql.Date;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@DynamicInsert
@DynamicUpdate
public class InstituteUser{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int instituteId;

    private int clgUid;
    @NotEmpty(message = "Clg Name required")
    private String clgName;
    @NotEmpty(message = "UserName required")
    private String username;

    @NotEmpty(message = "Password Required")
    private String password;
    private String clgPan;
    private String placementOfficer;
    @Email(message = "Email address is not valid!!")
    private String email;
    private Date regDate;

    private String phone;


    public int getClgUid() {
        return clgUid;
    }


    public void setClgUid(int clgUid) {
        this.clgUid = clgUid;
    }

    public String getClgName() {
        return clgName;
    }

    public void setClgName(String clgName) {
        this.clgName = clgName;
    }

    public String getClgPan() {
        return clgPan;
    }

    public void setClgPan(String clgPan) {
        this.clgPan = clgPan;
    }

    public String getPlacementOfficer() {
        return placementOfficer;
    }

    public void setPlacementOfficer(String placementOfficer) {
        this.placementOfficer = placementOfficer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public int getInstituteId() {
        return instituteId;
    }

    public void setInstituteId(int instituteId) {
        this.instituteId = instituteId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
