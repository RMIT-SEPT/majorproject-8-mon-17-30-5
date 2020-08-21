package com.rmit.sept.mon17305.majorproject.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private Long bookingId;
// Small changes to reflect UML and make it more obvious, ID is now generated via the superclass for users

//    private Long id;
// POSTMAN can now post to every object and it comes up in the database. All files for API now created.

    @NotBlank(message = "Customers ID is required")
// Updated the API to work for all object models
    @NotNull(message = "Customers ID is required")
//username get method now returns the object. Setup so we can check a user object and use its data. The idea behind validating the password beginning also

    @NotNull(message = "Customers ID is required")

    private Long customerId;
    @NotNull (message = "Workers ID is required")
    private Long workerId;
    @NotNull (message = "Service ID is required")
    private Long serviceId;
    private String type;
    private Date startTime;
    private Date finishTime;

    public Booking() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Long workerId) {
        this.workerId = workerId;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }
// finish model skeleton

}
