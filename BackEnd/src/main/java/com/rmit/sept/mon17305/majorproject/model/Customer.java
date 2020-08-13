package com.rmit.sept.mon17305.majorproject.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Customer extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@NotBlank - add dependency
    private String firstName;
    private String lastName;
    private String type;
    private Date created_At;
    private Date updated_At;

    public Customer() {
        super();
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public Date getCreated_At() {
        return created_At;
    }

    @Override
    public Date getUpdated_At() {
        return updated_At;
    }

    @Override
    public void setId(Long id1) {
        this.id = id1;
    }

    @Override
    public void setFirstName(String fName) {
        this.firstName = fName;
    }

    @Override
    public void setLastName(String lName) {
        this.lastName = lName;
    }

    @Override
    public void setType(String type1) {
        this.type = type1;
    }

    @Override
    public void setUpdated_At(Date date1) {
        this.updated_At = date1;
    }
}
