
package com.badminton.slot.booking.service;

import com.badminton.slot.booking.exchanges.UserUpdateRequest;
import com.badminton.slot.booking.model.Users;
import com.badminton.slot.booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<?> getProfile() {

        List<Users> users = userRepository.findAll();
        if (users == null) {
            try {
                throw new Exception("User not found");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return ResponseEntity.ok(users);
    }

    public ResponseEntity<?> updateProfile(UserUpdateRequest userDetails) {
        Users user = userRepository.findByEmail(userDetails.getEmail());
        if (user == null) {
            try {
                throw new Exception("User not found");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        user.setName(userDetails.getName());
        user.setPhone(userDetails.getPhone());
        userRepository.save(user);
        return ResponseEntity.ok("Profile updated successfully");
    }
}

