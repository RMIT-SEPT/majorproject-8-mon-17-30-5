package com.rmit.sept.mon17305.majorproject.model;

<<<<<<< HEAD
public class Admin extends User {
=======
import javax.persistence.Entity;

@Entity
public class Admin extends User{

    private Long companyId;

   public Admin(){
       super();
   }

    public Long getUserId() {
        return userId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

>>>>>>> 12ba313... finish model skeleton
}
