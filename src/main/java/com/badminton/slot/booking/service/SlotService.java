package com.badminton.slot.booking.service;


import com.badminton.slot.booking.model.Slot;
import com.badminton.slot.booking.repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



@Service
public class SlotService {

    @Autowired
    private SlotRepository slotRepository;

    public ResponseEntity<?> addSlot(Slot slot) {
        slotRepository.save(slot);
        return ResponseEntity.ok("Slot added successfully");
    }

    public ResponseEntity<?> editSlot(String slotId, Slot slot) {
        // Edit slot logic
        return ResponseEntity.ok("Slot updated successfully");
    }

    public ResponseEntity<?> deleteSlot(String slotId) {
        slotRepository.deleteById(Long.parseLong(slotId));
        return ResponseEntity.ok("Slot deleted successfully");
    }

    public ResponseEntity<?> getAllBookings() {
        // Fetch all bookings
        slotRepository.findAll();
        return ResponseEntity.ok(slotRepository.findAll());
    }
}
