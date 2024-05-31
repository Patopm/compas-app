package com.compas.app.app.controller;

import com.compas.app.model.Artistas;
import com.compas.app.service.ArtistasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/artistas")
public class ArtistasController {
    private final ArtistasService artistasService;

    @Autowired
    private ArtistasController(ArtistasService artistasService) {
        this.artistasService = artistasService;
    }

    @GetMapping
    public List<Artistas> getAllArtistas(){
        return artistasService.getAllArtistas();
    }

    @PostMapping(path = "/add-artista")
    public void addNewArtista(@RequestBody Artistas artistas){
        artistas.setCreated_at(LocalDateTime.now());
        artistas.setUpdated_at(LocalDateTime.now());
        artistasService.addNewArtista(artistas);
    }

    @DeleteMapping(path = "/{id_artista}")
    public void deleteArtista(@PathVariable("id_artista") Long id_artista){
        artistasService.deleteArtista(id_artista);
    }

    @PutMapping(path = "/{id_artista}")
    public void updateArtista(@PathVariable("id_artista") Long id_artista,
                              @RequestBody(required = false) Artistas acerca_de){
        artistasService.updateArtista(id_artista, acerca_de.getAcerca_de());
    }
}
