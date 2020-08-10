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
    private String lastNAme;
    private Date created_At;
    private Date updated_At;

    public User(){
    }

    public abstract Long getId();





    @PrePersist
    protected void onCreate() {
        this.created_At = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updated_At = new Date();
    }
}
