package com.example.finca_hexagonal.application.dto.authentication;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter @Getter
public class AuthLoginResponseDTO {
    private String username;
    private String token;
    private String message;
    private boolean active;
}
