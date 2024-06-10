package com.badminton.slot.booking.controller;

import com.badminton.slot.booking.exchanges.UserUpdateRequest;
import com.badminton.slot.booking.model.Users;
import com.badminton.slot.booking.repository.UserRepository;
import com.badminton.slot.booking.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
@Tag(name = "User Controller", description =  "User API" )
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    @Operation(summary = "getProfile", description = "Retrieve a profile")
    public ResponseEntity<?> getProfile() throws Exception {
        return userService.getProfile();
    }

    @PutMapping("/profile")
    @Operation(summary = "updateProfile", description = "Update profile")
    public ResponseEntity<?> updateProfile(@RequestBody UserUpdateRequest user) {
        return userService.updateProfile(user);
    }

    @GetMapping("/hello")
    public String sayHello() {

        try {
            System.out.println("GET /hello from springboot called");
            // Your code here
        } catch (Exception e) {
            System.out.println("An error occurred: " +e);
        }
        return "Hello from badminton-slot-booking.";
    }
}
