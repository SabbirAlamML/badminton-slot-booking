package com.badminton.slot.booking.controller;


import com.badminton.slot.booking.exchanges.AuthResponse;
import com.badminton.slot.booking.model.Users;
import com.badminton.slot.booking.service.AuthService;
import com.badminton.slot.booking.utils.JwtUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/auth")
@Tag(name = "Auth Controller", description = "Authentication API" )
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    @Operation( summary  = "Register", description = "Register new user")
    public ResponseEntity<?> register(@RequestBody Users user) {
        return authService.register(user);
    }

    @PostMapping("/login")
    @Operation(summary = "Login", description = "Login user")
    public ResponseEntity<?> login(@RequestBody Users user) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));

        final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());
        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthResponse(jwt));
    }

}