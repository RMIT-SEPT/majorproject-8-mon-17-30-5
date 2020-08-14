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

        //business logic
        return adminRepository.save(admin);

    }

    public List<Admin> getAdmins(){

        return adminRepository.findAll();

    }

    public Optional<Admin> getAdmin(Long id){

        return adminRepository.findById(id);
    }

    public void deleteAdminById(Long id){

        adminRepository.deleteById(id);
    }

}