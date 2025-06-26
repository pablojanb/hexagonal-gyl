package com.example.finca_hexagonal.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "imagen_finca")
public class ImagenFincaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idImagen;

    private String url;
    private boolean esPortada;

    @Column(name = "finca_id")
    private Long fincaId;
}
