package com.api.Hotel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.Hotel.model.Room;
import com.api.Hotel.repository.RoomRepo;

@Service
public class RoomService {

    @Autowired
    private RoomRepo roomRepo;

    public List<Room> getAllRooms() {
        return roomRepo.findAll();
    }

    public Optional<Room> getRoomById(String id) {
        return roomRepo.findById(id);
    }

    public Room updateIsEmpty(Room roomDetail) {
        Room room = roomRepo.findById(roomDetail.getRoomNumber()).orElseThrow();
        room.setEmpty(roomDetail.isEmpty());
        return roomRepo.save(room);
    }

    public Room createRoom(Room room) {
        return roomRepo.save(room);
    }

    public Room updateRoom(String id, Room roomDetail) {
        Room room = roomRepo.findById(id).orElseThrow();
        if (roomDetail.getRoomNumber() != null) {
            room.setRoomNumber(roomDetail.getRoomNumber());
        }
        if (roomDetail.getPrice() != 0) {
            room.setPrice(roomDetail.getPrice());
        }
        if (roomDetail.getRoomType() != null) {
            room.setRoomType(roomDetail.getRoomType());
        }
        room.setEmpty(roomDetail.isEmpty());

        return roomRepo.save(room);
    }

    public void deleteRoom(String id) {
        roomRepo.deleteById(id);
    }
}
