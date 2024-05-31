package com.compas.app.app.repository;

import com.compas.app.model.MeEntona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MeEntonaRepository extends JpaRepository<MeEntona,Long>{
    @Query("SELECT m FROM MeEntona m WHERE m.id_me_entona =?1")
    Optional<MeEntona> findMeEntonaByIdMeEntona(Long id);
}
