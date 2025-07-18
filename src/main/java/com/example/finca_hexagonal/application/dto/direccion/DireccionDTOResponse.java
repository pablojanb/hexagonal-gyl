package com.example.finca_hexagonal.application.dto.direccion;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DireccionDTOResponse {
    private Long id;
    private String direccion;
    private String ciudad;
    private String provincia;
    private String aclaracion;
}
