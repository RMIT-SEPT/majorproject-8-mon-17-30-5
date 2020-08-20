package com.rmit.sept.mon17305.majorproject.model;

import javax.persistence.*;

public abstract class User {
<<<<<<< HEAD
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
<<<<<<< HEAD
=======
=======

>>>>>>> 12ba313... finish model skeleton
    //@NotBlank - add dependency
    protected String firstName;
    protected String lastName;
    protected String type;
    protected Date created_At;
    protected Date updated_At;

    public User() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getType() {
        return type;
    }

    public Date getCreated_At() {
        return created_At;
    }

    public Date getUpdated_At() {
        return updated_At;
    }

    public void setFirstName(String fName) {
        this.firstName = fName;
    }

    public void setLastName(String lName) {
        this.lastName = lName;
    }

    public void setType(String type1) {
        this.type = type1;
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
>>>>>>> f4884a3... Merged with model
}
