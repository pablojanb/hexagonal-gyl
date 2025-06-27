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
    @Column(name = "id_imagen")
    private Long idImagen;

    private String url;

    @Column(name = "es_portada")
    private boolean esPortada;

    @ManyToOne
    @JoinColumn(name = "finca_id")
    private FincaEntity finca;

}
