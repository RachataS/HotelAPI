package com.api.Hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.Hotel.model.RoomType;

public interface TypeRepo extends JpaRepository<RoomType, Long> {

}
