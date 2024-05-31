package com.compas.app.app.exceptions;

import java.io.Serial;

public class PublicacionNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;
    public PublicacionNotFoundException(Long id){super("No se encontró la publicación con el id: " + id);}
}
