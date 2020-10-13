package com.rmit.sept.mon17305.majorproject.model;

import org.aspectj.weaver.ast.Not;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonFormat;


//API Post with validation, Get all and getbyid added to Admin, needs to cover the rest which i will do tomorrow.
import javax.validation.constraints.NotBlank;
// Not Blank import added to Admin

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

// POSTMAN can now post to every object and it comes up in the database. All files for API now created.
//API Post with validation, Get all and getbyid added to Admin, needs to cover the rest which i will do tomorrow.
//Not Blank import added to Admin
//POSTMAN can now post to every object and it comes up in the database. All files for API now created.
@Entity
public class Admin{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 3, max = 20, message = "username must be within 3 to 20 characters long")
    @NotBlank (message = "Admins username is required")
    private String username;
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
    @NotNull(message = "Admins company Id is required")
    private Long companyId;
    private String password;
    private String phone;

    public Admin(){onCreate();}

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

    public Long getCompanyId() {
        return companyId;
    }

    public void setUserId(Long userId) {
        this.id = id;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
    public String getType(){
        return "Admin";
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String toString(){

        String createAt = formatDate(this.created_At.toString());
        StringBuilder str = new StringBuilder();
        str.append("{\"id\":"+this.id);
        str.append(",\"username\":"+"\""+this.username+"\"");
        str.append(",\"firstName\":"+"\""+this.firstName+"\"");
        str.append(",\"lastName\":"+"\""+this.lastName+"\"");
        str.append(",\"created_At\":"+"\""+createAt+"\"");
        str.append(",\"updated_At\":"+this.updated_At);
        str.append(",\"companyId\":"+this.companyId);
        str.append(",\"password\":"+"\""+this.password+"\"");
        str.append(",\"phone\":"+"\"" + this.phone+"\"");
        str.append(",\"type\":"+"\""+getType()+"\"");
        str.append(",\"userId\":" + this.id+"}");
        return str.toString();
    }

    public String formatDate(String today){
        String ret = "";
        String year = today.substring(25);
        String mon = today.substring(4,7);
        String date = today.substring(8,10);
        ret = year+"-"+getMonth(mon)+"-"+date;
        return ret;
    }

    public String getMonth(String str){
        String ret = "";
        if(str.equals("Jan")){
            ret =  "01";
        }else if(str.equals("Feb")){
            ret =  "02";
        }else if(str.equals("Mar")){
            ret =  "03";
        }else if(str.equals("Apr")){
            ret =  "04";
        }else if(str.equals("May")){
            ret = "05";
        }else if(str.equals("Jun")){
            ret = "06";
        }else if(str.equals("Jul")){
            ret = "07";
        }else if(str.equals("Aug")){
            ret = "08";
        }else if(str.equals("Sep")){
            ret =  "09";
        }else if(str.equals("Oct")){
            ret = "10";
        }else if(str.equals("Nov")){
            ret = "11";
        }else if(str.equals("Dec")){
            ret = "12";
        }

        return ret;
    }
}
