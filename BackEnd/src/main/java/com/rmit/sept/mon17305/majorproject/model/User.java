package com.rmit.sept.mon17305.majorproject.model;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    protected String firstName;
    protected String lastName;
    protected Date created_At;
    protected Date updated_At;

    public User() {
    }

    public Long getUserId() {
        return id;
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
    protected void onCreate() {
        this.created_At = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updated_At = new Date();
    }
}
