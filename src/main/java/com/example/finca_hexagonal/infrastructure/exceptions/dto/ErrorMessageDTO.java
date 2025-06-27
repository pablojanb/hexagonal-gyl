package com.example.finca_hexagonal.infrastructure.exceptions.dto;

import org.springframework.http.HttpStatus;

public record ErrorMessageDTO(HttpStatus status, String message) {
}
