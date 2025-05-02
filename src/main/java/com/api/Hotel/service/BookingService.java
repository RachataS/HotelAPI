package com.api.Hotel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.Hotel.model.Booking;
import com.api.Hotel.repository.BookingRepo;

@Service
public class BookingService {

    @Autowired
    private BookingRepo bookingRepo;

    @Autowired
    private RoomService roomService;

    public List<Booking> getAllBookings() {
        return bookingRepo.findAll();
    }

    public Optional<Booking> getBookingById(Long id) {
        return bookingRepo.findById(id);
    }

    public Booking createBooking(Booking booking) {
        if (booking.getRoomNumber() != null) {
            roomService.updateIsEmpty(booking.getRoomNumber());
        }
        return bookingRepo.save(booking);
    }

    public void deleteBooking(Long id) {
        bookingRepo.deleteById(id);
    }
}
