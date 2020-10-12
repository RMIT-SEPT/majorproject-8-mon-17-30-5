package com.rmit.sept.mon17305.majorproject.service;

import com.rmit.sept.mon17305.majorproject.model.Booking;
import com.rmit.sept.mon17305.majorproject.repository.BookingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextConfiguration(classes= BookingService.class)
public class BookingServiceTest {

    @Autowired
    public BookingService bookingService;

    @MockBean
    public BookingRepository bookingRepository;

    public Booking booking = new Booking();

    @BeforeEach
    public void setUp(){
        booking.setId((long)1);
        booking.setCustomerId((long)2);
        booking.setWorkerId((long)3);
        booking.setWorkerName("Jack");
        booking.setServiceId((long)4);
        booking.setStartTime(800);
        booking.setFinishTime(900);
        booking.setDate("2020-10-23");
        booking.setCompanyId((long)1);
    }

    @Test
    void saveOrUpdateBooking_booking_correctFormatInformation(){
        when(bookingRepository.save(booking)).thenReturn(booking);
        assertEquals(booking, bookingRepository.save(booking));
    }

    @Test
    void saveOrUpdateBooking_NullPtrExcp_NullBooking(){
        assertThrows(NullPointerException.class, () ->{
            bookingService.saveOrUpdateBooking(null);
        }, "booking cannot be null");
    }

    @Test
    void saveOrUpdateBooking_Except_InvalidCustomerId(){
        booking.setCompanyId((long)-1);
        when(bookingRepository.save(booking)).thenReturn(booking);
        assertThrows(Exception.class, ()->{
            bookingService.saveOrUpdateBooking(booking);
        },"booking information is invalid");
    }

    @Test
    void saveOrUpdateBooking_Except_InvalidWorkerId(){
        booking.setWorkerId((long)-1);
        when(bookingRepository.save(booking)).thenReturn(booking);
        assertThrows(Exception.class, ()->{
            bookingService.saveOrUpdateBooking(booking);
        },"booking information is invalid");
    }

    @Test
    void saveOrUpdateBooking_Except_InvalidCompanyId(){
        booking.setCompanyId((long)-1);
        when(bookingRepository.save(booking)).thenReturn(booking);
        assertThrows(Exception.class, ()->{
            bookingService.saveOrUpdateBooking(booking);
        },"booking information is invalid");
    }

    @Test
    void saveOrUpdateBooking_Except_InvalidStartTime(){
        booking.setStartTime(-100);
        when(bookingRepository.save(booking)).thenReturn(booking);
        assertThrows(Exception.class, ()->{
            bookingService.saveOrUpdateBooking(booking);
        },"booking information is invalid");
    }
    @Test
    void saveOrUpdateBooking_Except_InvalidFinishTime(){
        booking.setFinishTime(-100);
        when(bookingRepository.save(booking)).thenReturn(booking);
        assertThrows(Exception.class, ()->{
            bookingService.saveOrUpdateBooking(booking);
        },"booking information is invalid");
    }

    @Test
    void getBookings_booking_BookingExist(){
        List<Booking> list = new ArrayList<Booking>();
        list.add(0, booking);
        when(bookingRepository.findAll()).thenReturn(list);
        assertTrue(bookingService.getBookings().contains(booking)
        && bookingService.getBookings().size()==1);
    }

    @Test
    void getBookings_NullPtr_NoBooking(){
        when(bookingRepository.findAll()).thenReturn(null);
        assertThrows(NullPointerException.class, ()->{
            bookingService.getBookings();
        },"There is currently no booking");
    }

    @Test
    void getBookingsByCustomerId_booking_BookingExist(){
        List<Booking> list = new ArrayList<Booking>();
        list.add(0, booking);
        when(bookingRepository.findByCustomerId(booking.getCustomerId())).thenReturn(list);
        assertTrue(bookingService.getBookingsByCustomerId(booking.getCustomerId()).contains(booking)
                && bookingService.getBookingsByCustomerId(booking.getCustomerId()).size()==1);
    }

    @Test
    void getBookingsByCustomerId_NullPtr_NoBooking(){
        when(bookingRepository.findByCustomerId(booking.getCustomerId())).thenReturn(null);
        assertThrows(NullPointerException.class, ()->{
            bookingService.getBookingsByCustomerId(booking.getCustomerId());
        },"There is currently no booking for this customer");
    }

    @Test
    void getBookingsByDate_booking_BookingExist(){
        List<Booking> list = new ArrayList<Booking>();
        list.add(0, booking);
        when(bookingRepository.findByDate(booking.getDate())).thenReturn(list);
        assertTrue(bookingService.getBookingsByDate(booking.getDate()).contains(booking)
                && bookingService.getBookingsByDate(booking.getDate()).size()==1);
    }

    @Test
    void getBookingsByDate_NullPtr_NoBooking(){
        when(bookingRepository.findByDate(booking.getDate())).thenReturn(null);
        assertThrows(NullPointerException.class, ()->{
            bookingService.getBookingsByDate(booking.getDate());
        },"There is currently no booking for this date");
    }

    @Test
    void getBooking_booking_IdOne(){
        when(bookingRepository.findById(booking.getId()))
                .thenReturn(java.util.Optional.ofNullable(booking));
        assertTrue(bookingRepository.findById(booking.getId()).toString()
        .contains(booking.toString()));
    }
    @Test
    void getBooking_NullptrExcept_InvalidId() {
        when(bookingRepository.findById((long) 3)).thenReturn(null);
        assertThrows(NullPointerException.class, () -> {
            bookingService.getBooking((long) 3);
        }, "Booking id not found");
    }

    @Test
    void deleteBookingById_NotThrow_ValidId(){
        when(bookingRepository.findById(booking.getId()))
                .thenReturn(java.util.Optional.ofNullable(booking));
        assertDoesNotThrow(()->{
            bookingService.deleteBookingById(booking.getId());
        });
    }
    @Test
    void deleteBookingById_ThrowNullExcept_inValidId(){
        when(bookingRepository.findById((long) 3)).thenReturn(null);
        assertThrows(NullPointerException.class, () -> {
            bookingService.deleteBookingById((long) 3);
        }, "Booking id not found");
    }

    @Test
    void getBookingByDateAndWorkerIdAndTime_Exception_InvalidDate(){
        booking.setDate(null);
        assertThrows(Exception.class, ()->{
            bookingService.getBookingByDateAndWorkerIdAndTime(
                    booking.getDate(), booking.getWorkerId(), booking.getStartTime()
            );
        },"date is invalid");
    }

    @Test
    void getBookingByDateAndWorkerIdAndTime_Exception_InvalidWrokerId(){
        booking.setWorkerId((long)-1);
        assertThrows(Exception.class, ()->{
            bookingService.getBookingByDateAndWorkerIdAndTime(
                    booking.getDate(), booking.getWorkerId(), booking.getStartTime()
            );
        },"invalid worker id");
    }

    @Test
    void getBookingByDateAndWorkerIdAndTime_Exception_InvalidStartTime(){
        booking.setStartTime(-100);
        assertThrows(Exception.class, ()->{
            bookingService.getBookingByDateAndWorkerIdAndTime(
                    booking.getDate(), booking.getWorkerId(), booking.getStartTime()
            );
        },"invalid start time");
    }

    @Test
    void getBookingByDateAndWorkerIdAndTime_NullptrExcept_NoBookingExist(){
        List<Booking> list = new ArrayList<Booking>();
        list.add(0, booking);
        when(
                bookingRepository.findByDateAndWorkerIdAndStartTime(
                        booking.getDate(), booking.getWorkerId(), booking.getStartTime())
        ).thenReturn(null);
        assertThrows(NullPointerException.class, ()->{
            bookingService.getBookingByDateAndWorkerIdAndTime(
                    booking.getDate(), booking.getWorkerId(), booking.getStartTime());
        },"booking not found");
    }
}
