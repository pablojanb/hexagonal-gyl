package com.example.finca_hexagonal.application.services;

import com.example.finca_hexagonal.domain.models.ImagenFinca;
import com.example.finca_hexagonal.domain.ports.in.finca.ImagenFincaService;
import com.example.finca_hexagonal.domain.ports.out.ImagenFincaModelPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImagenFincaServiceImpl implements ImagenFincaService {

    private final ImagenFincaModelPort repository;

    public ImagenFincaServiceImpl(ImagenFincaModelPort repository) {
        this.repository = repository;
    }

    @Override
    public ImagenFinca crearImagen(ImagenFinca imagen) {
        return repository.guardar(imagen);
    }

    @Override
    public ImagenFinca obtenerPorId(Long id) {
        return repository.buscarPorId(id).orElse(null);
    }

    @Override
    public List<ImagenFinca> listarPorFinca(Long fincaId) {
        return repository.buscarPorFinca(fincaId);
    }

    @Override
    public void eliminarImagen(Long id) {
        repository.eliminar(id);
    }
}