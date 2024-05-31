package com.compas.app.app.exceptions;

import java.io.Serial;

public class InstrumentoidNotFoundException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public InstrumentoidNotFoundException(Long id){
        super("Id de Instrumento no encontrado:" + id);
    }
}
