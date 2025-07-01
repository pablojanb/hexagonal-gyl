package com.example.finca_hexagonal.application.usecases.rol;

import com.example.finca_hexagonal.domain.models.Rol;
import com.example.finca_hexagonal.domain.ports.in.rol.CreateRolUseCase;
import com.example.finca_hexagonal.domain.ports.out.RolModelPort;
import org.springframework.stereotype.Service;

@Service
public class CreateRolUseCaseImpl implements CreateRolUseCase {

    private final RolModelPort rolModelPort;

    public CreateRolUseCaseImpl(RolModelPort rolModelPort) {
        this.rolModelPort = rolModelPort;
    }

    @Override
    public Rol create(Rol rol) {
        return rolModelPort.save(rol);
    }
}
