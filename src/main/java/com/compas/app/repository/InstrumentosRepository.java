package com.compas.app.repository;


import com.compas.app.model.Instrumentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstrumentosRepository extends JpaRepository<Instrumentos, Long> {



}
