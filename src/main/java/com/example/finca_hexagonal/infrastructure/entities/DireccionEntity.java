package com.example.finca_hexagonal.infrastructure.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DireccionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    private DireccionEntity idDireccion;


    private DireccionEntity Direccion;

    private Boolean enabled;
}
