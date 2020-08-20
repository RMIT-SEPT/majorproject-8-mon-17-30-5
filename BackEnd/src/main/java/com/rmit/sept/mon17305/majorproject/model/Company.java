package com.rmit.sept.mon17305.majorproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank(message = "Company ID is required")
    private Long id;
    @NotBlank (message = "Company Name")
    private String companyName;

    public Company(){

    }
    public Long getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
