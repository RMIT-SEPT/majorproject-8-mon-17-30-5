package com.rmit.sept.mon17305.majorproject.service;

import com.rmit.sept.mon17305.majorproject.model.ServiceObject;
import com.rmit.sept.mon17305.majorproject.model.ServiceObject;
import com.rmit.sept.mon17305.majorproject.repository.ServiceObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceObjectService {

    @Autowired
    private ServiceObjectRepository serviceObjectRepository;

    public ServiceObject saveOrUpdateServiceObject(ServiceObject serviceObject){

        //business logic
        return serviceObjectRepository.save(serviceObject);

    }

    public List<ServiceObject> getServiceObjects(){

        return serviceObjectRepository.findAll();

    }

    public Optional<ServiceObject> getServiceObject(Long id){

        return serviceObjectRepository.findById(id);
    }

    public void deleteServiceObjectById(Long id){

        serviceObjectRepository.deleteById(id);
    }

}