package com.radio.radioServidor.Entities.Users;

import lombok.Data;

@Data
public class AuthResponse {
    public String token;
    public String typeToken = "Bearer ";

    public AuthResponse(String token) {
        this.token = token;
    }
}
