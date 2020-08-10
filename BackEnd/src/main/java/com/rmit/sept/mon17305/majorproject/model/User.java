package com.rmit.sept.mon17305.majorproject.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@NotBlank - add dependency
    private String firstName;
    private String lastName;
    private String type;
    private Date created_At;
    private Date updated_At;

    public User(){
    }

    public abstract Long getId();
    public abstract String getFirstName();
    public abstract String getLastName();
    public abstract String getType();
    public abstract Date getCreated_At();
    public abstract Date getUpdated_At();

    public abstract void setId(Long id1);
    public abstract void setFirstName(String fName);
    public abstract void setLastName(String lName);
    public abstract void setType(String type1);
    public abstract void setUpdated_At(Date date1);


    @PrePersist
    protected void onCreate() {
        this.created_At = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updated_At = new Date();
    }
}
