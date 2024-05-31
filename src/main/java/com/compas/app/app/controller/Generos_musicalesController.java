package com.compas.app.app.controller;

import com.compas.app.exceptions.Genero_musicalNotFoundException;
import com.compas.app.model.Generos_musicales;
import com.compas.app.service.Generos_musicalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/generos-musicales")
@CrossOrigin(origins = "*", methods = {RequestMethod.DELETE,RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
public class Generos_musicalesController {

    private final Generos_musicalesService generos_musicalesService;

    @Autowired
    public Generos_musicalesController(Generos_musicalesService generos_musicalesService){
        this.generos_musicalesService = generos_musicalesService;
    }

    // Método GET ALL
    @GetMapping
    public List<Generos_musicales> getAllGeneros_musicales(){
        return generos_musicalesService.getALLGeneros_musicales();
    }

    // Método GET por id
    @GetMapping("/{id}")
    public Generos_musicales getGenero_musicalById(@PathVariable(name = "id") Long id){
        return generos_musicalesService.getGenero_musicalById(id);
    }

    // Método GET por nombre genero musical
    @GetMapping("/{genero_musical}")
    public ResponseEntity<Generos_musicales> getGenero_musicalByName(@RequestParam(name = "genero_musical") String generos_musicales){
        Generos_musicales genero_musical = generos_musicalesService.getGenero_musicalByName(generos_musicales);
        if (genero_musical == null){
            throw new Genero_musicalNotFoundException(generos_musicales);
        }
        return new ResponseEntity<Generos_musicales>(genero_musical, HttpStatus.OK);
    }

    // POST
    @PostMapping("/addGenero-musical")
    public void addNewGenero_musical(@RequestBody Generos_musicales genero_musical) {

        genero_musical.setCreated_at(LocalDateTime.now());
        genero_musical.setUpdated_at(LocalDateTime.now());
        generos_musicalesService.addNewGenero_musical(genero_musical);
    }

    // DELETE
    @DeleteMapping(path = "/{id}")
    public void deleteGenero_musical(@PathVariable(name = "id") Long id_genero_musical){
        generos_musicalesService.deleteGenero_musical(id_genero_musical);
    }


    // PUT
    //@PutMapping(path = "/{id}")
    //public void upDateGenero_musical(@PathVariable("id_genero_musical") Long id){

    //}
}
