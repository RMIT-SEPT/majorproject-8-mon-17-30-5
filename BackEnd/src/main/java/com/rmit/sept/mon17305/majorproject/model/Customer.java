package com.rmit.sept.mon17305.majorproject.model;

<<<<<<< HEAD
import javax.persistence.Entity;
<<<<<<< HEAD

<<<<<<< HEAD
@Entity
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
import javax.persistence.*;
import java.util.Date;

@Entity
public class Customer{
>>>>>>> dd194b9... POSTMAN can now post to every object and it comes up in the database. All files for API now created.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private Date created_At;
    private Date updated_At;
    private String billingAddress;
    private String shippingAddress;

    public Customer() {}

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
>>>>>>> f4884a3... Merged with model
}
