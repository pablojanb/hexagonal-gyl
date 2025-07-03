package com.example.finca_hexagonal.infrastructure.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "fincas")
public class FincaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    @OneToOne
    private UsuarioEntity usuario;
    @OneToOne
    private DireccionEntity direccion;
    private BigDecimal tarifaHora;

    @OneToMany(mappedBy = "finca")
    private List<DetalleFincaEntity> detalles;

    @OneToMany(mappedBy = "finca")
    private List<HorarioEntity> horarios;

    @OneToMany(mappedBy = "finca")
    private List<ImagenFincaEntity> imagenesFinca;

    @OneToMany(mappedBy = "finca")
    private List<FechaEspecialEntity> fechasEspFinca;

    @OneToMany(mappedBy = "finca")
    private List<ReservaEntity> reservasFinca;

    @ManyToMany
    private List<ExtraEntity> extras;

    public FincaEntity() {
    }

    public FincaEntity(Long id, String nombre, UsuarioEntity usuario, DireccionEntity direccion, BigDecimal tarifaHora, List<DetalleFincaEntity> detalles, List<HorarioEntity> horarios, List<ImagenFincaEntity> imagenesFinca, List<FechaEspecialEntity> fechasEspFinca, List<ReservaEntity> reservasFinca) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.direccion = direccion;
        this.tarifaHora = tarifaHora;
        this.detalles = detalles;
        this.horarios = horarios;
        this.imagenesFinca = imagenesFinca;
        this.fechasEspFinca = fechasEspFinca;
        this.reservasFinca = reservasFinca;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public DireccionEntity getDireccion() {
        return direccion;
    }

    public void setDireccion(DireccionEntity direccion) {
        this.direccion = direccion;
    }

    public BigDecimal getTarifaHora() {
        return tarifaHora;
    }

    public void setTarifaHora(BigDecimal tarifaHora) {
        this.tarifaHora = tarifaHora;
    }

    public List<DetalleFincaEntity> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleFincaEntity> detalles) {
        this.detalles = detalles;
    }

    public List<HorarioEntity> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<HorarioEntity> horarios) {
        this.horarios = horarios;
    }

    public List<ImagenFincaEntity> getImagenesFinca() {
        return imagenesFinca;
    }

    public void setImagenesFinca(List<ImagenFincaEntity> imagenesFinca) {
        this.imagenesFinca = imagenesFinca;
    }

    public List<FechaEspecialEntity> getFechasEspFinca() {
        return fechasEspFinca;
    }

    public void setFechasEspFinca(List<FechaEspecialEntity> fechasEspFinca) {
        this.fechasEspFinca = fechasEspFinca;
    }

    public List<ReservaEntity> getReservasFinca() {
        return reservasFinca;
    }

    public void setReservasFinca(List<ReservaEntity> reservasFinca) {
        this.reservasFinca = reservasFinca;
    }
}
