package com.radio.radioServidor.Services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServiceRepositorySongs<T> {

    public ResponseEntity<List<T>> findAll();
    public ResponseEntity<List<T>> findGender(String genero);
    public ResponseEntity<List<T>> findBySearch(String busqueda);
}
