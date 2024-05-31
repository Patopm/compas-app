package com.compas.app.app.exceptions;

import java.io.Serial;

public class ArtistaNotFoundException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    public ArtistaNotFoundException(Long id){
        super("el artista con id " + id + " no fue encontrado");
    }

}
