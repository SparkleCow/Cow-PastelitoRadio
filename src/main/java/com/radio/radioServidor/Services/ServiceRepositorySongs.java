package com.radio.radioServidor.Services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServiceRepositorySongs<T> {

    public ResponseEntity<List<T>> findAll();
    public T findOne();
    public void deleteOne();
    public void deleteAll();
    public void update();
    public void create();
}
