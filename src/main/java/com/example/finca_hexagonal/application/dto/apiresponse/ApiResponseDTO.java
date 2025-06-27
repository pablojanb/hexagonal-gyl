package com.example.finca_hexagonal.application.dto.apiresponse;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"message"})
public record ApiResponseDTO(String message) {
}
