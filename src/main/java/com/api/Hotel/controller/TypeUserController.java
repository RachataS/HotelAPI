package com.api.Hotel.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.Hotel.model.TypeUser;
import com.api.Hotel.service.UserTypeService;

@RestController
@RequestMapping("/api/users/type")
public class TypeUserController {

    @Autowired
    private UserTypeService typeService;

    @GetMapping
    public List<TypeUser> getAllUserTypes() {
        return typeService.getAllUserTypes();
    }

    @GetMapping("/{id}")
    public Optional<TypeUser> getUserTypeById(@PathVariable Long id) {
        return typeService.getUserTypeById(id);
    }

    @PostMapping
    public TypeUser creaTypeUser(@RequestBody TypeUser type) {
        return typeService.createType(type);
    }

    @PutMapping("/{id}")
    public TypeUser updateTypeUser(@PathVariable Long id, @RequestBody TypeUser type) {
        return typeService.updateType(id, type);
    }

    @DeleteMapping("/{id}")
    public void deleteTypeUser(@PathVariable Long id) {
        typeService.deleteType(id);
        ;
    }
}
