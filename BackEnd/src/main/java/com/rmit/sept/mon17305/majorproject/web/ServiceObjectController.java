package com.rmit.sept.mon17305.majorproject.web;

import com.rmit.sept.mon17305.majorproject.model.ServiceObject;
import com.rmit.sept.mon17305.majorproject.service.ServiceObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
