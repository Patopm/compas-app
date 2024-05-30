package com.compas.app.service;

import com.compas.app.model.Comentarios;
import com.compas.app.repository.ComentariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComentariosService {
    @Autowired
    private ComentariosRepository comentarioRepository;

    public List<Comentarios> findAll() {
        return comentarioRepository.findAll();
    }

    public Optional<Comentarios> findById(Long id) {
        return comentarioRepository.findById(id);
    }

    public Comentarios save(Comentarios comentario) {
        return comentarioRepository.save(comentario);
    }

    public void deleteById(Long id) {
        comentarioRepository.deleteById(id);
    }
}
