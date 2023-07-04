package com.radio.radioServidor.Controllers;

import com.radio.radioServidor.Entities.Songs.DataRequestSongGender;
import com.radio.radioServidor.Entities.Songs.DataResponseSong;
import com.radio.radioServidor.Services.ServiceRepositorySongs;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/api/songs/gender")
    public ResponseEntity<List<DataResponseSong>> findByGender(@RequestBody DataRequestSongGender dataRequestSongGender){
        return repositoryImp.findGender(dataRequestSongGender.genero());
    }
}
