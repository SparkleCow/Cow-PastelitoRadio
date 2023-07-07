package com.radio.radioServidor.Services;

import com.radio.radioServidor.Entities.Songs.DataResponseSong;
import com.radio.radioServidor.Entities.Songs.DataUpdateSong;
import com.radio.radioServidor.Entities.Songs.SongEntity;
import com.radio.radioServidor.Repository.SongsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    public ResponseEntity createSong(SongEntity songEntity){
        if(songEntity==null){
            return ResponseEntity.badRequest().build();
        }
        repository.save(songEntity);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity updateSong(Long id, DataUpdateSong dataUpdateSong) {
        Optional<SongEntity> songOpt = repository.findById(id);
        if(songOpt.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        SongEntity song = songOpt.get();
        song.update(dataUpdateSong);
        repository.save(song);
        return ResponseEntity.ok().build();
    }
}
