package com.badminton.slot.booking.controller;


import com.badminton.slot.booking.model.Slot;
import com.badminton.slot.booking.service.SlotService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/admin")
@Tag(name = "Admin Controller", description = "API for Admin")
public class AdminController {

    @Autowired
    private SlotService slotService;

    @PostMapping("/slots")
    @Operation(summary = "addSlot", description = "Add new slots")
    public ResponseEntity<?> addSlot(@RequestBody Slot slot) {
        return slotService.addSlot(slot);
    }

    @PutMapping("/slots/{slotId}")
    @Operation(summary = "editSlot", description = "Edit existing slot")
    public ResponseEntity<?> editSlot(@PathVariable String slotId, @RequestBody Slot slot) {
        return slotService.editSlot(slotId, slot);
    }

    @DeleteMapping("/slots/{slotId}")
    @Operation(summary = "deleteSlot", description = "Delete slot from list")
    public ResponseEntity<?> deleteSlot(@PathVariable String slotId) {
        return slotService.deleteSlot(slotId);
    }

    @GetMapping("/bookings")
    @Operation(summary = "getAllBookings", description = "Retrieve a list of all bookings")
    public ResponseEntity<?> getAllBookings() {
        return slotService.getAllBookings();
    }
}
