package com.compas.app.app.exceptions;

import java.io.Serial;

public class Genero_musicalidNotFoundException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public Genero_musicalidNotFoundException(Long id){
        super("Genero musical no encontrado con id: " + id);
    }
}
