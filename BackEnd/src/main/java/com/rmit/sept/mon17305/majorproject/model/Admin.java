package com.rmit.sept.mon17305.majorproject.model;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
public class Admin extends User {
=======
import javax.persistence.Entity;
=======
=======
=======
import com.fasterxml.jackson.annotation.JsonFormat;

>>>>>>> cad61ed... API Post with validation, Get all and getbyid added to Admin, needs to cover the rest which i will do tomorrow.
import javax.validation.constraints.NotBlank;
>>>>>>> 1c962aa... Not Blank import added to Admin
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
>>>>>>> dd194b9... POSTMAN can now post to every object and it comes up in the database. All files for API now created.

@Entity
public class Admin{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 3, max = 20, message = "First Name must be within 3 to 20 characters long")
    @NotBlank (message = "Admins first name is required")
    private String firstName;
    @Size(min = 3, max = 20, message = "Last Name must be within 3 to 20 characters long")
    @NotBlank (message = "Admins last name is required")
    private String lastName;
    @JsonFormat(pattern = "yyy-mm-dd")
    private Date created_At;
    @JsonFormat(pattern = "yyy-mm-dd")
    private Date updated_At;
    //@NotBlank(message = "Admins company Id is required")
    //private Long companyId;

    public Admin(){}

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

//    public Long getCompanyId() {
//        return companyId;
//    }

    public void setUserId(Long userId) {
        this.id = id;
    }

//    public void setCompanyId(Long companyId) {
//        this.companyId = companyId;
//    }

>>>>>>> 12ba313... finish model skeleton
}
