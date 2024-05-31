package com.compas.app.service;

import com.compas.app.exceptions.PublicacionNotFoundException;
import com.compas.app.model.Publicaciones;
import com.compas.app.repository.PublicacionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicacionesService {
    private final PublicacionesRepository publicacionesRepository;

    @Autowired
    public PublicacionesService(PublicacionesRepository publicacionesRepository) {
        this.publicacionesRepository = publicacionesRepository;
    }

    //Métodos para get
    public List<Publicaciones> getAllPublicaciones() {
        return publicacionesRepository.findAll();
    }
    public Publicaciones getPublicacionById(Long id){
        return publicacionesRepository.findPubliacionById(id)
                .orElseThrow(()-> new PublicacionNotFoundException(id));
    }

    //Métodos para post
    /*public void addNewPublicacion(Publicaciones publicaciones){
        Optional<Publicaciones> publicacionesOptional = publicacionesRepository.findPubliacionById(publicaciones.getIdPublicacion());
        if(publicacionesOptional.isPresent()){
            throw new IllegalStateException("id " + publicaciones.getIdPublicacion() + "Ya se realizó esta publicacion");
        }
        publicacionesRepository.save(publicaciones);
    }

    public Optional<Publicaciones> findById(Long id) {
        return publicacionesRepository.findById(id);
    }

    public Publicaciones save(Publicaciones publicacion) {
        return publicacionesRepository.save(publicacion);
    }

    public void deleteById(Long id) {
        publicacionesRepository.deleteById(id);
    }*/
}
