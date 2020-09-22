
package com.rmit.sept.mon17305.majorproject.model;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank (message = "Customers username is required")
    @Size(min = 3, max = 20, message = "username must be within 3 to 20 characters long")
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
    private String password;

    public Customer() {onCreate();}

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

    public String getType(){
        return "Customer";
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toStringJSON(){

        String createAt = formatDate(this.created_At.toString());
        StringBuilder str = new StringBuilder();
        str.append("{\"id\":"+this.id);
        str.append(",\"username\":"+"\""+this.username+"\"");
        str.append(",\"firstName\":"+"\""+this.firstName+"\"");
        str.append(",\"lastName\":"+"\""+this.lastName+"\"");
        str.append(",\"created_At\":"+"\""+createAt+"\"");
        str.append(",\"updated_At\":"+this.updated_At);
 
        str.append(",\"billingAddress\":"+"\""+this.billingAddress+"\"");
        str.append(",\"shippingAddress\":"+"\""+this.shippingAddress+"\"");
        str.append(",\"password\":"+"\""+this.password+"\"");

        str.append(",\"type\":"+"\""+getType()+"\"");
        str.append(",\"userId\":" + this.id+"}");
        return str.toString();
    }

    public String formatDate(String today){
        String year = today.substring(25);
        String str = today.substring(14,16);
        String date = today.substring(8,10);
        int offsetDate = Integer.parseInt(date)-1;
        String createAt = year+"-"+str+"-"+offsetDate;
        return createAt;
    }
}
