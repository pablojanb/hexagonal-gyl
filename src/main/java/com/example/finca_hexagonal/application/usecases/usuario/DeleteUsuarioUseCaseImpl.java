package com.example.finca_hexagonal.application.usecases.usuario;

import com.example.finca_hexagonal.domain.ports.in.usuario.DeleteUsuarioUseCase;
import com.example.finca_hexagonal.domain.ports.out.UsuarioModelPort;
import org.springframework.stereotype.Service;

@Service
public class DeleteUsuarioUseCaseImpl implements DeleteUsuarioUseCase {
    private final UsuarioModelPort usuarioModelPort;

    public DeleteUsuarioUseCaseImpl(UsuarioModelPort usuarioModelPort) {
        this.usuarioModelPort = usuarioModelPort;
    }

    @Override
    public boolean deleteUsuario(Long id) {
        return usuarioModelPort.deleteById(id);
    }
}
