package com.api.Hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.Hotel.model.Booking;

public interface BookingRepo extends JpaRepository<Booking, Long> {

}
