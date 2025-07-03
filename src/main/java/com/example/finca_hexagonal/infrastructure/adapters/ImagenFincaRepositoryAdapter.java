package com.example.finca_hexagonal.infrastructure.adapters;

import com.example.finca_hexagonal.domain.models.ImagenFinca;
import com.example.finca_hexagonal.domain.ports.out.ImagenFincaModelPort;
import com.example.finca_hexagonal.infrastructure.entities.ImagenFincaEntity;
import com.example.finca_hexagonal.infrastructure.mappers.ImagenFincaModelMappers;
import com.example.finca_hexagonal.infrastructure.repositories.JpaImagenFincaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ImagenFincaRepositoryAdapter implements ImagenFincaModelPort {

    private final JpaImagenFincaRepository jpaImagenFincaRepository;
    private final ImagenFincaModelMappers imagenFincaModelMappers;

    public ImagenFincaRepositoryAdapter(JpaImagenFincaRepository jpaImagenFincaRepository, ImagenFincaModelMappers imagenFincaModelMappers) {
        this.jpaImagenFincaRepository = jpaImagenFincaRepository;
        this.imagenFincaModelMappers = imagenFincaModelMappers;
    }

    @Override
    public ImagenFinca save(ImagenFinca imagen) {
        ImagenFincaEntity imagenFincaEntity = imagenFincaModelMappers.fromDomainModel(imagen);
        ImagenFincaEntity newImagenFincaEntity = jpaImagenFincaRepository.save(imagenFincaEntity);
        return imagenFincaModelMappers.toDomainModel(newImagenFincaEntity);
    }

    @Override
    public Optional<ImagenFinca> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<ImagenFinca> updateById(Long id, ImagenFinca imagenFincaUpdate) {
        return Optional.empty();
    }

    @Override
    public List<ImagenFinca> findByFinca(Long fincaId) {
        return List.of();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
