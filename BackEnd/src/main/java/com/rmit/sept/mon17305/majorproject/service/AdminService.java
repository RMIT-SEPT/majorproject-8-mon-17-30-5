<<<<<<< HEAD
package com.rmit.sept.mon17305.majorproject.service;

import com.rmit.sept.mon17305.majorproject.model.Admin;
import com.rmit.sept.mon17305.majorproject.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Admin saveOrUpdateAdmin(Admin admin){
        if(admin == null)
        {
            throw new NullPointerException("Empty admin cannot be saved");
        }
        //business logic
        return adminRepository.save(admin);

    }

    public List<Admin> getAdmins(){
        List<Admin> adminList = adminRepository.findAll();
        if(adminList == null)
        {
            throw new NullPointerException("No Admins exist");
        }
        return adminRepository.findAll();

    }

    public Admin getAdminByUsername(String username){
        Admin admin = adminRepository.findByUsername(username);
        if(admin==null){
            throw new NullPointerException("username not found");
        }
        return admin;
    }

    public Optional<Admin> getAdmin(Long id) throws Exception {
    if(id < 1)
    {
        throw new Exception("Id cannot be less than 1");
    }
    Optional<Admin> admin = adminRepository.findById(id);
    if(!admin.isPresent())
    {
        throw new NullPointerException("Admin id not found");
    }
        return adminRepository.findById(id);
    }

//    public Admin getAdminByUsername(String username){
//        Admin admin = adminRepository.findByUsername(username);
//        if(admin == null)
//        {
//            throw new NullPointerException("Admin username not found");
//        }
//
//        return adminRepository.findByUsername(username);
//    }

    public Admin getAdminByUsernameAndPassword(String username, String password){
        Admin admin = adminRepository.findByUsernameAndPassword(username, password);
        if(admin == null)
        {
            throw new NullPointerException("Admin username and password not found");
        }
        return adminRepository.findByUsernameAndPassword(username, password);
    }

    public void deleteAdminById(Long id) throws Exception {
        if(id < 1)
        {
            throw new Exception("Id cannot be less than 1");
        }
        Optional<Admin> admin = adminRepository.findById(id);
        if(!admin.isPresent())
        {
            throw new NullPointerException("Admin cannot be deleted. Id does not exist");
        }
        adminRepository.deleteById(id);
    }

    public Admin getAdminByIdEquals(Long id) throws Exception{
        if(id < 1)
        {
            throw new Exception("Id cannot be less than 1");
        }
        Admin admin = adminRepository.findByIdEquals(id);
        if(admin==null)
        {
            throw new NullPointerException("Admin id not found");
        }
        return adminRepository.findByIdEquals(id);
    }
}
=======
package com.rmit.sept.mon17305.majorproject.service;

import com.rmit.sept.mon17305.majorproject.model.Admin;
import com.rmit.sept.mon17305.majorproject.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Admin saveOrUpdateAdmin(Admin admin){
        if(admin == null)
        {
            throw new NullPointerException("Empty admin cannot be saved");
        }
        //business logic
        return adminRepository.save(admin);

    }

    public List<Admin> getAdmins(){
        List<Admin> adminList = adminRepository.findAll();
        if(adminList == null)
        {
            throw new NullPointerException("No Admins exist");
        }
        return adminRepository.findAll();

    }

    public Admin getAdminByUsername(String username){
        Admin admin = adminRepository.findByUsername(username);
        if(admin==null){
            throw new NullPointerException("username not found");
        }
        return admin;
    }

    public Optional<Admin> getAdmin(Long id) throws Exception {
    if(id < 1)
    {
        throw new Exception("Id cannot be less than 1");
    }
    Optional<Admin> admin = adminRepository.findById(id);
    if(!admin.isPresent())
    {
        throw new NullPointerException("Admin id not found");
    }
        return adminRepository.findById(id);
    }

    public Admin getAdminByUsernameAndPassword(String username, String password){
        Admin admin = adminRepository.findByUsernameAndPassword(username, password);
        if(admin == null)
        {
            throw new NullPointerException("Admin username and password not found");
        }
        return adminRepository.findByUsernameAndPassword(username, password);
    }

    public void deleteAdminById(Long id) throws Exception {
        if(id < 1)
        {
            throw new Exception("Id cannot be less than 1");
        }
        Optional<Admin> admin = adminRepository.findById(id);
        if(!admin.isPresent())
        {
            throw new NullPointerException("Admin cannot be deleted. Id does not exist");
        }
        adminRepository.deleteById(id);
    }

    public Admin getAdminByIdEquals(Long id) throws Exception{
        if(id < 1)
        {
            throw new Exception("Id cannot be less than 1");
        }
        Admin admin = adminRepository.findByIdEquals(id);
        if(admin==null)
        {
            throw new NullPointerException("Admin id not found");
        }
        return adminRepository.findByIdEquals(id);
    }
}
>>>>>>> m3-local
