package com.rmit.sept.mon17305.majorproject.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Admin{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 3, max = 20, message = "username must be within 3 to 20 characters long")
    @NotBlank (message = "Admins username is required")
    private String username;
    @Size(min = 3, max = 20, message = "First Name must be within 3 to 20 characters long")
    @NotBlank (message = "Admins first name is required")
    private String firstName;
    @Size(min = 3, max = 20, message = "Last Name must be within 3 to 20 characters long")
    @NotBlank (message = "Admins last name is required")
    private String lastName;
    @JsonFormat(pattern = "yyy-mm-dd")
    private Date created_At;
    @JsonFormat(pattern = "yyy-mm-dd")
    private Date updated_At;
    @NotNull(message = "Admins company Id is required")
    private Long companyId;

    public Admin(){}

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

    public Long getId() {
        return id;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setUserId(Long userId) {
        this.id = id;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

}
