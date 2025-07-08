package com.example.finca_hexagonal.application.dto.authentication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthLoginRequestDTO {
    private String email;
    private String username;
    private String password;
}
