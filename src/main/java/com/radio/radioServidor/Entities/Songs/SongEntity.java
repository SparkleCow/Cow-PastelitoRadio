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
    @Column(name = "url_imagen")
    public String urlImagen;
    @Column(name = "url_cancion")
    public String urlCancion;
    @Column(name = "nombre_artista")
    public String nombreArtista;
    @Column(name = "nombre_cancion")
    public String nombreCancion;
    public String genero;

    public SongEntity(String url, String nombreArtista, String nombreCancion, String genero) {
        this.urlImagen = url;
        this.nombreArtista = nombreArtista;
        this.nombreCancion = nombreCancion;
        this.genero = genero;
    }

    /*Método para actualizar la entidad Song a través de un DTO */
    public void update(DataUpdateSong dataUpdateSong){
        if(dataUpdateSong.nombreArtista()!=null && !dataUpdateSong.nombreArtista().equals("")){
            this.nombreArtista = dataUpdateSong.nombreArtista();
        }
        if(dataUpdateSong.nombreCancion()!=null && !dataUpdateSong.nombreCancion().equals("")){
            this.nombreCancion = dataUpdateSong.nombreCancion();
        }
        if(dataUpdateSong.urlCancion()!=null && !dataUpdateSong.urlCancion().equals("")){
            this.urlCancion = dataUpdateSong.urlCancion();
        }
        if(dataUpdateSong.urlImagen()!=null && !dataUpdateSong.urlImagen().equals("")){
            this.urlImagen = dataUpdateSong.urlImagen();
        }
        if(dataUpdateSong.genero()!=null && !dataUpdateSong.genero().equals("")){
            this.genero = dataUpdateSong.genero();
        }
    }
}
