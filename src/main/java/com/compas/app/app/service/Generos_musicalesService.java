package com.compas.app.app.service;

import com.compas.app.exceptions.Genero_musicalNotFoundException;
import com.compas.app.exceptions.Genero_musicalidNotFoundException;
import com.compas.app.model.Generos_musicales;
import com.compas.app.repository.Generos_musicalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class Generos_musicalesService {

    private final Generos_musicalesRepository generos_musicalesRepository;

    @Autowired
    public Generos_musicalesService(Generos_musicalesRepository generos_musicalesRepository){
        this.generos_musicalesRepository = generos_musicalesRepository;
    }

    // Método GET
    public List<Generos_musicales> getALLGeneros_musicales(){
        return generos_musicalesRepository.findAll();
    }

    // Método GET por id
    public Generos_musicales getGenero_musicalById(Long id){ // Buscar solo por id
        return generos_musicalesRepository.findById(id).orElseThrow(() -> new Genero_musicalidNotFoundException(id));
    }

    // Método GET por nombre Genero musical
    public Generos_musicales getGenero_musicalByName(String genero_musical){ // Buscar solo por nombre
        return generos_musicalesRepository.findByGeneroMusical(genero_musical).orElseThrow(() -> new Genero_musicalNotFoundException(genero_musical));
    }

    // Método POST
    public void addNewGenero_musical(Generos_musicales generoMusical){
        Optional<Generos_musicales> generoMusicalOptional = generos_musicalesRepository.findByGeneroMusical(generoMusical.getGenero_musical());
        if(generoMusicalOptional.isPresent()) {
            throw new Genero_musicalNotFoundException("Genero musical" + generoMusical.getGenero_musical() + "Ya existe");
        }
        generos_musicalesRepository.save(generoMusical);
    }

    // Método DELETE
    public void deleteGenero_musical(Long id){
        boolean exists = generos_musicalesRepository.existsById(id);
                if(!exists){
                    throw new Genero_musicalidNotFoundException(id);
                }
                generos_musicalesRepository.deleteById(id);
    }

    // Método PUT
    public void upDateGenero_musical(Long id, Generos_musicales upDateGenero_musical){
        Generos_musicales genero_musical = generos_musicalesRepository.findById(id).orElseThrow(() -> new Genero_musicalidNotFoundException(id));
    if (upDateGenero_musical != null && upDateGenero_musical.getGenero_musical().length() > 0 && !Objects.equals(genero_musical.getGenero_musical(), upDateGenero_musical.getGenero_musical())){
        genero_musical.setGenero_musical(upDateGenero_musical.getGenero_musical());
    }
        upDateGenero_musical.setUpdated_at(LocalDateTime.now());
    }
}

