package com.radio.radioServidor.Entities.Users;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DataRequestUser(
        @NotBlank
        @Size(max = 30)
        String username,
        @NotBlank
        @Size(max = 80)
        @Email
        String email,
        @NotBlank
        String password) {
}
