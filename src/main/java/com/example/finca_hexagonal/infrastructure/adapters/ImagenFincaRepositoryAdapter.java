package com.example.finca_hexagonal.infrastructure.adapters;

import com.example.finca_hexagonal.domain.models.ImagenFinca;
import com.example.finca_hexagonal.domain.ports.out.ImagenFincaRepository;
import com.example.finca_hexagonal.infrastructure.entities.ImagenFincaEntity;
import com.example.finca_hexagonal.infrastructure.repositories.JpaImagenFincaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ImagenFincaRepositoryAdapter implements ImagenFincaRepository {

    private final JpaImagenFincaRepository jpaRepository;

    public ImagenFincaRepositoryAdapter(JpaImagenFincaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    private ImagenFincaEntity toEntity(ImagenFinca model) {
        return ImagenFincaEntity.builder()
                .idImagen(model.getIdImagen())
                .url(model.getUrl())
                .esPortada(model.isEsPortada())
                .fincaId(model.getFincaId())
                .build();
    }

    private ImagenFinca toModel(ImagenFincaEntity entity) {
        return new ImagenFinca(
                entity.getIdImagen(),
                entity.getUrl(),
                entity.isEsPortada(),
                entity.getFincaId()
        );
    }

    @Override
    public ImagenFinca guardar(ImagenFinca imagen) {
        return toModel(jpaRepository.save(toEntity(imagen)));
    }

    @Override
    public Optional<ImagenFinca> buscarPorId(Long id) {
        return jpaRepository.findById(id).map(this::toModel);
    }

    @Override
    public List<ImagenFinca> buscarPorFinca(Long fincaId) {
        return jpaRepository.findByFincaId(fincaId).stream().map(this::toModel).collect(Collectors.toList());
    }

    @Override
    public void eliminar(Long id) {
        jpaRepository.deleteById(id);
    }
}
