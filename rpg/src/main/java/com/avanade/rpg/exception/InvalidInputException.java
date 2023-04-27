package com.avanade.rpg.exception;

import java.io.Serial;

public class InvalidInputException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 7783074921912303615L;

    public InvalidInputException( String message ) {
        super( message );
    }

    public InvalidInputException( ) {
        super( "Invalid Payload" );
    }
}
