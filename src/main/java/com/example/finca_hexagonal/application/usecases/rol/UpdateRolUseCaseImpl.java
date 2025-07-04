package com.example.finca_hexagonal.application.usecases.rol;

import com.example.finca_hexagonal.domain.models.Rol;
import com.example.finca_hexagonal.domain.ports.in.rol.UpdateRolUseCase;
import com.example.finca_hexagonal.domain.ports.out.RolModelPort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateRolUseCaseImpl implements UpdateRolUseCase {

    private final RolModelPort rolModelPort;

    public UpdateRolUseCaseImpl(RolModelPort rolModelPort) {
        this.rolModelPort = rolModelPort;
    }

    @Override
    public Optional<Rol> updateRol(Long id, Rol rolUpdate) {
        return rolModelPort.updateById(id, rolUpdate);
    }
}
