package com.api.Hotel.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.api.Hotel.model.RoomType;
import com.api.Hotel.service.TypeService;

@RestController
@RequestMapping("/api/rooms/type")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping
    public List<RoomType> getAllType() {
        return typeService.getAllType();
    }

    @GetMapping("/{id}")
    public Optional<RoomType> getTypeById(@PathVariable Long id) {
        return typeService.getTypeById(id);
    }

    @PostMapping
    public RoomType createType(@RequestBody RoomType type) {
        return typeService.craRoomType(type);
    }

    @PutMapping("/{id}")
    public RoomType updateType(@PathVariable Long id, @RequestBody RoomType type) {
        return typeService.updaType(id, type);
    }

    @DeleteExchange("/{id}")
    public void deleteType(@PathVariable Long id) {
        typeService.deleteType(id);
    }

}
