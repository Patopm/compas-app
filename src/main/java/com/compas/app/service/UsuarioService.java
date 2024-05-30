package com.compas.app.service;

import com.compas.app.exceptions.EmailNotFoundException;
import com.compas.app.exceptions.UsuarioNotFoundException;
import com.compas.app.model.Usuario;
import com.compas.app.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    //metodos para get
    public List<Usuario> getAllUsers(){
        return usuarioRepository.findAll();
    }

    public Usuario getUsuarioById(Long id){
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException(id));
    }

    public Usuario getUsuarioByEmail(String email){
        return usuarioRepository.findUsuarioByEmail(email)
                .orElseThrow(() -> new EmailNotFoundException(email));
    }

    // metodos para post
    public void addNewUsuario(Usuario usuario) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findUsuarioByEmail(usuario.getEmail());
        if(usuarioOptional.isPresent()) {
            throw new IllegalStateException("email "+ usuario.getEmail() + " ya existe");
        }
        usuarioRepository.save(usuario);
    }

    //metodos para delete
    public void deleteUsuario(Long id) {
        boolean exists = usuarioRepository.existsById(id);
        if (!exists){
            throw new UsuarioNotFoundException(id);
        }
        usuarioRepository.deleteById(id);
    }

    //metodos para post
    @Transactional
    public void updateUsuario(Long idUsuario, Usuario updateUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new UsuarioNotFoundException(idUsuario));
        if (updateUsuario.getNombre() != null && updateUsuario.getNombre().length() > 0 && !Objects.equals(usuario.getNombre(), updateUsuario.getNombre())){
            usuario.setNombre(updateUsuario.getNombre());
        }
        if (updateUsuario.getApellidos() != null && updateUsuario.getApellidos().length() > 0 && !Objects.equals(usuario.getApellidos(), updateUsuario.getApellidos())){
            usuario.setApellidos(updateUsuario.getApellidos());
        }
        if (updateUsuario.getEdad() != null && updateUsuario.getEdad() > 18 && !Objects.equals(usuario.getEdad(), updateUsuario.getEdad())){
            usuario.setEdad(updateUsuario.getEdad());
        }
        if (updateUsuario.getEmail() != null && updateUsuario.getEmail().length() > 0 && !Objects.equals(usuario.getEmail(), updateUsuario.getEmail())){
            usuario.setEmail(updateUsuario.getEmail());
        }
        if (updateUsuario.getPassword() != null && updateUsuario.getPassword().length() > 0 && !Objects.equals(usuario.getPassword(), updateUsuario.getPassword())){
            usuario.setPassword(updateUsuario.getPassword());
        }
        if (updateUsuario.getGenero() != null && updateUsuario.getGenero().length() > 0 && !Objects.equals(usuario.getGenero(), updateUsuario.getGenero())){
            usuario.setGenero(updateUsuario.getGenero());
        }
        if (updateUsuario.getCodigoPostal() != null && updateUsuario.getCodigoPostal() >= 1000 && updateUsuario.getCodigoPostal() <= 99000 && !Objects.equals(usuario.getCodigoPostal(), updateUsuario.getCodigoPostal())){
            usuario.setCodigoPostal(updateUsuario.getCodigoPostal());
        }
        if (updateUsuario.getEstado() != null && updateUsuario.getEstado().length() > 0 && !Objects.equals(usuario.getEstado(), updateUsuario.getEstado())){
            usuario.setEstado(updateUsuario.getEstado());
        }
        if (updateUsuario.getCiudad() != null && updateUsuario.getCiudad().length() > 0 && !Objects.equals(usuario.getCiudad(), updateUsuario.getCiudad())){
            usuario.setCiudad(updateUsuario.getCiudad());
        }
        if (updateUsuario.getFoto_perfil() != null && !Objects.equals(usuario.getFoto_perfil(), updateUsuario.getFoto_perfil())){
            usuario.setFoto_perfil(updateUsuario.getFoto_perfil());
        }
        if (updateUsuario.getFoto_portada() != null && !Objects.equals(usuario.getFoto_portada(), updateUsuario.getFoto_portada())){
            usuario.setFoto_portada(updateUsuario.getFoto_portada());
        }
        usuario.setUpdated_at(LocalDate.now());
    }
}
