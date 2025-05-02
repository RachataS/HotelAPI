package com.api.Hotel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.Hotel.model.RoomType;
import com.api.Hotel.repository.TypeRepo;

@Service
public class TypeService {

    @Autowired
    private TypeRepo typeRepo;

    public List<RoomType> getAllType() {
        return typeRepo.findAll();
    }

    public Optional<RoomType> getTypeById(Long id) {
        return typeRepo.findById(id);
    }

    public RoomType craRoomType(RoomType roomType) {
        return typeRepo.save(roomType);
    }

    public RoomType updaType(Long id, RoomType typeDetail) {
        RoomType type = typeRepo.findById(id).orElseThrow();
        type.setTypeName(typeDetail.getTypeName());
        return typeRepo.save(type);
    }

    public void deleteType(Long id) {
        typeRepo.deleteById(id);
    }
}
