package com.compas.app.repository;

import com.compas.app.model.Demos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DemosRepository extends JpaRepository<Demos, Long> {
    @Query("SELECT d FROM Demos d WHERE d.titulo = ?1")
    Optional<Demos> findDemosByTitulo(String titulo);
}
