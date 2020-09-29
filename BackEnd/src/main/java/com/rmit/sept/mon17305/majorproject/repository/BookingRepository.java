package com.rmit.sept.mon17305.majorproject.repository;

import com.rmit.sept.mon17305.majorproject.model.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> {

    @Override
    Iterable<Booking> findAllById(Iterable<Long> iterable);
    List<Booking> findAll();
    Optional<Booking> findById(Long id);
    List<Booking> findByCustomerId(Long id);
    List<Booking> findByDate(String date);
    List<Booking> findByDateAndWorkerIdAndStartTime(String date, Long id, int startTime);
    List<Booking> findByWorkerIdAndDate(Long id, String date);
    List<Booking> findByCompanyId(Long id);
    @Override
    void deleteById(Long id);
}