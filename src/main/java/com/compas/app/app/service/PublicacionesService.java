package com.compas.app.app.service;

import com.compas.app.exceptions.PublicacionNotFoundException;
import com.compas.app.exceptions.UsuarioNotFoundException;
import com.compas.app.model.Publicaciones;
import com.compas.app.model.Usuario;
import com.compas.app.repository.PublicacionesRepository;
import com.compas.app.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublicacionesService {
    private final PublicacionesRepository publicacionesRepository;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public PublicacionesService(PublicacionesRepository publicacionesRepository, UsuarioRepository usuarioRepository) {
        this.publicacionesRepository = publicacionesRepository;
        this.usuarioRepository = usuarioRepository;
    }

    //Métodos para get
    public List<Publicaciones> getAllPublicaciones() {
        return publicacionesRepository.findAll();
    }

    public Publicaciones getPublicacionById(Long id) {
        return publicacionesRepository.findPubliacionById(id)
                .orElseThrow(() -> new PublicacionNotFoundException(id));
    }

    //Métodos para post
    public void addNewPublicacion(Publicaciones publicaciones, Usuario usuario) {
        publicaciones.setUsuario(usuario);
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuario.getId_usuario());
        if(!usuarioOptional.isPresent()) {
            throw new UsuarioNotFoundException(usuario.getId_usuario());
        }

        publicacionesRepository.save(publicaciones);
    }

    public Optional<Publicaciones> findById (Long id){
        return publicacionesRepository.findById(id);
    }

    public Publicaciones save (Publicaciones publicacion){
        return publicacionesRepository.save(publicacion);
    }

    public void deletePublicacionById (Long id){
        publicacionesRepository.deleteById(id);
    }
}
