package com.example.finca_hexagonal.infrastructure.exceptions;

public class InvalidDateException extends RuntimeException{
    public InvalidDateException(String message) {
        super(message);
    }
}
