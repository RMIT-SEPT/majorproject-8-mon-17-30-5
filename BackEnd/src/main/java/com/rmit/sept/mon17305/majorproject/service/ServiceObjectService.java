<<<<<<< HEAD
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

    public ServiceObject saveOrUpdateServiceObject(ServiceObject serviceObject) throws Exception {
        if(serviceObject==null){
            throw new NullPointerException(("null service object"));
        }else if(serviceObject.getCompanyId() < 1){
            throw new Exception("invalid company id");
        } else if (serviceObject.getDuration()<=0 || serviceObject.getDuration()>12) {
            throw new Exception("invalid duration");
        }
        ServiceObject ret = serviceObjectRepository.save(serviceObject);
        if(ret==null){
            throw new NullPointerException("cannot save");
        }
        return ret;

    }

    public List<ServiceObject> getServiceObjects(){
        List<ServiceObject> ret = serviceObjectRepository.findAll();
        if(ret==null){
            throw new NullPointerException("currently no service");
        }
        return ret;

    }

    public Optional<ServiceObject> getServiceObject(Long id){
        Optional<ServiceObject> ret = serviceObjectRepository.findById(id);
        if(!ret.isPresent()){
            throw new NullPointerException("cannot find service id");
        }
        return ret;
    }

    public Optional<ServiceObject> getServiceObjectDuration(Long id){
        return serviceObjectRepository.findById(id);
    }

    public void deleteServiceObjectById(Long id) throws Exception {
        if(id < 1){
            throw new Exception("invalid id");
        }
        serviceObjectRepository.deleteById(id);
    }

    public String getServiceDescriptionById(Long id) throws Exception {
        if(id < 1){
            throw new Exception("invalid id");
        }
        ServiceObject found = serviceObjectRepository.findByIdEquals(id);
        if (found==null) {
            throw new NullPointerException("cannot find service with id given");
        }
        String ret = found.getDescription();
        if(ret==null||ret.equals("")){
            throw new Exception("invalid description");
        }
        return ret;
    }

    public List<ServiceObject> getServiceObjectsByCompanyId(Long id) throws Exception {
        if(id < 1){
            throw new Exception("invalid id");
        }
        List<ServiceObject> ret = serviceObjectRepository.findByCompanyIdEquals(id);
        if(ret==null){
            throw new NullPointerException("cannot find services for company");
        }
        return ret;
    }
=======
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

    public ServiceObject saveOrUpdateServiceObject(ServiceObject serviceObject) throws Exception {
        if(serviceObject==null){
            throw new NullPointerException(("null service object"));
        }else if(serviceObject.getCompanyId() < 1){
            throw new Exception("invalid company id");
        } else if (serviceObject.getDuration()<=0 || serviceObject.getDuration()>12) {
            throw new Exception("invalid duration");
        }
        ServiceObject ret = serviceObjectRepository.save(serviceObject);
        if(ret==null){
            throw new NullPointerException("cannot save");
        }
        return ret;

    }

    public List<ServiceObject> getServiceObjects(){
        List<ServiceObject> ret = serviceObjectRepository.findAll();
        if(ret==null){
            throw new NullPointerException("currently no service");
        }
        return ret;

    }

    public Optional<ServiceObject> getServiceObject(Long id){
        Optional<ServiceObject> ret = serviceObjectRepository.findById(id);
        if(!ret.isPresent()){
            throw new NullPointerException("cannot find service id");
        }
        return ret;
    }

    public Optional<ServiceObject> getServiceObjectDuration(Long id){
        return serviceObjectRepository.findById(id);
    }

    public void deleteServiceObjectById(Long id) throws Exception {
        if(id < 1){
            throw new Exception("invalid id");
        }
        serviceObjectRepository.deleteById(id);
    }

    public String getServiceDescriptionById(Long id) throws Exception {
        if(id < 1){
            throw new Exception("invalid id");
        }
        ServiceObject found = serviceObjectRepository.findByIdEquals(id);
        if (found==null) {
            throw new NullPointerException("cannot find service with id given");
        }
        String ret = found.getDescription();
        if(ret==null||ret.equals("")){
            throw new Exception("invalid description");
        }
        return ret;
    }

    public List<ServiceObject> getServiceObjectsByCompanyId(Long id) throws Exception {
        if(id < 1){
            throw new Exception("invalid id");
        }
        List<ServiceObject> ret = serviceObjectRepository.findByCompanyIdEquals(id);
        if(ret==null){
            throw new NullPointerException("cannot find services for company");
        }
        return ret;
    }
>>>>>>> m3-local
}