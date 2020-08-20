package com.rmit.sept.mon17305.majorproject.model;

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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String billingAddress;
    private String shippingAddress;

    public Customer() {
        super();
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
