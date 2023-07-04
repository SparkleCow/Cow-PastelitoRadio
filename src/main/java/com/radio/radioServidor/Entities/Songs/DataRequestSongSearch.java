package com.radio.radioServidor.Entities.Songs;

import jakarta.validation.constraints.NotBlank;

public record DataRequestSongSearch(@NotBlank String busqueda) {
}
