package com.compas.app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "demos")
public class Demos {
    //id_demo, titulo, fecha_de_lanzamiento, link, created_at, updated_at, usuarios_id_usuario, generos_musicales_id_genero_musical
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_demo")
    private Long id_demo;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "fecha_de_lanzamiento", nullable = false)
    private String fecha_de_lanzamiento;

    @Column(name = "link", nullable = false)
    private String link;

    @Column(name = "created_at", updatable = false, insertable = false)
    private LocalDateTime created_at;

    @Column(name = "updated_at", insertable = false)
    private LocalDateTime updated_at;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="artistaId", nullable = false)
    @JsonBackReference
    private Artistas artista_id;

    private Long genero_musical_id;

    //@OneToOne
    //private Usuario usuario_id;

    //@OneToOne
    //private int genero_musical_id;

    public Demos() {
    }


    @JsonCreator
    public Demos(@JsonProperty Artistas artista_id) {
        this.artista_id = artista_id;
    }

    public Demos(Long id_demo, String titulo, String fecha_de_lanzamiento, String link, LocalDateTime created_at, LocalDateTime updated_at, Artistas artista_id, Long genero_musical_id) {

        this.id_demo = id_demo;
        this.titulo = titulo;
        this.fecha_de_lanzamiento = fecha_de_lanzamiento;
        this.link = link;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.artista_id = artista_id;
        this.genero_musical_id = genero_musical_id;
    }

    public Demos(String titulo, String fecha_de_lanzamiento, String link, LocalDateTime created_at, LocalDateTime updated_at, Artistas artista_id, Long genero_musical_id) {
        this.titulo = titulo;
        this.fecha_de_lanzamiento = fecha_de_lanzamiento;
        this.link = link;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.artista_id = artista_id;
        this.genero_musical_id = genero_musical_id;
    }

    public Long getId_demo() {
        return id_demo;
    }

    public void setId_demo(Long id_demo) {
        this.id_demo = id_demo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha_de_lanzamiento() {
        return fecha_de_lanzamiento;
    }

    public void setFecha_de_lanzamiento(String fecha_de_lanzamiento) {
        this.fecha_de_lanzamiento = fecha_de_lanzamiento;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public Artistas getArtista_id() {
        return artista_id;
    }

    public void setArtista_id(Artistas artista_id) {
        this.artista_id = artista_id;
    }

    public Long getGenero_musical_id() {
        return genero_musical_id;
    }

    public void setGenero_musical_id(Long genero_musical_id) {
        this.genero_musical_id = genero_musical_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Demos demos = (Demos) o;
        return Objects.equals(id_demo, demos.id_demo) && Objects.equals(titulo, demos.titulo) && Objects.equals(fecha_de_lanzamiento, demos.fecha_de_lanzamiento) && Objects.equals(link, demos.link) && Objects.equals(created_at, demos.created_at) && Objects.equals(updated_at, demos.updated_at) && Objects.equals(artista_id, demos.artista_id) && Objects.equals(genero_musical_id, demos.genero_musical_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_demo, titulo, fecha_de_lanzamiento, link, created_at, updated_at, artista_id, genero_musical_id);
    }

    @Override
    public String toString() {
        return "Demos{" +
                "id_demo=" + id_demo +
                ", titulo='" + titulo + '\'' +
                ", fecha_de_lanzamiento='" + fecha_de_lanzamiento + '\'' +
                ", link='" + link + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", artista_id=" + artista_id +
                ", genero_musical_id=" + genero_musical_id +
                '}';
    }
}
