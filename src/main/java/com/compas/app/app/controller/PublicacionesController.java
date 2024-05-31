package com.compas.app.app.controller;

import com.compas.app.model.Publicaciones;
import com.compas.app.model.Usuario;
import com.compas.app.service.PublicacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/publicacion")
@CrossOrigin(origins="*", methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
public class PublicacionesController {
    private final PublicacionesService publicacionesService;

    @Autowired
    public PublicacionesController(PublicacionesService publicacionesService) {
        this.publicacionesService = publicacionesService;
    }

    //Get
    @GetMapping
    public List<Publicaciones> getAllPublicaciones(){
        return publicacionesService.getAllPublicaciones();
    }

    @GetMapping("/{id}")
    public Publicaciones getPublicacionesById(@PathVariable(name = "id") Long id){
        return publicacionesService.getPublicacionById(id);
    }

    //Post
    @PostMapping("/add-publicacion/{id}")
    public void registerNewPublicacion(@RequestBody Publicaciones publicaciones,
                                       @PathVariable(name = "id") Usuario usuario){
        publicaciones.setCreatedAt(LocalDateTime.now());
        publicaciones.setUpdatedAt(LocalDateTime.now());
        publicacionesService.addNewPublicacion(publicaciones, usuario);
    }

    //Delete
    @DeleteMapping(path = "/{id}")
    public void deletePublicacion(@PathVariable(name = "id")Long id){
        publicacionesService.deletePublicacionById(id);
    }
}
