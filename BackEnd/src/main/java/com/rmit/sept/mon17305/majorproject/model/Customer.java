package com.rmit.sept.mon17305.majorproject.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Customer{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
}
