package com.radio.radioServidor.Services;

import com.radio.radioServidor.Entities.Songs.DataResponseSong;
import com.radio.radioServidor.Entities.Songs.SongEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServiceRepository<T> {

    public ResponseEntity<List<T>> findAll();
    public T findOne();
    public void deleteOne();
    public void deleteAll();
    public void update();
    public void create();
}
