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
    public ResponseEntity<List<DataResponseSong>> findGender(String genero) {
        List<SongEntity> lista = repository.findByGeneroContaining(genero);
        ArrayList<DataResponseSong> array = new ArrayList<>();
        lista.forEach(x -> array.add(new DataResponseSong(x.getId(), x.getNombreArtista(), x.getNombreCancion(),x.getUrlImagen(),
                x.getUrlCancion(), x.getGenero())));
        return ResponseEntity.ok(array);
    }

    @Override
    public ResponseEntity<List<DataResponseSong>> findBySearch(String busqueda) {
        List<SongEntity> lista = repository.findBySearch(busqueda);
        List<DataResponseSong> array = new ArrayList<>();
        lista.forEach(x -> array.add(new DataResponseSong(x.getId(), x.getNombreArtista(), x.getNombreCancion(),x.getUrlImagen(),
                x.getUrlCancion(), x.getGenero())));
        return ResponseEntity.ok(array);
    }

}
