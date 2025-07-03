package com.example.finca_hexagonal.application.dto.documentacion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DocumentacionRequestDTO {
    private Long id;
    private String fincaId;
    private String escrituraPropiedad;
    private String planoCatastral;
    private String impuestoBienesInmuebles;
}
