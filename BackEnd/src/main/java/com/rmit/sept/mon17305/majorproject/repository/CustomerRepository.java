<<<<<<< HEAD
package com.rmit.sept.mon17305.majorproject.repository;

import com.rmit.sept.mon17305.majorproject.model.Admin;
import com.rmit.sept.mon17305.majorproject.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    @Override
    Iterable<Customer> findAllById(Iterable<Long> iterable);
    List<Customer> findAll();
    Optional<Customer> findById(Long id);
    Customer findByUsername(String username);
    Customer findByUsernameAndPassword(String username, String password);
    Customer findByIdEquals(Long id);
    @Override
    void deleteById(Long id);



}
=======
package com.rmit.sept.mon17305.majorproject.repository;

import com.rmit.sept.mon17305.majorproject.model.Admin;
import com.rmit.sept.mon17305.majorproject.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    @Override
    Iterable<Customer> findAllById(Iterable<Long> iterable);
    List<Customer> findAll();
    Optional<Customer> findById(Long id);
    Customer findByUsername(String username);
    Customer findByUsernameAndPassword(String username, String password);
    Customer findByIdEquals(Long id);
    @Override
    void deleteById(Long id);



}
>>>>>>> m3-local
