package com.compas.app.service;

import com.compas.app.model.Artistas;
import com.compas.app.model.Demos;
import com.compas.app.repository.DemosRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
@Service
public class DemosService {
    private final DemosRepository demosRepository;

    public DemosService(DemosRepository demosRepository){ this.demosRepository = demosRepository;}

    public List<Demos> getAllDemos(){
        return demosRepository.findAll();
    }

    public Demos addNewDemo(Demos demos) {
        demos.setCreated_at(LocalDateTime.now());
        demos.setUpdated_at(LocalDateTime.now());
        demosRepository.save(demos);
        return demos;
    }

    public void deleteDemo(Long id_demo) {
        boolean exists = demosRepository.existsById(id_demo);
        if (!exists){
            throw new IllegalStateException("demo with id" + id_demo + " does not exist");
        }
        demosRepository.deleteById(id_demo);
    }

    @Transactional
    public void updateDemo(Long idDemo,
                           String titulo,
                           String fechaLanzamiento,
                           String link,
                           Artistas artistaId,
                           Long genero_musical_id
    ){
        Demos demos = demosRepository.findById(idDemo)
                .orElseThrow(() -> new IllegalStateException("demo with id " + idDemo + " does not exist"));
        if (titulo != null && titulo.length() > 0 && !Objects.equals(demos.getTitulo(), titulo)){
            demos.setTitulo(titulo);
        }
        if (fechaLanzamiento != null && !Objects.equals(demos.getFecha_de_lanzamiento(), fechaLanzamiento)){
            demos.setFecha_de_lanzamiento(fechaLanzamiento);
        }
        if (link != null && link.length() > 0 && !Objects.equals(demos.getLink(), link)){
            demos.setLink(link);
        }
        if (artistaId != null && !Objects.equals(demos.getArtista_id(), artistaId)){
            demos.setArtista_id(artistaId);
        }
        if (genero_musical_id != null && !Objects.equals(demos.getGenero_musical_id(), genero_musical_id)){
            demos.setGenero_musical_id(genero_musical_id);
        }
    }


}
