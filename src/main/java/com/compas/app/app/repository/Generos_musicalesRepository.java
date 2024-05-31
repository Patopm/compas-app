package com.compas.app.app.repository;

import com.compas.app.model.Generos_musicales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Generos_musicalesRepository extends JpaRepository<Generos_musicales, Long> {

    @Query("SELECT d FROM Generos_musicales d WHERE d.genero_musical = ?1")
    Optional<Generos_musicales> findByGeneroMusical(String genero_musical);

}
