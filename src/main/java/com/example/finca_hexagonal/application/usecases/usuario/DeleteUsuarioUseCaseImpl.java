package com.example.finca_hexagonal.application.usecases.usuario;

import com.example.finca_hexagonal.domain.models.Usuario;
import com.example.finca_hexagonal.domain.ports.in.usuario.DeleteUsuarioUseCase;
import com.example.finca_hexagonal.domain.ports.out.UsuarioModelPort;

public class DeleteUsuarioUseCaseImpl implements DeleteUsuarioUseCase {

    private final UsuarioModelPort usuarioModelPort;

    public DeleteUsuarioUseCaseImpl(UsuarioModelPort usuarioModelPort) {
        this.usuarioModelPort = usuarioModelPort;
    }

    @Override
    public Boolean deleteById(Long id) {
        return usuarioModelPort.deleteById(id);
    }

    @Override
    public Boolean logicalDeletion(Usuario usuario) {
        return usuarioModelPort.logicalDeletion(usuario);
    }
}
