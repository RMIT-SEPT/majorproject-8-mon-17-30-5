package com.rmit.sept.mon17305.majorproject.service;

import com.rmit.sept.mon17305.majorproject.model.ServiceObject;
import com.rmit.sept.mon17305.majorproject.repository.ServiceObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceObjectService {

    @Autowired
    private ServiceObjectRepository serviceObjectRepository;

    public ServiceObject saveOrUpdateServiceObject(ServiceObject serviceObject){

        //business logic
        return serviceObjectRepository.save(serviceObject);

    }

}