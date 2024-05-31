package com.compas.app.service;

import com.compas.app.exceptions.InstrumentoNotFoundException;
import com.compas.app.exceptions.InstrumentoidNotFoundException;
import com.compas.app.model.Instrumentos;
import com.compas.app.repository.InstrumentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class InstrumentosService {

    private final InstrumentosRepository instrumentosRepository;

    @Autowired
    public InstrumentosService(InstrumentosRepository instrumentosRepository){
        this.instrumentosRepository = instrumentosRepository;
    }

    // Método GET
    public List<Instrumentos> getALLInstrumentos(){
        return instrumentosRepository.findAll();
    }

    // Método GET por id
    public Instrumentos getInstrumentosById(Long id){ // Buscar solo por id
        return instrumentosRepository.findById(id).orElseThrow(() -> new InstrumentoidNotFoundException(id));
    }

    // Método GET por nombre Instrumento
    public Instrumentos getInstrumentoByName(String instrumento){ // Buscar solo por nombre
        return instrumentosRepository.findByInstrumento(instrumento).orElseThrow(() -> new InstrumentoNotFoundException(instrumento));
    }

    // Método POST
    public void addNewInstrumento(Instrumentos instrumento){
        Optional<Instrumentos> instrumentoOptional = instrumentosRepository.findByInstrumento(instrumento.getInstrumento());
        if(instrumentoOptional.isPresent()) {
            throw new InstrumentoNotFoundException("Instrumento" + instrumento.getInstrumento() + "Ya existe");
        }
        instrumentosRepository.save(instrumento);
    }

    // Método DELETE
    public void deleteInstrumento(Long id){
        boolean exists = instrumentosRepository.existsById(id);
        if(!exists){
            throw new InstrumentoidNotFoundException(id);
        }
        instrumentosRepository.deleteById(id);
    }

    // Método PUT
    public void upDateInstrumento(Long id, Instrumentos upDateInstrumento){
    Instrumentos instrumento = instrumentosRepository.findById(id).orElseThrow(() -> new InstrumentoidNotFoundException(id));
    if (upDateInstrumento.getInstrumento() != null && upDateInstrumento.getInstrumento().length() > 0 && !Objects.equals(instrumento.getInstrumento(), upDateInstrumento.getInstrumento())){
        instrumento.setInstrumento(upDateInstrumento.getInstrumento());
    }
    instrumento.setUpdated_at(LocalDateTime.now());
    }
}
