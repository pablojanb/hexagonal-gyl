package com.example.finca_hexagonal.application.usecases.rol;

import com.example.finca_hexagonal.domain.models.Rol;
import com.example.finca_hexagonal.domain.ports.in.rol.DeleteRolUseCase;
import com.example.finca_hexagonal.domain.ports.out.RolModelPort;
import org.springframework.stereotype.Service;

@Service
public class DeleteRolUseCaseImpl implements DeleteRolUseCase {

    private final RolModelPort rolModelPort;

    public DeleteRolUseCaseImpl(RolModelPort rolModelPort) {
        this.rolModelPort = rolModelPort;
    }

    @Override
    public Boolean deleteById(Long id) {
        return rolModelPort.deleteById(id);
    }

    @Override
    public Boolean logicalDeletion(Rol rol) {
        return rolModelPort.logicalDeletion(rol);
    }

}
