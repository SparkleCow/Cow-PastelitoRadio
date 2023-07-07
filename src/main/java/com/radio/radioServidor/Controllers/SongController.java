package com.radio.radioServidor.Controllers;

import com.radio.radioServidor.Entities.Songs.*;
import com.radio.radioServidor.Services.ServiceRepositorySongs;
import jakarta.validation.Valid;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.List;

/*
 *Controlador que devuelve canciones segun los criterios de busqueda.
 *Tambien permite hacer las demas operaciones CRUD en la base de datos sin embargo estas requieren
 *autenticación de JWT.
 */
@RestController
public class SongController {

    private ServiceRepositorySongs repositoryImp;

    public SongController(ServiceRepositorySongs repositoryImp){
        this.repositoryImp = repositoryImp;
    }

    @GetMapping("/api/songs")
    public ResponseEntity<List<DataResponseSong>> findAll(){
        return repositoryImp.findAll();
    }

    @PostMapping("/api/songs/gender")
    public ResponseEntity<List<DataResponseSong>> findByGender(@Valid @RequestBody DataRequestSongGender dataRequestSongGender){
        return repositoryImp.findGender(dataRequestSongGender.genero());
    }

    @PostMapping("/api/songs/search")
    public ResponseEntity<List<DataResponseSong>> findBySearch(@Valid @RequestBody DataRequestSongSearch dataRequestSongSearch){
        return repositoryImp.findBySearch(dataRequestSongSearch.busqueda());
    }

    /*Requiere autenticación*/
    @PostMapping("/api/songs/create")
    public ResponseEntity createSong(@Valid @RequestBody DataRequestSong dataRequestSong){
         return repositoryImp.createSong(SongEntity.builder()
                .id(null)
                .nombreArtista(dataRequestSong.nombreArtista())
                .nombreCancion(dataRequestSong.nombreCancion())
                .urlCancion(dataRequestSong.urlCancion())
                .urlImagen(dataRequestSong.urlImagen())
                .genero(dataRequestSong.genero())
                .build());
    }

    @PutMapping("/api/songs/update/{id}")
    public ResponseEntity updateSong(@PathVariable Long id, @RequestBody DataUpdateSong dataUpdateSong){
        return repositoryImp.updateSong(id, dataUpdateSong);
    }
}
