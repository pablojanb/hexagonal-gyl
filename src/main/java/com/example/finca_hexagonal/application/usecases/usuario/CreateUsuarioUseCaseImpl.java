package com.example.finca_hexagonal.application.usecases.usuario;

import com.example.finca_hexagonal.domain.models.Usuario;
import com.example.finca_hexagonal.domain.ports.in.usuario.CreateUsuarioUseCase;
import com.example.finca_hexagonal.domain.ports.out.UsuarioModelPort;
import org.springframework.stereotype.Service;

@Service
public class CreateUsuarioUseCaseImpl implements CreateUsuarioUseCase {

    private final UsuarioModelPort usuarioModelPort;

    public CreateUsuarioUseCaseImpl(UsuarioModelPort usuarioModelPort) {
        this.usuarioModelPort = usuarioModelPort;
    }

    @Override
    public Usuario createUsuario(Usuario usuario) {
        return usuarioModelPort.save(usuario);
    }
}
