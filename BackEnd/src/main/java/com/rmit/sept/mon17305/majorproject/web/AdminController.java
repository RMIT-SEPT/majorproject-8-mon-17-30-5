package com.rmit.sept.mon17305.majorproject.web;

import com.rmit.sept.mon17305.majorproject.model.Admin;
import com.rmit.sept.mon17305.majorproject.repository.AdminRepository;
import com.rmit.sept.mon17305.majorproject.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("")
    public ResponseEntity<?> createNewAdmin(@Valid @RequestBody Admin admin, BindingResult result){

        if (result.hasErrors()){
            for(FieldError error: result.getFieldErrors()) {
                return new ResponseEntity<List<FieldError>>(result.getFieldErrors(), HttpStatus.BAD_REQUEST);
            }
        }

        Admin admin1 = adminService.saveOrUpdateAdmin(admin);
        return new ResponseEntity<Admin>(admin, HttpStatus.CREATED);

    }

    @GetMapping("/")
    public List<Admin> getAdmins() {

        return adminService.getAdmins();
    }

    @GetMapping("/{id}")
    public Optional<Admin> getAdmin(@PathVariable Long id) {
        return adminService.getAdmin(id);
    }


}
