package com.rmit.sept.mon17305.majorproject.service;

import com.rmit.sept.mon17305.majorproject.model.Booking;
import com.rmit.sept.mon17305.majorproject.model.Booking;
import com.rmit.sept.mon17305.majorproject.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.constraints.Null;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public Booking saveOrUpdateBooking(Booking booking) throws Exception {
        if(booking==null){
            throw new NullPointerException("booking cannot be null");
        }else if(booking.getDate()==null){
            throw new NullPointerException("booking date cannot be null");
        }
        if(booking.getCustomerId() < 1 || booking.getWorkerId() < 1
                || booking.getCustomerId()<1 || booking.getStartTime() <= 0
        || booking.getFinishTime() <= 0 || booking.getCompanyId()<0){
            throw new Exception("booking information is invalid");
        }
        return bookingRepository.save(booking);

    }

    public List<Booking> getBookings(){
        List<Booking> ret =  bookingRepository.findAll();
        if(ret==null){
            throw new NullPointerException("There is currently no booking");
        }
        return ret;
    }

    public List<Booking> getBookingsByCustomerId(Long id) {
        List<Booking> ret =  bookingRepository.findByCustomerId(id);
        if(ret==null){
            throw new NullPointerException("There is currently no booking for this customer");
        }
        return ret;
    }

    public List<Booking> getBookingsByDate(String date) {
        List<Booking> ret =bookingRepository.findByDate(date);
        if(ret==null){
            throw new NullPointerException(
                    "There is currently no booking for this date");
        }
        return ret;
    }

    public Optional<Booking> getBooking(Long id){
        Optional<Booking> ret = bookingRepository.findById(id);
        if(!ret.isPresent()){
            throw new NullPointerException(
                    "Booking id not found");
        }
        return bookingRepository.findById(id);
    }

    public void deleteBookingById(Long id){
        Optional<Booking> ret = bookingRepository.findById(id);
        if(!ret.isPresent()){
            throw new NullPointerException(
                    "Booking id not found");
        }
        bookingRepository.deleteById(id);
    }

    public List<Booking> getBookingByDateAndWorkerIdAndTime
            (String date, Long id, int time) throws Exception {
        if(date==null||date.length()<10){
            throw new Exception("date is invalid");
        }else if(id < 1){
            throw new Exception("invalid worker id");
        }else if(time < 0){
            throw new Exception("invalid start time");
        }
        List<Booking> ret = bookingRepository.findByDateAndWorkerIdAndStartTime(date, id,time);
        if(ret == null){
            throw new NullPointerException("booking not found");
        }
        return ret;
    }

    public List<Booking> getBookingByWorkerIdAndDate(Long id, String date){
        return bookingRepository.findByWorkerIdAndDate(id,date);
    }

    public List<Booking> getBookingByCompanyId(Long id){
        return bookingRepository.findByCompanyId(id);
    }

    public List<Booking> getBookingByDateAndWorkerId(String date, Long id){
        return bookingRepository.findByWorkerIdAndDate(id, date);
    }

    public List<Booking> getBookingByCustomerIdOrderByDateASC(Long id){
        return bookingRepository.findByCustomerIdOrderByDate(id);
    }

    public List<Booking> getBookingByCustomerIdOrderByDateDESC(Long id){
        return bookingRepository.findByCustomerIdOrderByDateDesc(id);
    }

    public List<Booking> getBookingByCompIdOrderByDateASC(Long id){
        return bookingRepository.findByCompanyIdOrderByDate(id);
    }

    public List<Booking> getBookingByCompIdOrderByDateDESC(Long id){
        return bookingRepository.findByCompanyIdOrderByDateDesc(id);
    }

}