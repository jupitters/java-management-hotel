package com.jupitters.JupittersHotel.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String s) {
        super(s);
    }
}
