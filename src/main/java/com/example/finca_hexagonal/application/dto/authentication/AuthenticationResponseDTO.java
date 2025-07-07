package com.example.finca_hexagonal.application.dto.authentication;

import com.example.finca_hexagonal.domain.models.Rol;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthenticationResponseDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String username;
    private List<Rol> roles = new ArrayList<>();
}
