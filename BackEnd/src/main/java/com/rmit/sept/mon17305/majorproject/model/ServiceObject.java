package com.rmit.sept.mon17305.majorproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
public class ServiceObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Service Description is required")
    private String description;
//    private Long workerId;
//    private String workerName;
    @Min(1)
    private Long companyId;
    @Min(0)
    @Max(12)
    private int duration;

    public ServiceObject(){}

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public Long getWorkerId() {
//        return workerId;
//    }
//
//    public void setWorkerId(Long workerId) {
//        this.workerId = workerId;
//    }
//
//    public String getWorkerName() {
//        return workerName;
//    }
//
//    public void setWorkerName(String workerName) {
//        this.workerName = workerName;
//    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
}
