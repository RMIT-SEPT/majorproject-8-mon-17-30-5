package com.rmit.sept.mon17305.majorproject.service;

import com.rmit.sept.mon17305.majorproject.model.Booking;
import com.rmit.sept.mon17305.majorproject.model.Booking;
import com.rmit.sept.mon17305.majorproject.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public Booking saveOrUpdateBooking(Booking booking){

        //business logic
        return bookingRepository.save(booking);

    }

    public List<Booking> getBookings(){

        return bookingRepository.findAll();

    }

    public Optional<Booking> getBooking(Long id){

        return bookingRepository.findById(id);
    }

    public void deleteBookingById(Long id){

        bookingRepository.deleteById(id);
    }

}