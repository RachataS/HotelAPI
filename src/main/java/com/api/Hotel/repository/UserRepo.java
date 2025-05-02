package com.api.Hotel.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.Hotel.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    List<User> findByType_Name(String name);
}