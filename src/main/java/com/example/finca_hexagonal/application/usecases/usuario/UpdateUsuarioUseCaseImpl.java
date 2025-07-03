package com.example.finca_hexagonal.application.usecases.usuario;

import com.example.finca_hexagonal.domain.models.Usuario;
import com.example.finca_hexagonal.domain.ports.in.usuario.UpdateUsuarioUseCase;
import com.example.finca_hexagonal.domain.ports.out.UsuarioModelPort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateUsuarioUseCaseImpl implements UpdateUsuarioUseCase {
    private final UsuarioModelPort usuarioModelPort;

    public UpdateUsuarioUseCaseImpl(UsuarioModelPort usuarioModelPort) {
        this.usuarioModelPort = usuarioModelPort;
    }
    @Override
    public Optional<Usuario> updateUsuario(Long id, Usuario usuarioUpdate) {
        return usuarioModelPort.updateById(id, usuarioUpdate);
    }
}
