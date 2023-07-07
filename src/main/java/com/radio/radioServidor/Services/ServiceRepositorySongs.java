package com.radio.radioServidor.Services;

import com.radio.radioServidor.Entities.Songs.DataRequestSong;
import com.radio.radioServidor.Entities.Songs.DataUpdateSong;
import com.radio.radioServidor.Entities.Songs.SongEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServiceRepositorySongs<T> {

    public ResponseEntity<List<T>> findAll();
    public ResponseEntity<List<T>> findGender(String genero);
    public ResponseEntity<List<T>> findBySearch(String busqueda);
    public ResponseEntity createSong(SongEntity songEntity);
    public ResponseEntity updateSong(Long id, DataUpdateSong dataUpdateSong);
}
