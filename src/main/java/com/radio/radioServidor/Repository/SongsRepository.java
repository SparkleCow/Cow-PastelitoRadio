package com.radio.radioServidor.Repository;

import com.radio.radioServidor.Entities.Songs.SongEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongsRepository extends JpaRepository<SongEntity, Long> {
}
