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

    private String calle;
    private int altura;
    private String ciudad;

    private Boolean enabled;
}
