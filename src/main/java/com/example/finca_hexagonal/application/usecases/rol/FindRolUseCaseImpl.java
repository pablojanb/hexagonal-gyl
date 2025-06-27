package com.example.finca_hexagonal.application.usecases.rol;

import com.example.finca_hexagonal.domain.models.Rol;
import com.example.finca_hexagonal.domain.ports.in.rol.FindRolUseCase;
import com.example.finca_hexagonal.domain.ports.out.RolModelPort;

import java.util.List;
import java.util.Optional;

public class FindRolUseCaseImpl implements FindRolUseCase {

    private final RolModelPort rolModelPort;

    public FindRolUseCaseImpl(RolModelPort rolModelPort) {
        this.rolModelPort = rolModelPort;
    }

    @Override
    public List<Rol> getAll() {
        return rolModelPort.findAll();
    }

    @Override
    public Optional<Rol> getById(Long id) {
        return rolModelPort.findById(id);
    }

    @Override
    public Optional<Rol> getByName(String nombre) {
        return rolModelPort.findByName(nombre);
    }
}
