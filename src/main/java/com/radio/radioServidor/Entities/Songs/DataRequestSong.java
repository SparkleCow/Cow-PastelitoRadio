package com.radio.radioServidor.Entities.Songs;

import jakarta.validation.constraints.NotBlank;

public record DataRequestSong(
        @NotBlank
        String nombreArtista,
        @NotBlank
        String nombreCancion,
        @NotBlank
        String urlImagen,
        @NotBlank
        String urlCancion,
        @NotBlank
        String genero) {
}
