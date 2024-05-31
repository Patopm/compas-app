package com.compas.app.app.exceptions;

import java.io.Serial;

public class ContrasenaInvalidaException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public ContrasenaInvalidaException(String email){
        super("La contraseña es incorrecta: " + email);
    }
}
