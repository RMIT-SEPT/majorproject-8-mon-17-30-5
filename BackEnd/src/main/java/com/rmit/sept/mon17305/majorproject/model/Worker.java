package com.rmit.sept.mon17305.majorproject.model;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.*;
//POSTMAN can now post to every object and it comes up in the database. All files for API now created.

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
//Updated the API to work for all object models

import java.util.Date;
import java.util.List;

@Entity
public class Worker{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 3, max = 20, message = "username must be within 3 to 20 characters long")
    @NotBlank (message = "Workers username is required")
    private String username;
    @Size(min = 3, max = 20, message = "First Name must be within 3 to 20 characters long")
    @NotBlank(message = "Workers first name is required")
    private String firstName;
    @Size(min = 3, max = 20, message = "Last Name must be within 3 to 20 characters long")
    @NotBlank (message = "Workers last name is required")
    private String lastName;
    @JsonFormat(pattern = "yyy-mm-dd")
    private Date created_At;
    @JsonFormat(pattern = "yyy-mm-dd")
    private Date updated_At;
    private Long companyId;
    private Long serviceId;
    private Date startTime;
    private Date finishTime;
    private String workingDays;

    public Worker(){}

    public Long getUserId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getCreated_At() {
        return created_At;
    }

    public Date getUpdated_At() {
        return updated_At;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstName(String fName) {
        this.firstName = fName;
    }

    public void setLastName(String lName) {
        this.lastName = lName;
    }

    public void setUpdated_At(Date date1) {
        this.updated_At = date1;
    }

    @PrePersist
    private void onCreate() {
        this.created_At = new Date();
    }

    @PreUpdate
    private void onUpdate() {
        this.updated_At = new Date();
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getId() {
        return id;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public String getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(String workingDays) {
        this.workingDays = workingDays;
    }
//finish model skeleton

}
