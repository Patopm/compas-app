package com.compas.app.controller;

import com.compas.app.model.Publicaciones;
import com.compas.app.service.PublicacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    /*@PostMapping("/add-publicacion")
    public void registerNewPublicacion(@RequestBody Publicaciones publicaciones){
        publicaciones.setCreatedAt(LocalDate.now());
        publicaciones.setUpdatedAt(LocalDate.now());
        publicacionesService.addNewPublicacion(publicaciones);
    }*/
}
