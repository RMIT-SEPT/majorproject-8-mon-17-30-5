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
        when(
                bookingRepository.findByDateAndWorkerIdAndStartTime(
                        booking.getDate(), booking.getWorkerId(), booking.getStartTime())
        ).thenReturn(null);
        assertThrows(NullPointerException.class, ()->{
            bookingService.getBookingByDateAndWorkerIdAndTime(
                    booking.getDate(), booking.getWorkerId(), booking.getStartTime());
        },"booking not found");
    }

    @Test
    void getBookingByDateAndWorkerIdAndTime_bookingList_validInfo() throws Exception {
        List<Booking> list = new ArrayList<Booking>();
        list.add(0, booking);
        when(
                bookingRepository.findByDateAndWorkerIdAndStartTime(
                        booking.getDate(), booking.getWorkerId(), booking.getStartTime())
        ).thenReturn(list);
        assertEquals(list,
            bookingService.getBookingByDateAndWorkerIdAndTime(
                    booking.getDate(), booking.getWorkerId(), booking.getStartTime()));
    }

    @Test
    void getBookingByWorkerIdAndDate_bookingList_validInfo() throws Exception {
        List<Booking> list = new ArrayList<Booking>();
        list.add(0, booking);
        when(bookingRepository.findByWorkerIdAndDate(
                        booking.getWorkerId(), booking.getDate()))
                .thenReturn(list);
        assertEquals(list,
                bookingRepository.findByWorkerIdAndDate(
                        booking.getWorkerId(), booking.getDate()));
    }

    @Test
    void getBookingByWorkerIdAndDate_exceptThrown_invalidWorkerId(){
        booking.setWorkerId((long)-1);
        assertThrows(Exception.class, ()->{
            bookingService.getBookingByWorkerIdAndDate(
                    booking.getWorkerId(), booking.getDate());
        }, "invalid id");
    }
    @Test
    void getBookingByWorkerIdAndDate_exceptThrown_invalidDate(){
        booking.setDate(null);
        assertThrows(Exception.class, ()->{
            bookingService.getBookingByWorkerIdAndDate(
                    booking.getWorkerId(), booking.getDate());
        }, "invalid date");
    }

    @Test
    void getBookingByWorkerIdAndDate_NullptrExceptThrown_NoExistedBooking(){
        booking.setDate(null);
        List<Booking> list = new ArrayList<Booking>();
        list.add(0, booking);
        when(bookingRepository.findByWorkerIdAndDate(
                booking.getWorkerId(), booking.getDate()))
                .thenReturn(null);
        assertThrows(Exception.class, ()->{
            bookingService.getBookingByWorkerIdAndDate(
                    booking.getWorkerId(), booking.getDate());
        }, "no booking found");
    }

    @Test
    void getBookingByCompanyId_booking_ValidId() throws Exception {
        List<Booking> list = new ArrayList<Booking>();
        list.add(0, booking);
        when(bookingRepository.findByCompanyId(booking.getCompanyId()))
                .thenReturn(list);
        assertEquals(list, bookingService.getBookingByCompanyId(booking.getCompanyId()));
    }

    @Test
    void getBookingByCompanyId_exceptThrown_invalidComId(){
        booking.setCompanyId((long)-1);
        assertThrows(Exception.class, ()->{
            bookingService.getBookingByCompanyId(booking.getCompanyId());
        }, "invalid id");
    }

    @Test
    void getBookingByCompanyId_NullptrExceptThrown_NoBookingExist(){
        when(bookingRepository.findByCompanyId(booking.getCompanyId()))
                .thenReturn(null);
        assertThrows(Exception.class, ()->{
            bookingService.getBookingByCompanyId(booking.getCompanyId());
        }, "Company booking not found");
    }

    @Test
    void getBookingByDateAndWorkerId_booking_ValidInfo() throws Exception {
        List<Booking> list = new ArrayList<Booking>();
        list.add(0, booking);
        when(bookingRepository.findByWorkerIdAndDate(booking.getWorkerId(),
                booking.getDate()))
                .thenReturn(list);
        assertEquals(list,
                bookingService.getBookingByDateAndWorkerId(booking.getDate(), booking.getWorkerId()));
    }

    @Test
    void getBookingByDateAndWorkerId_ExceptThrown_InvalidDate(){
        booking.setDate(null);
        assertThrows(Exception.class, ()->{
            bookingService.getBookingByDateAndWorkerId(booking.getDate(), booking.getWorkerId());
        },"invalid date");
    }
    @Test
    void getBookingByDateAndWorkerId_ExceptThrown_InvalidId(){
        booking.setWorkerId((long)-1);
        assertThrows(Exception.class, ()->{
            bookingService.getBookingByDateAndWorkerId(booking.getDate(), booking.getWorkerId());
        },"invalid id");
    }

    @Test
    void getBookingByDateAndWorkerId_NullPtrExcpt_NoBookingExist(){
        when(bookingRepository.findByWorkerIdAndDate(booking.getWorkerId(),
                booking.getDate()))
                .thenReturn(null);
        assertThrows(NullPointerException.class, ()->{
            bookingService.getBookingByDateAndWorkerId(booking.getDate(), booking.getWorkerId());
        },"no booking found");
    }

    @Test
    void getBookingByCustomerIdOrderByDateASC_booking_ValidId() throws Exception {
        List<Booking> list = new ArrayList<Booking>();
        list.add(0, booking);
        when(bookingRepository.findByCustomerIdOrderByDate(booking.getCustomerId()))
                .thenReturn(list);
        assertEquals(list, bookingService.getBookingByCustomerIdOrderByDateASC(
                booking.getCustomerId()));
    }
    @Test
    void getBookingByCustomerIdOrderByDateASC_exceptThrown_invalidId(){
        booking.setCustomerId((long)-1);
        assertThrows(Exception.class,()->{
            bookingService.getBookingByCustomerIdOrderByDateASC(
                    booking.getCustomerId());
        }, "invalid id");
    }

    @Test
    void getBookingByCustomerIdOrderByDateASC_NullPtrExceptThrown_NoBookingExist(){
        when(bookingRepository.findByCustomerIdOrderByDate(booking.getCustomerId()))
                .thenReturn(null);
        assertThrows(NullPointerException.class,()->{
            bookingService.getBookingByCustomerIdOrderByDateASC(
                    booking.getCustomerId());
        }, "no booking found");
    }

    @Test
    void getBookingByCustomerIdOrderByDateDESC_booking_ValidId() throws Exception {
        List<Booking> list = new ArrayList<Booking>();
        list.add(0, booking);
        when(bookingRepository.findByCustomerIdOrderByDateDesc(booking.getCustomerId()))
                .thenReturn(list);
        assertEquals(list, bookingService.getBookingByCustomerIdOrderByDateDESC(
                booking.getCustomerId()));
    }
    @Test
    void getBookingByCustomerIdOrderByDateDESC_exceptThrown_invalidId(){
        booking.setCustomerId((long)-1);
        assertThrows(Exception.class,()->{
            bookingService.getBookingByCustomerIdOrderByDateDESC(
                    booking.getCustomerId());
        }, "invalid id");
    }

    @Test
    void getBookingByCustomerIdOrderByDateDESC_NullPtrExceptThrown_NoBookingExist(){
        when(bookingRepository.findByCustomerIdOrderByDateDesc(booking.getCustomerId()))
                .thenReturn(null);
        assertThrows(NullPointerException.class,()->{
            bookingService.getBookingByCustomerIdOrderByDateDESC(
                    booking.getCustomerId());
        }, "no booking found");
    }

    @Test
    void getBookingByCompIdOrderByDateASC_booking_ValidId() throws Exception {
        List<Booking> list = new ArrayList<Booking>();
        list.add(0, booking);
        when(bookingRepository.findByCompanyIdOrderByDate(booking.getCompanyId()))
                .thenReturn(list);
        assertEquals(list, bookingService.getBookingByCompIdOrderByDateASC(
                booking.getCompanyId()));
    }
    @Test
    void getBookingByCompIdOrderByDateASC_exceptThrown_invalidId(){
        booking.setCompanyId((long)-1);
        List<Booking> list = new ArrayList<Booking>();
        list.add(0, booking);
        when(bookingRepository.findByCompanyIdOrderByDate(booking.getCustomerId()))
                .thenReturn(list);
        assertThrows(Exception.class,()->{
            bookingService.getBookingByCompIdOrderByDateASC(
                    booking.getCompanyId());
        }, "invalid id");
    }

    @Test
    void getBookingByCompIdOrderByDateASC_NullPtrExceptThrown_NoBookingExist(){
        when(bookingRepository.findByCompanyIdOrderByDate(booking.getCompanyId()))
                .thenReturn(null);
        assertThrows(NullPointerException.class,()->{
            bookingService.getBookingByCompIdOrderByDateASC(
                    booking.getCompanyId());
        }, "no booking found");
    }

    @Test
    void getBookingByCompIdOrderByDateDESC_booking_ValidId() throws Exception {
        List<Booking> list = new ArrayList<Booking>();
        list.add(0, booking);
        when(bookingRepository.findByCompanyIdOrderByDateDesc(booking.getCompanyId()))
                .thenReturn(list);
        assertEquals(list, bookingService.getBookingByCompIdOrderByDateDESC(
                booking.getCompanyId()));
    }
    @Test
    void getBookingByCompIdOrderByDateDESC_exceptThrown_invalidId(){
        booking.setCompanyId((long)-1);
        assertThrows(Exception.class,()->{
            bookingService.getBookingByCompIdOrderByDateDESC(
                    booking.getCompanyId());
        }, "invalid id");
    }

    @Test
    void getBookingByCompIdOrderByDateDESC_NullPtrExceptThrown_NoBookingExist(){
        when(bookingRepository.findByCompanyIdOrderByDateDesc(booking.getCompanyId()))
                .thenReturn(null);
        assertThrows(NullPointerException.class,()->{
            bookingService.getBookingByCompIdOrderByDateDESC(
                    booking.getCompanyId());
        }, "no booking found");
    }
}
