package com.example.finca_hexagonal.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "imagenes")
public class ImagenFincaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    private boolean esPortada;

    @ManyToOne
    @JoinColumn(name = "id_finca")
    private FincaEntity finca;
}
