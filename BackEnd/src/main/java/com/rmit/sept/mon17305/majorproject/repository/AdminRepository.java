package com.rmit.sept.mon17305.majorproject.repository;

import com.rmit.sept.mon17305.majorproject.model.Admin;
import com.rmit.sept.mon17305.majorproject.model.Customer;
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
    Admin findByUsername(String username);
    Admin findByUsernameAndPassword(String username, String password);
    Admin findByIdEquals(Long id);
    @Override
    void deleteById(Long id);
}