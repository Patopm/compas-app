package com.compas.app.controller;

import com.compas.app.model.MeEntona;
import com.compas.app.service.MeEntonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (path = "/api/v1/meEntona")
public class MeEntonaController {

    private final MeEntonaService meEntonaService;

    @Autowired
    public MeEntonaController(MeEntonaService meEntonaService) {
        this.meEntonaService = meEntonaService;
    }
    @GetMapping
    public List<MeEntona> getAllMeEntona(){
        return meEntonaService.getAllMeEntona();

    }
    @DeleteMapping (path = "/{id}")
    public void deleteMeEntonaById(@PathVariable("id_me_entona") Long idMeEntona){
        meEntonaService.deleteById(idMeEntona);

    }
    @PostMapping (path = "/addMeEntona")
    public MeEntona addNewMeEntona(@RequestBody MeEntona newMeEntona){
          return meEntonaService.addNewMeEntona(newMeEntona);
    }
    /* @PutMapping (path ="/{id}")
    public MeEntona updateMeEntona(@PathVariable("id_me_entona") Long idMeEntona,
                                   @RequestBody MeEntona updateMeEntona ){
        return meEntonaService.updateMeEntona(idMeEntona, updateMeEntona);
    }*/

}
