package com.rmit.sept.mon17305.majorproject.repository;

import com.rmit.sept.mon17305.majorproject.model.Admin;
import com.rmit.sept.mon17305.majorproject.model.Worker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorkerRepository extends CrudRepository<Worker, Long> {

    @Override
    Iterable<Worker> findAllById(Iterable<Long> iterable);
    List<Worker> findAll();
    Optional<Worker> findById(Long id);
    Worker findByUsername(String username);
    Worker findByUsernameAndPassword(String username, String password);
    Worker findByIdEquals(Long id);
    List<Worker> findByCompanyIdEquals(Long id);
    @Override
    void deleteById(Long id);

}