package com.badminton.slot.booking.controller;


import com.badminton.slot.booking.exchanges.BookingRequest;
import com.badminton.slot.booking.service.BookingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api")
@Tag(name = "Booking Controller", description =  "Booking API" )
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/slots")
    @Operation(summary = "getAvailableSlots", description = "Retrieve a list of all available slots")
    public ResponseEntity<?> getAvailableSlots(@RequestParam String date) {
        return bookingService.getAvailableSlots(date);
    }

    @PostMapping("/book")
    @Operation(summary = "bookSlot", description = "Book Slots")
    public ResponseEntity<?> bookSlot(@RequestBody BookingRequest bookingRequest) {
        return bookingService.bookSlot(bookingRequest);
    }

    @GetMapping("/bookings")
    @Operation(summary = "getBookingHistory", description = "Retrieve a list of all booking history")
    public ResponseEntity<?> getBookingHistory() {
        return bookingService.getBookingHistory();
    }

}

