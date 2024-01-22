package com.jaminel.minilibrary.exceptions;

public class MiniLibraryNotFoundException extends RuntimeException {
    public MiniLibraryNotFoundException(String message) {
        super(message);
    }


    public MiniLibraryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
