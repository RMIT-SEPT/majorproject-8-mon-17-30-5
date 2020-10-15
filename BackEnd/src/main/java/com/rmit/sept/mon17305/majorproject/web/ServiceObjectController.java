package com.rmit.sept.mon17305.majorproject.web;

import com.rmit.sept.mon17305.majorproject.model.ServiceObject;
import com.rmit.sept.mon17305.majorproject.model.ServiceObject;
import com.rmit.sept.mon17305.majorproject.model.ServiceObject;
import com.rmit.sept.mon17305.majorproject.service.ServiceObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/serviceObject")
public class ServiceObjectController {

    @Autowired
    private ServiceObjectService serviceObjectService;

    @PostMapping("")
    public ResponseEntity<?> createNewServiceObject(@RequestBody ServiceObject serviceObject, BindingResult result) throws Exception {

        if (result.hasErrors()){
            for(FieldError error: result.getFieldErrors()) {
                return new ResponseEntity<List<FieldError>>(result.getFieldErrors(), HttpStatus.BAD_REQUEST);
            }
        }

        ServiceObject serviceObject1 = serviceObjectService.saveOrUpdateServiceObject(serviceObject);
        return new ResponseEntity<ServiceObject>(serviceObject, HttpStatus.CREATED);

    }

    @GetMapping("/getAll")
    public List<ServiceObject> getServiceObjects() {

        return serviceObjectService.getServiceObjects();
    }

    @GetMapping("/getAll/{comId}")
    public List<ServiceObject> getServiceObjects(@PathVariable Long comId) throws Exception {

        return serviceObjectService.getServiceObjectsByCompanyId(comId);
    }

    @GetMapping("/{id}/duration")
    public Optional<ServiceObject> getServiceObjectDuration(@PathVariable Long id) {
        return serviceObjectService.getServiceObjectDuration(id);
    }


    @GetMapping("/{id}")
    public Optional<ServiceObject> getServiceObject(@PathVariable Long id) {
        return serviceObjectService.getServiceObject(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> replaceServiceObject(@RequestBody ServiceObject newServiceObject, @PathVariable Long id) {

        serviceObjectService.getServiceObject(id)
                .map(serviceObject -> {
                    serviceObject.setDescription(newServiceObject.getDescription());
                    try {
                        return new ResponseEntity<ServiceObject> (serviceObjectService.saveOrUpdateServiceObject(serviceObject),HttpStatus.ACCEPTED);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return null;
                })
                .orElseGet(() -> {
                    try {
                        ServiceObject serviceObject1 = serviceObjectService.saveOrUpdateServiceObject(newServiceObject);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return new ResponseEntity<ServiceObject>(newServiceObject, HttpStatus.CREATED);
                });

        return new ResponseEntity<String>("Couldn't find ServiceObject", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    void deleteServiceObject(@PathVariable Long id) throws Exception {
        serviceObjectService.deleteServiceObjectById(id);
    }

}
