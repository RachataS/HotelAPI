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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.Hotel.model.User;
import com.api.Hotel.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserBuId(id);
    }

    @GetMapping("/by-type")
    public List<User> getUserByType(@RequestParam String type) {
        return userService.getUserByType(type);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userDetail) {
        return userService.updateUser(id, userDetail);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        if (user.getUsername() == null || user.getPassword() == null) {
            throw new IllegalArgumentException("Username and password are required");
        }
        return userService.login(user.getUsername(), user.getPassword());
    }

    @PutMapping("/{userId}/add-room/{roomNumber}")
    public User addRoomToUser(@PathVariable Long userId, @PathVariable String roomNumber) {
        return userService.addRoomToUser(userId, roomNumber);
    }

    @PutMapping("/{userId}/remove-room/{roomNumber}")
    public User removeRoomFromUser(@PathVariable Long userId, @PathVariable String roomNumber) {
        return userService.removeRoomFromUser(userId, roomNumber);
    }
}
