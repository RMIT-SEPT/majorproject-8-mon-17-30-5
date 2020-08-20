package com.rmit.sept.mon17305.majorproject.repository;

import com.rmit.sept.mon17305.majorproject.model.ServiceObject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceObjectRepository extends CrudRepository<ServiceObject, Long> {

    @Override
    Iterable<ServiceObject> findAllById(Iterable<Long> iterable);

}