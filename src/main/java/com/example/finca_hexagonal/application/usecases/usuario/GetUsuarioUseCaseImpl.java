package com.example.finca_hexagonal.application.usecases.usuario;

import com.example.finca_hexagonal.domain.models.Usuario;
import com.example.finca_hexagonal.domain.ports.in.usuario.GetUsuarioUseCase;
import com.example.finca_hexagonal.domain.ports.out.UsuarioModelPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetUsuarioUseCaseImpl implements GetUsuarioUseCase {

    private final UsuarioModelPort usuarioModelPort;

    public GetUsuarioUseCaseImpl(UsuarioModelPort usuarioModelPort) {
        this.usuarioModelPort = usuarioModelPort;
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioModelPort.findAll();
    }

    @Override
    public Optional<Usuario> getById(Long id) {
        return usuarioModelPort.findById(id);
    }

    @Override
    public Optional<Usuario> getByEmail(String email) {
        return usuarioModelPort.findByEmail(email);
    }
}
