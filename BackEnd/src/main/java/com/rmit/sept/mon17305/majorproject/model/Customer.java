package com.rmit.sept.mon17305.majorproject.model;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import javax.persistence.Entity;
<<<<<<< HEAD
=======
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
>>>>>>> 031b9db80e8f95dfe51c7badc0c72b44d6795474

<<<<<<< HEAD
@Entity
<<<<<<< HEAD
public class Customer extends User{
=======
=======
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
>>>>>>> 12ba313... finish model skeleton
public class Customer extends User {
=======
=======
import com.fasterxml.jackson.annotation.JsonFormat;

>>>>>>> 2377f3a... Updated the API to work for all object models
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Customer{
>>>>>>> dd194b9... POSTMAN can now post to every object and it comes up in the database. All files for API now created.
=======
public class Customer{
>>>>>>> 031b9db80e8f95dfe51c7badc0c72b44d6795474

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 3, max = 20, message = "username must be within 3 to 20 characters long")
    @NotBlank (message = "Customers username is required")
    private String username;
    @Size(min = 3, max = 20, message = "First Name must be within 3 to 20 characters long")
    @NotBlank(message = "Customers first name is required")
    private String firstName;
    @Size(min = 3, max = 20, message = "Last Name must be within 3 to 20 characters long")
    @NotBlank (message = "Customers name is required")
    private String lastName;
    @JsonFormat(pattern = "yyy-mm-dd")
    private Date created_At;
    @JsonFormat(pattern = "yyy-mm-dd")
    private Date updated_At;
    private String billingAddress;
    private String shippingAddress;

    public Customer() {}

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

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
<<<<<<< HEAD
>>>>>>> f4884a3... Merged with model
=======
>>>>>>> 031b9db80e8f95dfe51c7badc0c72b44d6795474
}
