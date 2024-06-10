package com.badminton.slot.booking.repository;

import com.badminton.slot.booking.model.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlotRepository extends JpaRepository<Slot, Long> {
    // Additional query methods if needed
}