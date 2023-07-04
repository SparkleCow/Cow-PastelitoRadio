package com.radio.radioServidor.Repository;

import com.radio.radioServidor.Entities.Songs.SongEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface SongsRepository extends JpaRepository<SongEntity, Long> {
    List<SongEntity> findByGeneroContaining(String genero);

    @Query("SELECT s FROM SongEntity s WHERE s.nombreArtista LIKE %:busqueda% OR s.nombreCancion LIKE %:busqueda%")
    List<SongEntity> findBySearch(@Param("busqueda") String busqueda);
}
