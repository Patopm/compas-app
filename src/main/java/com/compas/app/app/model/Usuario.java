package com.compas.app.app.model;

import com.compas.app.model.Artistas;
import com.compas.app.model.Comentarios;
import com.compas.app.model.MeEntona;
import com.compas.app.model.Publicaciones;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", updatable = false)
    private Long id_usuario;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellidos", nullable = false)
    private String apellidos;

    @Column(name = "edad", nullable = false)
    private Integer edad;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "genero", nullable = false)
    private String genero;

    @Column(name = "codigo_postal", nullable = false)
    private Integer codigoPostal;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "ciudad", nullable = false)
    private String ciudad;

    @Lob
    @Column(name = "foto_perfil", columnDefinition = "MEDIUMBLOB")
    private byte[] foto_perfil;

    @Lob
    @Column(name = "foto_portada", columnDefinition = "MEDIUMBLOB")
    private byte[] foto_portada;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime created_at;

    @Column(name = "updated_at")
    private LocalDateTime updated_at;

    @OneToOne(mappedBy = "id_usuario")
    private Artistas artistaId;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "usuarios_me_entona",
            joinColumns = @JoinColumn(name = "FK_USUARIO", nullable = false),
            inverseJoinColumns = @JoinColumn(name="FK_ME_ENTONA", nullable = false)
    )
    private List<MeEntona> meEntona;



    @PrePersist
    protected void onCreate(){
        this.created_at = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updated_at = LocalDateTime.now();
    }

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comentarios> comentarios;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Publicaciones> publicaciones;

    public Usuario() {
    }

    public Usuario(Long id_usuario, String nombre, String apellidos, Integer edad, String email, String password, String genero, Integer codigoPostal, String estado, String ciudad, byte[] foto_perfil, byte[] foto_portada, LocalDateTime created_at, LocalDateTime updated_at) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.email = email;
        this.password = password;
        this.genero = genero;
        this.codigoPostal = codigoPostal;
        this.estado = estado;
        this.ciudad = ciudad;
        this.foto_perfil = foto_perfil;
        this.foto_portada = foto_portada;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Usuario(String nombre, String apellidos, Integer edad, String email, String password, String genero, Integer codigoPostal, String estado, String ciudad, byte[] foto_perfil, byte[] foto_portada, LocalDateTime created_at, LocalDateTime updated_at) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.email = email;
        this.password = password;
        this.genero = genero;
        this.codigoPostal = codigoPostal;
        this.estado = estado;
        this.ciudad = ciudad;
        this.foto_perfil = foto_perfil;
        this.foto_portada = foto_portada;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(Integer codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public byte[] getFoto_perfil() {
        return foto_perfil;
    }

    public void setFoto_perfil(byte[] foto_perfil) {
        this.foto_perfil = foto_perfil;
    }

    public byte[] getFoto_portada() {
        return foto_portada;
    }

    public void setFoto_portada(byte[] foto_portada) {
        this.foto_portada = foto_portada;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id_usuario, usuario.id_usuario) && Objects.equals(nombre, usuario.nombre) && Objects.equals(apellidos, usuario.apellidos) && Objects.equals(edad, usuario.edad) && Objects.equals(email, usuario.email) && Objects.equals(password, usuario.password) && Objects.equals(genero, usuario.genero) && Objects.equals(codigoPostal, usuario.codigoPostal) && Objects.equals(estado, usuario.estado) && Objects.equals(ciudad, usuario.ciudad) && Objects.equals(foto_perfil, usuario.foto_perfil) && Objects.equals(foto_portada, usuario.foto_portada) && Objects.equals(created_at, usuario.created_at) && Objects.equals(updated_at, usuario.updated_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_usuario, nombre, apellidos, edad, email, password, genero, codigoPostal, estado, ciudad, foto_perfil, foto_portada, created_at, updated_at);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id_usuario=" + id_usuario +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", edad=" + edad +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", genero='" + genero + '\'' +
                ", codigoPostal=" + codigoPostal +
                ", estado='" + estado + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", foto_perfil='" + foto_perfil + '\'' +
                ", foto_portada='" + foto_portada + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
