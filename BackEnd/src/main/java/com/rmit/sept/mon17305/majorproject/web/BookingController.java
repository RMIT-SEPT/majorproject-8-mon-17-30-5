package com.rmit.sept.mon17305.majorproject.web;

import com.rmit.sept.mon17305.majorproject.CustomedException.TimeFormatException;
import com.rmit.sept.mon17305.majorproject.model.Booking;
import com.rmit.sept.mon17305.majorproject.model.Booking;
import com.rmit.sept.mon17305.majorproject.model.Worker;
import com.rmit.sept.mon17305.majorproject.service.BookingService;
import com.rmit.sept.mon17305.majorproject.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins="http://frontend-alb-1569250992.us-east-1.elb.amazonaws.com")
@RestController
@RequestMapping("/api/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/create/")
    public ResponseEntity<?> createNewBooking(@RequestBody Booking booking, BindingResult result) throws Exception {

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

    @GetMapping("/customer/{id}")
    public List<Booking> getBookingsByCustomerId(@PathVariable Long id) {

        return bookingService.getBookingsByCustomerId(id);
    }

    @GetMapping("/customer/{id}/dateASC")
    public List<Booking> getBookingsByCustomerIdOrderDateASC(@PathVariable Long id) throws Exception {

        return bookingService.getBookingByCustomerIdOrderByDateASC(id);
    }

    @GetMapping("/customer/{id}/dateDESC")
    public List<Booking> getBookingsByCustomerIdOrderDateDESC(@PathVariable Long id) throws Exception {

        return bookingService.getBookingByCustomerIdOrderByDateDESC(id);
    }

    @GetMapping("/{id}")
    public Optional<Booking> getBooking(@PathVariable Long id) {
        return bookingService.getBooking(id);
    }

    @GetMapping("/{date}")
    public List<Booking> getBookingsByDate(@PathVariable String date) {

        return bookingService.getBookingsByDate(date);
    }

    @GetMapping("/allBooking/{comId}")
    public List<Booking> getBookingsForAdmin(@PathVariable Long comId) throws Exception {
        return bookingService.getBookingByCompanyId(comId);
    }

    @GetMapping("/allBooking/{comId}/ASC")
    public List<Booking> getBookingsForAdminASC(@PathVariable Long comId) throws Exception {
        return bookingService.getBookingByCompIdOrderByDateASC(comId);
    }

    @GetMapping("/allBooking/{comId}/DESC")
    public List<Booking> getBookingsForAdminDESC(@PathVariable Long comId) throws Exception {
        return bookingService.getBookingByCompIdOrderByDateDESC(comId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> replaceBooking(@RequestBody Booking newBooking, @PathVariable Long id) {

        bookingService.getBooking(id)
                .map(booking -> {
                    booking.setCustomerId(newBooking.getCustomerId());
                    booking.setServiceId(newBooking.getServiceId());
                    booking.setWorkerId(newBooking.getWorkerId());
                    try {
                        return new ResponseEntity<Booking> (bookingService.saveOrUpdateBooking(booking),HttpStatus.ACCEPTED);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return null;
                })
                .orElseGet(() -> {
                    try {
                        Booking booking1 = bookingService.saveOrUpdateBooking(newBooking);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return new ResponseEntity<Booking>(newBooking, HttpStatus.CREATED);
                });

        return new ResponseEntity<String>("Couldn't find Booking", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    void deleteBooking(@PathVariable Long id) {
        bookingService.deleteBookingById(id);
    }

    private boolean checkTimeformat(String timeString){
        boolean valid = true;
        if(timeString.contains(":")){
            String[] time = timeString.split(":");
            int hr = Integer.parseInt(time[0]);
            int min = Integer.parseInt(time[1]);
            if(hr>24 || hr <0){
                valid = false;
            }
            if(min>59|| min < 0){
                valid = false;
            }
        }else{
            valid = false;
        }

        return valid;
    }
}
