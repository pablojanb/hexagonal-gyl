package com.example.finca_hexagonal.application.dto.documentacion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DocumentacionResponseDTO {
    private Long id;
    private Long fincaId;
    private String finca;
    private String propietario;
    private String escrituraPropiedad;
    private String planoCatastral;
    private String impuestoBienesInmuebles;
}
