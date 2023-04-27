package com.avanade.rpg.exception;

import java.io.Serial;

public class ResourceNotFoundException extends InvalidInputException {

    @Serial
    private static final long serialVersionUID = -5868980605782668416L;

    public ResourceNotFoundException( String message ) {
        super( message );
    }
}
