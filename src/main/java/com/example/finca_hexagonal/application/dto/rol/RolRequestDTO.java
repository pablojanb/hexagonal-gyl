package com.example.finca_hexagonal.application.dto.rol;

import com.example.finca_hexagonal.domain.models.Permiso;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RolRequestDTO {
    private String nombre;
    private List<Permiso> permisos = new ArrayList<>();
}
