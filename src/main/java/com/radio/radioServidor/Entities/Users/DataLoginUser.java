package com.radio.radioServidor.Entities.Users;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DataLoginUser(
        @NotBlank
        @Size(max = 30)
        String username,
        @NotBlank
        String password) {
}
