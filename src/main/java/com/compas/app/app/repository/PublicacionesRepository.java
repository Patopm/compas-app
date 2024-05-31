package com.compas.app.app.repository;

import com.compas.app.model.Publicaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PublicacionesRepository extends JpaRepository<Publicaciones, Long> {
    @Query("SELECT p FROM Publicaciones p where p.idPublicacion = ?1")
    Optional<Publicaciones> findPubliacionById(Long id);
}
