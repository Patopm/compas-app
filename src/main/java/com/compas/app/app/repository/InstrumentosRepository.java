package com.compas.app.app.repository;

import com.compas.app.model.Instrumentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstrumentosRepository extends JpaRepository<Instrumentos, Long> {

    @Query("SELECT d FROM Instrumentos d WHERE d.instrumento = ?1")
    Optional<Instrumentos> findByInstrumento(String instrumento);

}
