package com.rmit.sept.mon17305.majorproject.repository;

import com.rmit.sept.mon17305.majorproject.model.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Long> {

    @Override
    Iterable<Admin> findAllById(Iterable<Long> iterable);
    List<Admin> findAll();
    Optional<Admin> findById(Long id);
}