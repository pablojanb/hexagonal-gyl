package com.example.finca_hexagonal.infrastructure.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "detalles")
public class DetalleFincaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "fincaId")
    private FincaEntity finca;
    private String descripcion;
    private int cantHabitacion;
    private int cantBano;
    private double metrosCuadrados;
    private int capacidadMaxima;

    public DetalleFincaEntity() {
    }

    public DetalleFincaEntity(Long id, FincaEntity finca, String descripcion, int cantHabitacion, int cantBano, double metrosCuadrados, int capacidadMaxima) {
        this.id = id;
        this.finca = finca;
        this.descripcion = descripcion;
        this.cantHabitacion = cantHabitacion;
        this.cantBano = cantBano;
        this.metrosCuadrados = metrosCuadrados;
        this.capacidadMaxima = capacidadMaxima;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FincaEntity getFinca() {
        return finca;
    }

    public void setFinca(FincaEntity finca) {
        this.finca = finca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantHabitacion() {
        return cantHabitacion;
    }

    public void setCantHabitacion(int cantHabitacion) {
        this.cantHabitacion = cantHabitacion;
    }

    public int getCantBano() {
        return cantBano;
    }

    public void setCantBano(int cantBano) {
        this.cantBano = cantBano;
    }

    public double getMetrosCuadrados() {
        return metrosCuadrados;
    }

    public void setMetrosCuadrados(double metrosCuadrados) {
        this.metrosCuadrados = metrosCuadrados;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }
}
