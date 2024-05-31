package com.compas.app.controller;

import com.compas.app.model.Artistas;
import com.compas.app.model.Demos;
import com.compas.app.service.DemosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/api/v1/demos")
public class DemosController {
    private final DemosService demosService;

    @Autowired
    public DemosController(DemosService demosService) {
        this.demosService = demosService;
    }

    @GetMapping
    public List<Demos> getAllDemos(){
        return demosService.getAllDemos();
    }

    @PostMapping("/add-demo")
    public Demos registerNewDemo(@RequestBody Demos demos){
        return demosService.addNewDemo(demos);
    }

    @DeleteMapping(path = "/{id_demo}")
    public void deleteDemo(@PathVariable("id_demo") Long id_demo){
        demosService.deleteDemo(id_demo);
    }

    @PutMapping(path = "/{id_demo}")
    public void updateDemo(@PathVariable("id_demo") Long id_demo,
                              @RequestBody(required = false) String titulo,
                              @RequestBody(required = false) String fechaLanzamiento,
                              @RequestBody(required = false) String link,
                              @RequestBody(required = false) Artistas artistaId,
                            @RequestBody(required = false) Long genero_musical_id
    ){
        demosService.updateDemo(id_demo, titulo, fechaLanzamiento, link, artistaId, genero_musical_id);
    }
}
