package com.example.finca_hexagonal.application.usecases.rol;

import com.example.finca_hexagonal.domain.models.Rol;
import com.example.finca_hexagonal.domain.ports.in.rol.GetRolUseCase;
import com.example.finca_hexagonal.domain.ports.out.RolModelPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetRolUseCaseImpl implements GetRolUseCase {

    private final RolModelPort rolModelPort;

    public GetRolUseCaseImpl(RolModelPort rolModelPort) {
        this.rolModelPort = rolModelPort;
    }

    @Override
    public List<Rol> getRoles() {
        return rolModelPort.findAll();
    }

    @Override
    public Optional<Rol> getRol(Long id) {
        return rolModelPort.findById(id);
    }
}
