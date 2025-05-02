package com.api.Hotel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.Hotel.model.Room;
import com.api.Hotel.model.User;
import com.api.Hotel.repository.RoomRepo;
import com.api.Hotel.repository.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoomRepo roomRepo;

    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    public Optional<User> getUserBuId(Long id) {
        return userRepo.findById(id);
    }

    public List<User> getUserByType(String type) {
        return userRepo.findByType_Name(type);
    }

    public User createUser(User user) {
        user.setPassword(passwordEncoder(user.getPassword()));
        return userRepo.save(user);
    }

    public User updateUser(Long id, User userDetail) {
        User user = userRepo.findById(id).orElseThrow();
        if (userDetail.getUsername() != null) {
            user.setUsername(userDetail.getUsername());
        }
        if (userDetail.getPassword() != null) {
            user.setPassword(passwordEncoder(userDetail.getPassword()));
        }
        if (userDetail.getEmail() != null) {
            user.setEmail(userDetail.getEmail());
        }
        if (userDetail.getType() != null) {
            user.setType(userDetail.getType());
        }
        if (userDetail.getTel() != null) {
            user.setTel(userDetail.getTel());
        }
        return userRepo.save(user);
    }

    public User addRoomToUser(Long userId, String roomNumber) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Room room = roomRepo.findById(roomNumber)
                .orElseThrow(() -> new RuntimeException("Room not found"));

        user.getRoomService().add(room);
        return userRepo.save(user);
    }

    public User removeRoomFromUser(Long userId, String roomNumber) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Room room = roomRepo.findById(roomNumber)
                .orElseThrow(() -> new RuntimeException("Room not found"));

        user.getRoomService().remove(room);
        return userRepo.save(user);
    }

    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    public String passwordEncoder(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    public User login(String username, String password) {
        Optional<User> user = userRepo.findByUsername(username);

        if (user.isPresent()) {
            User userData = user.get();
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            if (encoder.matches(password, userData.getPassword())) {
                return userData;
            }
        }
        return null;
    }
}
