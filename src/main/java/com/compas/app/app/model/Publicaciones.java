package com.compas.app.app.model;

import com.compas.app.model.Comentarios;
import com.compas.app.model.Usuario;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "publicaciones")
public class Publicaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_publicacion")
    private Long idPublicacion;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Lob
    @Column(name = "multimedia", columnDefinition = "MEDIUMBLOB")
    private byte[] multimedia;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "publicacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<com.compas.app.model.Comentarios> comentarios;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    @JsonBackReference
    private com.compas.app.model.Usuario usuario;

    public Publicaciones() {
    }

    public Publicaciones(String titulo, String descripcion, byte[] multimedia, LocalDateTime createdAt, LocalDateTime updatedAt, List<com.compas.app.model.Comentarios> comentarios, com.compas.app.model.Usuario usuario) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.multimedia = multimedia;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.comentarios = comentarios;
        this.usuario = usuario;
    }

    public Publicaciones(Long idPublicacion, String titulo, String descripcion, byte[] multimedia, LocalDateTime createdAt, LocalDateTime updatedAt, List<com.compas.app.model.Comentarios> comentarios, com.compas.app.model.Usuario usuario) {
        this.idPublicacion = idPublicacion;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.multimedia = multimedia;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.comentarios = comentarios;
        this.usuario = usuario;
    }

    public Long getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(Long idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public byte[] getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(byte[] multimedia) {
        this.multimedia = multimedia;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<com.compas.app.model.Comentarios> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentarios> comentarios) {
        this.comentarios = comentarios;
    }

    public com.compas.app.model.Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publicaciones that = (Publicaciones) o;
        return Objects.equals(idPublicacion, that.idPublicacion) && Objects.equals(titulo, that.titulo) && Objects.equals(descripcion, that.descripcion) && Objects.deepEquals(multimedia, that.multimedia) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt) && Objects.equals(comentarios, that.comentarios) && Objects.equals(usuario, that.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPublicacion, titulo, descripcion, Arrays.hashCode(multimedia), createdAt, updatedAt, comentarios, usuario);
    }

    @Override
    public String toString() {
        return "Publicaciones{" +
                "idPublicacion=" + idPublicacion +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", multimedia=" + Arrays.toString(multimedia) +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", comentarios=" + comentarios +
                ", usuario=" + usuario +
                '}';
    }
}
