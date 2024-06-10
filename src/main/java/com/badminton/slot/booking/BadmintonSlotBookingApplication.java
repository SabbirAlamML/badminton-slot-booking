package com.badminton.slot.booking;

import com.badminton.slot.booking.model.Slot;
import com.badminton.slot.booking.model.Users;
import com.badminton.slot.booking.repository.SlotRepository;
import com.badminton.slot.booking.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BadmintonSlotBookingApplication {

    public static void main(String[] args) {
        System.out.println("Hello form Slot Booking App");
        SpringApplication.run(BadmintonSlotBookingApplication.class, args);
    }
    @Bean
    public CommandLineRunner demo(UserRepository repository) {
        return (args) -> {
            // save a few employees
            repository.save(new Users((long)1,"John Doe", "john@gmail.com","abcd","+65 96968989"));
            repository.save(new Users((long)2,"Jane Hai","jane@gmail.com","efgh","+65 96963245"));
            repository.save(new Users((long)3,"Jim Wee","jim@hotmail.com","ijkl","+65 96965436"));
        };
    }

    @Bean
    public CommandLineRunner demo1(SlotRepository repository) {
        return (args) -> {
            // save a few Slots
            repository.save(new Slot((long)1,"SBH","A1","20-July-2024","9AM","10AM"));
            repository.save(new Slot((long)2,"SBH","A2","20-July-2024","10AM","11AM"));
            repository.save(new Slot((long)3,"OTH","B2","20-July-2024","9AM","10AM"));

        };
    }

}
