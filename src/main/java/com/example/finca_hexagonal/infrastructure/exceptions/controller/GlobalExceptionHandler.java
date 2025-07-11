package com.example.finca_hexagonal.infrastructure.exceptions.controller;

import com.example.finca_hexagonal.infrastructure.exceptions.DateConflictException;
import com.example.finca_hexagonal.infrastructure.exceptions.EntityNotFoundException;
import com.example.finca_hexagonal.infrastructure.exceptions.InvalidCredentialsException;
import com.example.finca_hexagonal.infrastructure.exceptions.dto.ErrorMessageDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorMessageDTO> NotFountException(EntityNotFoundException ex) {
        ErrorMessageDTO errorMessageDTO = new ErrorMessageDTO(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessageDTO);
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<ErrorMessageDTO> InvalidCredentialsException(InvalidCredentialsException ex) {
        ErrorMessageDTO errorMessageDTO = new ErrorMessageDTO(HttpStatus.UNAUTHORIZED, ex.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorMessageDTO);
    }

    @ExceptionHandler(DateConflictException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorMessageDTO> DateConflictException(DateConflictException ex) {
        ErrorMessageDTO errorMessageDTO = new ErrorMessageDTO(HttpStatus.BAD_REQUEST, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessageDTO);
    }

    //BAD REQUEST -> Validaciones
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, Object> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach((error) -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }



}
