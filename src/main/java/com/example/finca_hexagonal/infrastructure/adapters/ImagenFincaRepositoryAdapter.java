package com.example.finca_hexagonal.infrastructure.adapters;

import com.example.finca_hexagonal.domain.models.ImagenFinca;
import com.example.finca_hexagonal.domain.ports.out.ImagenFincaModelPort;
import com.example.finca_hexagonal.infrastructure.entities.ImagenFincaEntity;
import com.example.finca_hexagonal.infrastructure.mappers.ImagenFincaModelMappers;
import com.example.finca_hexagonal.infrastructure.repositories.JpaImagenFincaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        return jpaImagenFincaRepository.findById(id).map(imagenFincaModelMappers::toDomainModel);
    }

    @Override
    public Optional<ImagenFinca> updateById(Long id, ImagenFinca imagenFincaUpdate) {
        if (jpaImagenFincaRepository.existsById(id)){
            ImagenFincaEntity imagenFincaEntity = imagenFincaModelMappers.fromDomainModel(imagenFincaUpdate);
            ImagenFincaEntity newImagenFincaEntity = jpaImagenFincaRepository.save(imagenFincaEntity);
            return Optional.of(imagenFincaModelMappers.toDomainModel(newImagenFincaEntity));
        }
        return Optional.empty();
    }

    @Override
    public List<ImagenFinca> findByFinca(Long fincaId) {
        return jpaImagenFincaRepository.findAllByFincaId(fincaId).stream()
                .map(imagenFincaModelMappers::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<ImagenFinca> getAllImagenFinca() {
        return jpaImagenFincaRepository.findAll().stream()
                .map(imagenFincaModelMappers::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public boolean delete(Long id) {
        if (jpaImagenFincaRepository.existsById(id)){
            jpaImagenFincaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
