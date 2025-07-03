package com.example.finca_hexagonal.infrastructure.exceptions;

public class OperationFailedException extends RuntimeException{
    public OperationFailedException(String message) {
        super(message);
    }
}
