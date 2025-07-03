package com.example.finca_hexagonal.application.dto.imagenFinca;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ImagenFincaDTORequest {
    private String url;
    private boolean esPortada;
    private Long fincaId;
}
