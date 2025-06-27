package com.example.finca_hexagonal.application.usecases.rol;

import com.example.finca_hexagonal.domain.models.Rol;
import com.example.finca_hexagonal.domain.ports.in.rol.UpdateRolUseCase;
import com.example.finca_hexagonal.domain.ports.out.RolModelPort;

public class UpdateRolUseCaseImpl implements UpdateRolUseCase {

    private final RolModelPort rolModelPort;

    public UpdateRolUseCaseImpl(RolModelPort rolModelPort) {
        this.rolModelPort = rolModelPort;
    }

    @Override
    public Rol update(Rol rol) {
        return rolModelPort.update(rol);
    }
}
