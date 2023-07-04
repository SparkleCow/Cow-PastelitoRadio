package com.radio.radioServidor.Entities.Songs;

import jakarta.validation.constraints.NotBlank;

public record DataRequestSongGender(@NotBlank String genero) {
}
