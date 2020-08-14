package com.rmit.sept.mon17305.majorproject.web;

import com.rmit.sept.mon17305.majorproject.model.ServiceObject;
import com.rmit.sept.mon17305.majorproject.model.ServiceObject;
import com.rmit.sept.mon17305.majorproject.service.ServiceObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/serviceObject")
public class ServiceObjectController {

    @Autowired
    private ServiceObjectService serviceObjectService;

    @PostMapping("")
    public ResponseEntity<ServiceObject> createNewServiceObject(@RequestBody ServiceObject serviceObject){

        ServiceObject serviceObject1 = serviceObjectService.saveOrUpdateServiceObject(serviceObject);
        return new ResponseEntity<ServiceObject>(serviceObject, HttpStatus.CREATED);

    }

    @GetMapping("/")
    public List<ServiceObject> getServiceObjects() {

        return serviceObjectService.getServiceObjects();
    }

    @GetMapping("/{id}")
    public Optional<ServiceObject> getServiceObject(@PathVariable Long id) {
        return serviceObjectService.getServiceObject(id);
    }

}
