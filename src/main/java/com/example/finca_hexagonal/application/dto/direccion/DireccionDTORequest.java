package com.example.finca_hexagonal.application.dto.direccion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DireccionDTORequest {
    private String calle;
    private int altura;
    private String ciudad;
    private String provincia;
    private String aclaracion;






}
