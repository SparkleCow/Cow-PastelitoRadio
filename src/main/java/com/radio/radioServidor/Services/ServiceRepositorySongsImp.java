package com.radio.radioServidor.Services;

import com.radio.radioServidor.Entities.Songs.DataResponseSong;
import com.radio.radioServidor.Entities.Songs.SongEntity;
import com.radio.radioServidor.Repository.SongsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceRepositorySongsImp implements ServiceRepositorySongs<DataResponseSong> {

    private SongsRepository repository;

    public ServiceRepositorySongsImp(SongsRepository repository){
        this.repository = repository;
    }
    @Override
    public ResponseEntity<List<DataResponseSong>> findAll() {
        List<SongEntity> lista = repository.findAll();
        ArrayList<DataResponseSong> array = new ArrayList<>();
        lista.forEach(x -> array.add(new DataResponseSong(x.getId(), x.getNombreArtista(), x.getNombreCancion(),x.getUrlImagen(),
                x.getUrlCancion(), x.getGenero())));
        return ResponseEntity.ok(array);
    }

    @Override
    public DataResponseSong findOne() {
        return null;
    }

    @Override
    public void deleteOne() {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void update() {

    }

    @Override
    public void create() {

    }
}
