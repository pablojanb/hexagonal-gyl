package com.example.finca_hexagonal.application.dto.rol;

import com.example.finca_hexagonal.domain.models.Permiso;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RolResponseDTO {
    private Long id;
    private String nombre;
    private List<Permiso> permisos;
}
