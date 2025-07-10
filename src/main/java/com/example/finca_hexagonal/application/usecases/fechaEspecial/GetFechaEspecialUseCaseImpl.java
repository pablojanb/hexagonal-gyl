package com.example.finca_hexagonal.application.usecases.fechaEspecial;

import com.example.finca_hexagonal.domain.models.FechaEspecial;
import com.example.finca_hexagonal.domain.ports.in.fechaEspecial.GetFechaEspecialUseCase;
import com.example.finca_hexagonal.domain.ports.out.FechaEspecialModelPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetFechaEspecialUseCaseImpl implements GetFechaEspecialUseCase {
    private final FechaEspecialModelPort fechaEspecialModelPort;

    public GetFechaEspecialUseCaseImpl(FechaEspecialModelPort fechaEspecialModelPort) {
        this.fechaEspecialModelPort = fechaEspecialModelPort;
    }

    @Override
    public List<FechaEspecial> getAll() {
        return fechaEspecialModelPort.getAll();
    }

    @Override
    public Optional<FechaEspecial> getById(Long id) {
        return fechaEspecialModelPort.getById(id);
    }

    @Override
    public List<FechaEspecial> getFechasEspByFincaId(Long fincaId) {
        return fechaEspecialModelPort.findAllFechaEspecialByFincaId(fincaId);
    }
}
