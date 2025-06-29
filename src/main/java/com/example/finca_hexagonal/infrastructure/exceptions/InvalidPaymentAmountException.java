package com.example.finca_hexagonal.infrastructure.exceptions;

public class InvalidPaymentAmountException extends RuntimeException{
    public InvalidPaymentAmountException(String message) {
        super(message);
    }
}
