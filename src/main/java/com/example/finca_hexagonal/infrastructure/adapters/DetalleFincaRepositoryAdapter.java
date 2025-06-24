package com.example.finca_hexagonal.infrastructure.adapters;

import com.example.finca_hexagonal.domain.models.DetalleFinca;
import com.example.finca_hexagonal.domain.ports.out.DetalleFincaRepository;
import com.example.finca_hexagonal.infrastructure.entities.DetalleFincaEntity;
import com.example.finca_hexagonal.infrastructure.repositories.JpaDetalleFincaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class DetalleFincaRepositoryAdapter implements DetalleFincaRepository {

    private final JpaDetalleFincaRepository jpaRepository;

    public DetalleFincaRepositoryAdapter(JpaDetalleFincaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    private DetalleFincaEntity toEntity(DetalleFinca model) {
        return DetalleFincaEntity.builder()
                .idDetalle(model.getIdDetalle())
                .descripcion(model.getDescripcion())
                .cantHabitacion(model.getCantHabitacion())
                .cantBano(model.getCantBano())
                .metrosCuadrados(model.getMetrosCuadrados())
                .capacidadMaxima(model.getCapacidadMaxima())
                .wifi(model.isWifi())
                .piscina(model.isPiscina())
                .parrilla(model.isParrilla())
                .build();
    }

    private DetalleFinca toModel(DetalleFincaEntity entity) {
        return new DetalleFinca(
                entity.getIdDetalle(),
                entity.getDescripcion(),
                entity.getCantHabitacion(),
                entity.getCantBano(),
                entity.getMetrosCuadrados(),
                entity.getCapacidadMaxima(),
                entity.isWifi(),
                entity.isPiscina(),
                entity.isParrilla()
        );
    }

    @Override
    public DetalleFinca guardar(DetalleFinca detalle) {
        return toModel(jpaRepository.save(toEntity(detalle)));
    }

    @Override
    public Optional<DetalleFinca> buscarPorId(Long id) {
        return jpaRepository.findById(id).map(this::toModel);
    }

    @Override
    public List<DetalleFinca> buscarTodos() {
        return jpaRepository.findAll().stream().map(this::toModel).collect(Collectors.toList());
    }

    @Override
    public DetalleFinca actualizar(DetalleFinca detalle) {
        return toModel(jpaRepository.save(toEntity(detalle)));
    }

    @Override
    public void eliminar(Long id) {
        jpaRepository.deleteById(id);
    }
}