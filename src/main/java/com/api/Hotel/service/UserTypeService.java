package com.api.Hotel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.Hotel.model.TypeUser;
import com.api.Hotel.repository.TypeUserRepo;

@Service
public class UserTypeService {

    @Autowired
    private TypeUserRepo userTypeRepo;

    public List<TypeUser> getAllUserTypes() {
        return userTypeRepo.findAll();
    }

    public Optional<TypeUser> getUserTypeById(Long id) {
        return userTypeRepo.findById(id);
    }

    public TypeUser createType(TypeUser type) {
        return userTypeRepo.save(type);
    }

    public TypeUser updateType(Long id, TypeUser typeDetail) {
        TypeUser type = userTypeRepo.findById(id).orElseThrow();
        type.setName(typeDetail.getName());
        return userTypeRepo.save(type);
    }

    public void deleteType(Long id) {
        userTypeRepo.deleteById(id);
    }

}
