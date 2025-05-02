package com.api.Hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.Hotel.model.Room;

public interface RoomRepo extends JpaRepository<Room, String> {

}