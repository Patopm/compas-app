package com.compas.app.service;

import com.compas.app.model.Publicaciones;
import com.compas.app.repository.PublicacionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublicacionesService {

    @Autowired
    private PublicacionesRepository publicacionesRepository;

    public List<Publicaciones> findAll() {
        return publicacionesRepository.findAll();
    }

    public Optional<Publicaciones> findById(Long id) {
        return publicacionesRepository.findById(id);
    }

    public Publicaciones save(Publicaciones publicacion) {
        return publicacionesRepository.save(publicacion);
    }

    public void deleteById(Long id) {
        publicacionesRepository.deleteById(id);
    }
}
