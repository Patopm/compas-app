package com.compas.app.exceptions;

import java.io.Serial;

public class EmailNotFoundException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    public EmailNotFoundException(String email){
        super("El usuario con id: " + email + " no se encontro");
    }
}
