package com.compas.app.controller;

import com.compas.app.exceptions.InstrumentoNotFoundException;
import com.compas.app.model.Instrumentos;
import com.compas.app.service.InstrumentosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/instrumentos")
@CrossOrigin(origins = "*", methods = {RequestMethod.DELETE,RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
public class InstrumentosController {

    private final InstrumentosService instrumentosService;

    @Autowired
    public InstrumentosController(InstrumentosService instrumentosService){
        this.instrumentosService = instrumentosService;
    }

    // Método GET ALL
    @GetMapping
    public List<Instrumentos> getALLInstrumentos(){
        return instrumentosService.getALLInstrumentos();
    }

    // Método GET por id
    @GetMapping("/{id}")
    public Instrumentos getInstrumentosById(@PathVariable(name = "id") Long id){
        return instrumentosService.getInstrumentosById(id);
    }

    // Método GET por nombre Instrumentos
    @GetMapping("/{instrumento}")
    public ResponseEntity<Instrumentos> getInstrumentoByName(@RequestParam(name = "instrumento") String instrumentoName){
        Instrumentos instrumento = instrumentosService.getInstrumentoByName(instrumentoName);
        if (instrumento == null){
            throw new InstrumentoNotFoundException(instrumentoName);
        }
        return new ResponseEntity<Instrumentos>(instrumento, HttpStatus.OK);
    }

    // POST
    @PostMapping("/addInstrumento")
    public void addNewIntrumentos(@RequestBody Instrumentos instrumento){
        instrumento.setCreated_at(LocalDateTime.now());
        instrumento.setUpdated_at(LocalDateTime.now());
        instrumentosService.addNewInstrumento(instrumento);
    }

    // DELETE
    @DeleteMapping(path = "/{id}")
    public void deleteInstrumentos(@PathVariable(name = "id") Long id){
        instrumentosService.deleteInstrumento(id);
    }

    // PUT
    @PutMapping(path = "/{id}")
    public void upDateInstrumento(@PathVariable("id") Long id,
                                  @RequestBody Instrumentos instrumento){
        instrumentosService.upDateInstrumento(id, instrumento);
    }

}
