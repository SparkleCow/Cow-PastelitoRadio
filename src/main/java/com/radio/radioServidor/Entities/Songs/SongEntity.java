package com.radio.radioServidor.Entities.Songs;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Table(name = "songs" )
@NoArgsConstructor
@AllArgsConstructor
@ToString @EqualsAndHashCode
@Setter @Getter
public class SongEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String urlImagen;
    public String urlCancion;
    public String nombreArtista;
    public String nombreCancion;
    public String genero;

    public SongEntity(String url, String nombreArtista, String nombreCancion, String genero) {
        this.urlImagen = url;
        this.nombreArtista = nombreArtista;
        this.nombreCancion = nombreCancion;
        this.genero = genero;
    }
}
