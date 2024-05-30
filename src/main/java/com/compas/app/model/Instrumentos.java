package com.compas.app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "instrumentos")
public class Instrumentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "instrumento", nullable = false, length = 50, unique = true)
    private String instrumento;

    @Column(name = "localdate", nullable = false, length = 50, updatable = false, insertable = false)
    private LocalDate created_at;
    @Column(name = "localdate", nullable = false, length = 50)
    private LocalDate updated_at;

    public Instrumentos() {
    }

    public Instrumentos(String instrumento, LocalDate created_at, LocalDate updated_at) {
        this.instrumento = instrumento;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Instrumentos(Long id, String instrumento, LocalDate created_at, LocalDate updated_at) {
        this.id = id;
        this.instrumento = instrumento;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }


    @Override
    public String toString() {
        return "Instrumentos{" +
                "id=" + id +
                ", instrumento='" + instrumento + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instrumentos that = (Instrumentos) o;
        return Objects.equals(id, that.id) && Objects.equals(instrumento, that.instrumento) && Objects.equals(created_at, that.created_at) && Objects.equals(updated_at, that.updated_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, instrumento, created_at, updated_at);
    }
}
