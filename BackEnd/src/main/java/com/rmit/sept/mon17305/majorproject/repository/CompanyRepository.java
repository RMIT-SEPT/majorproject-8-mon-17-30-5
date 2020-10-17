<<<<<<< HEAD
package com.rmit.sept.mon17305.majorproject.repository;

import com.rmit.sept.mon17305.majorproject.model.Company;
import com.rmit.sept.mon17305.majorproject.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {

    @Override
    Iterable<Company> findAllById(Iterable<Long> iterable);
    List<Company> findAll();
    Optional<Company> findById(Long id);
    Company findByCompanyName(String companyname);
    Company findByIdEquals(Long id);
    @Override
    void deleteById(Long id);

=======
package com.rmit.sept.mon17305.majorproject.repository;

import com.rmit.sept.mon17305.majorproject.model.Company;
import com.rmit.sept.mon17305.majorproject.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {

    @Override
    Iterable<Company> findAllById(Iterable<Long> iterable);
    List<Company> findAll();
    Optional<Company> findById(Long id);
    Company findByCompanyName(String companyname);
    Company findByIdEquals(Long id);
    @Override
    void deleteById(Long id);

>>>>>>> m3-local
}