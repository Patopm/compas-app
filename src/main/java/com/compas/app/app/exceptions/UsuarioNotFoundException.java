package com.compas.app.app.exceptions;

import java.io.Serial;

public class UsuarioNotFoundException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public UsuarioNotFoundException(Long id){
        super("El usuario no se encontro el usuario con id: " + id);
    }
}
