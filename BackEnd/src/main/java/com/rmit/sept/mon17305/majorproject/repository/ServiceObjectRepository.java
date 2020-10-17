package com.rmit.sept.mon17305.majorproject.repository;

import com.rmit.sept.mon17305.majorproject.model.ServiceObject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ServiceObjectRepository extends CrudRepository<ServiceObject, Long> {

    @Override
    Iterable<ServiceObject> findAllById(Iterable<Long> iterable);
    List<ServiceObject> findAll();
    Optional<ServiceObject> findById(Long id);
    ServiceObject findByIdEquals(Long id);
    List<ServiceObject> findByCompanyIdEquals(Long id);
    @Override
    void deleteById(Long id);

}