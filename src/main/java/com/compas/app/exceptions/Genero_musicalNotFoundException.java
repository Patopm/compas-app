package com.compas.app.exceptions;

import java.io.Serial;

public class Genero_musicalNotFoundException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public Genero_musicalNotFoundException(String genero_musical){
        super("Genero musical no encontrado:" + genero_musical);
    }

}
