package com.compas.app.app.exceptions;

import java.io.Serial;

public class InstrumentoNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public InstrumentoNotFoundException(String instrumento){
        super("Instrumento no encontrado:" + instrumento);
    }
}
