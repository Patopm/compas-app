package com.compas.app.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "instrumentos")
public class Instrumentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "instrumento", nullable = false, length = 50, unique = true)
    private String instrumento;

    @Column(name = "created_at", nullable = false, length = 50, updatable = false, insertable = false)
    private LocalDateTime created_at;

    @Column(name = "updated_at", nullable = false, length = 50)
    private LocalDateTime updated_at;

    @ManyToMany (mappedBy = "id_instrumento")
    private List<Artistas> artistaId;

    @PrePersist
    protected void onCreate(){
        this.created_at = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updated_at = LocalDateTime.now();
    }

    public Instrumentos() {
    }

    public Instrumentos(String instrumento, LocalDateTime created_at, LocalDateTime updated_at) {
        this.instrumento = instrumento;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.artistaId = artistaId;
    }

    public Instrumentos(Long id, String instrumento, LocalDateTime created_at, LocalDateTime updated_at) {
        this.id = id;
        this.instrumento = instrumento;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.artistaId = artistaId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(String instrumento) {
        this.instrumento = instrumento;
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

    public List<Artistas> getArtistaId() {
        return artistaId;
    }

    public void setArtistaId(List<Artistas> artistaId) {
        this.artistaId = artistaId;
    }

    @Override
    public String toString() {
        return "Instrumentos{" +
                "id=" + id +
                ", instrumento='" + instrumento + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", artistaId=" + artistaId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instrumentos that = (Instrumentos) o;
        return Objects.equals(id, that.id) && Objects.equals(instrumento, that.instrumento) && Objects.equals(created_at, that.created_at) && Objects.equals(updated_at, that.updated_at) && Objects.equals(artistaId, that.artistaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, instrumento, created_at, updated_at, artistaId);
    }
}
