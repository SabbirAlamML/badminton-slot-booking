package com.badminton.slot.booking.exchanges;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserUpdateRequest {
    private String name;
    private String email;
    private String password;
    private String phone;
}
