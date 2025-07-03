package com.example.finca_hexagonal.infrastructure.exceptions;


public class DateConflictException extends RuntimeException{
    public DateConflictException(String message) {
        super(message);
    }
}
