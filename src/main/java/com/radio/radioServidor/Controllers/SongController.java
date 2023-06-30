package com.radio.radioServidor.Controllers;

import com.radio.radioServidor.Entities.Songs.DataResponseSong;
import com.radio.radioServidor.Services.ServiceRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SongController {

    private ServiceRepository repositoryImp;

    public SongController(ServiceRepository repositoryImp){
        this.repositoryImp = repositoryImp;
    }

    @GetMapping("/api/songs")
    public ResponseEntity<List<DataResponseSong>> findAll(){
        return repositoryImp.findAll();
    }
}
