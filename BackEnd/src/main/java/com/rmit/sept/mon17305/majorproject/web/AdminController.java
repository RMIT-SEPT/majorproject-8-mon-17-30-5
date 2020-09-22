package com.rmit.sept.mon17305.majorproject.web;

import com.rmit.sept.mon17305.majorproject.model.Admin;
import com.rmit.sept.mon17305.majorproject.model.Customer;
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
@CrossOrigin(origins="http://majorproject-sept.s3-website-us-east-1.amazonaws.com")
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
    public ResponseEntity<?> getAdmin(@PathVariable Long id) {
        Optional<Admin> admin = adminService.getAdmin(id);
        if(admin.isPresent()){
            return new ResponseEntity<Optional<Admin>>(admin, HttpStatus.FOUND);

        }else {
            return new ResponseEntity<String>("invalid id", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/username/{username}/password/{password}")
    public Admin getAdminByUsernameAndPassword(@PathVariable String username,@PathVariable String password) {
        Admin admin = adminService.getAdminByUsernameAndPassword(username, password);
        if(admin == null){
            throw new NullPointerException("Wrong user details");
        }
        return admin;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> replaceAdmin(@RequestBody Admin newAdmin, @PathVariable Long id) {

                adminService.getAdmin(id)
                .map(admin -> {
                    admin.setFirstName(newAdmin.getFirstName());
                    admin.setLastName(newAdmin.getFirstName());
                    return new ResponseEntity<Admin> (adminService.saveOrUpdateAdmin(admin),HttpStatus.ACCEPTED);
                })
                .orElseGet(() -> {
                    Admin admin1 = adminService.saveOrUpdateAdmin(newAdmin);
                    return new ResponseEntity<Admin>(newAdmin, HttpStatus.CREATED);
                });

                return new ResponseEntity<String>("Couldn't find Admin", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    void deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdminById(id);
    }
}
