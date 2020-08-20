package com.rmit.sept.mon17305.majorproject.web;

import com.rmit.sept.mon17305.majorproject.model.Booking;
import com.rmit.sept.mon17305.majorproject.model.Booking;
import com.rmit.sept.mon17305.majorproject.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("")
    public ResponseEntity<?> createNewBooking(@RequestBody Booking booking, BindingResult result){

        if (result.hasErrors()){
            for(FieldError error: result.getFieldErrors()) {
                return new ResponseEntity<List<FieldError>>(result.getFieldErrors(), HttpStatus.BAD_REQUEST);
            }
        }

        Booking booking1 = bookingService.saveOrUpdateBooking(booking);
        return new ResponseEntity<Booking>(booking, HttpStatus.CREATED);

    }

    @GetMapping("/")
    public List<Booking> getBookings() {

        return bookingService.getBookings();
    }

    @GetMapping("/{id}")
    public Optional<Booking> getBooking(@PathVariable Long id) {
        return bookingService.getBooking(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> replaceBooking(@RequestBody Booking newBooking, @PathVariable Long id) {

        bookingService.getBooking(id)
                .map(booking -> {
                    booking.setCustomerId(newBooking.getCustomerId());
                    booking.setServiceId(newBooking.getServiceId());
                    booking.setWorkerId(newBooking.getWorkerId());
                    return new ResponseEntity<Booking> (bookingService.saveOrUpdateBooking(booking),HttpStatus.ACCEPTED);
                })
                .orElseGet(() -> {
                    Booking booking1 = bookingService.saveOrUpdateBooking(newBooking);
                    return new ResponseEntity<Booking>(newBooking, HttpStatus.CREATED);
                });

        return new ResponseEntity<String>("Couldn't find Booking", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    void deleteBooking(@PathVariable Long id) {
        bookingService.deleteBookingById(id);
    }

}
