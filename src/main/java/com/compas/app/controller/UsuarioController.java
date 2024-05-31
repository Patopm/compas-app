package com.compas.app.controller;


import com.compas.app.exceptions.ContrasenaInvalidaException;
import com.compas.app.exceptions.EmailNotFoundException;
import com.compas.app.model.Usuario;
import com.compas.app.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/usuario")
@CrossOrigin(origins = "*", methods = {RequestMethod.DELETE,RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
public class UsuarioController {
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    //Get
    @GetMapping
    public List<Usuario> getAllUsuario(){
        return usuarioService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Usuario getUsuarioById(@PathVariable(name = "id") Long id){
        return usuarioService.getUsuarioById(id);
    }

    @GetMapping("/email")
    public ResponseEntity<Usuario> getUsuarioByEmail(@RequestParam(name = "email-user") String email){
        Usuario usuario = usuarioService.getUsuarioByEmail(email);
        if (usuario == null){
            throw new EmailNotFoundException(email);
        }
        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    }

    @GetMapping("/authenticate")
    public ResponseEntity<Usuario> authenticateUser(@RequestParam(name = "email-user") String email,
                                                    @RequestParam(name = "password-user") String password){
        Usuario usuario = usuarioService.findUsuarioByEmailAndPassword(email, password);
        if (usuario == null){
            throw new ContrasenaInvalidaException(email);
        }
        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    }

    //Post
    @PostMapping("/add-usuario")
    public void registerNewUsuario(@RequestBody Usuario usuario){
        usuario.setCreated_at(LocalDateTime.now());
        usuario.setUpdated_at(LocalDateTime.now());
        usuarioService.addNewUsuario(usuario);
    }

    //Delete
    @DeleteMapping(path = "/{id_usuario}")
    public void deleteUsuario(@PathVariable(name = "id_usuario") Long id_usuario){
        usuarioService.deleteUsuario(id_usuario);
    }

    //Put
    @PutMapping(path = "/{id_usuario}")
    public void updateUsuario(@PathVariable("id_usuario") Long id_usuario,
                              @RequestBody Usuario usuario){
        usuarioService.updateUsuario(id_usuario, usuario);
    }
}
