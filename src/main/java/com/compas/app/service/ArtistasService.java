package com.compas.app.service;

import com.compas.app.exceptions.ArtistaNotFoundException;
import com.compas.app.model.Artistas;
import com.compas.app.repository.ArtistasRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class ArtistasService {
    private final ArtistasRepository artistasRepository;

    @Autowired
    public ArtistasService(ArtistasRepository artistasRepository) {
        this.artistasRepository = artistasRepository;
    }

    public List<Artistas> getAllArtistas() {
        return artistasRepository.findAll();
    }

    public void addNewArtista(Artistas artistas) {
        artistasRepository.save(artistas);
    }

    public void deleteArtista(Long idArtista) {
        if(artistasRepository.existsById(idArtista)){
            throw new ArtistaNotFoundException(idArtista);
        }
        artistasRepository.deleteById(idArtista);
    }

    @Transactional
    public void updateArtista(Long id_Artista, String acercaDe) {
        Artistas artista = artistasRepository.findArtistaByArtistaId(id_Artista)
                .orElseThrow(() -> new ArtistaNotFoundException(id_Artista));
        if (acercaDe == null && !acercaDe.isEmpty() && Objects.equals(artista.getAcerca_de(), acercaDe)) {
            throw new IllegalStateException("el cambio es el mismo");
        }
        artista.setAcerca_de(acercaDe);
        artista.setUpdated_at(LocalDateTime.now());

    }
}
