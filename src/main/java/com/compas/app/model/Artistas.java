package com.compas.app.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "artistas")
public class Artistas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_artista")
    private Long id_artista;

    @Column(name = "acerca_de")
    private String acerca_de;

    @Column(name = "created_at")
    private LocalDate created_at;

    @Column(name = "updated_at")
    private LocalDate updated_at;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuario id_usuario;

    @OneToMany(mappedBy = "artista_id", cascade = CascadeType.ALL, orphanRemoval = true)
    // @JsonManagedReference
    private List<Demos> demo;

    public Artistas() {
    }

    public Artistas(String acerca_de, LocalDate created_at, LocalDate updated_at, Usuario id_usuario, List<Demos> demo) {
        this.acerca_de = acerca_de;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.id_usuario = id_usuario;
        this.demo = demo;
    }


    public Artistas(Long id_artista, String acerca_de, LocalDate created_at, LocalDate updated_at, Usuario id_usuario, List<Demos> demo) {
        this.id_artista = id_artista;
        this.acerca_de = acerca_de;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.id_usuario = id_usuario;
        this.demo = demo;
    }

    public Long getId_artista() {
        return id_artista;
    }

    public void setId_artista(Long id_artista) {
        this.id_artista = id_artista;

    }

    public String getAcerca_de() {
        return acerca_de;
    }

    public void setAcerca_de(String acerca_de) {
        this.acerca_de = acerca_de;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public LocalDate getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDate updated_at) {
        this.updated_at = updated_at;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    public List<Demos> getDemo() {
        return demo;
    }

    public void setDemo(List<Demos> demo) {
        this.demo = demo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artistas artistas = (Artistas) o;

        return Objects.equals(id_artista, artistas.id_artista) && Objects.equals(acerca_de, artistas.acerca_de) && Objects.equals(created_at, artistas.created_at) && Objects.equals(updated_at, artistas.updated_at) && Objects.equals(id_usuario, artistas.id_usuario) && Objects.equals(demo, artistas.demo);

    }

    @Override
    public int hashCode() {

        return Objects.hash(id_artista, acerca_de, created_at, updated_at, id_usuario, demo);

    }

    @Override
    public String toString() {
        return "Artistas{" +
                "artistaId=" + id_artista +
                ", acerca_de='" + acerca_de + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", id_usuario=" + id_usuario +
                ", demo=" + demo +
                '}';
    }
}
