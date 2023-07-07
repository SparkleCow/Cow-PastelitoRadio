package com.radio.radioServidor.Entities.Songs;

import jakarta.validation.constraints.NotBlank;

public record DataUpdateSong(
        String nombreArtista,
        String nombreCancion,
        String urlImagen,
        String urlCancion,
        String genero) {
}
