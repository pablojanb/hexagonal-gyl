package com.example.finca_hexagonal.domain.ports.in.finca;
import com.example.finca_hexagonal.domain.models.ImagenFinca;
import java.util.List;

public interface ImagenFincaService {
    ImagenFinca crearImagen(ImagenFinca imagen);
    ImagenFinca obtenerPorId(Long id);
    List<ImagenFinca> listarPorFinca(Long fincaId);
    void eliminarImagen(Long id);
}
