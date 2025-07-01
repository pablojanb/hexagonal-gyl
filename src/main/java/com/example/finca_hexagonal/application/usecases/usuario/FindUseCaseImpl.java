package com.example.finca_hexagonal.application.usecases.usuario;

import com.example.finca_hexagonal.domain.models.Usuario;
import com.example.finca_hexagonal.domain.ports.in.usuario.FindUsuarioUseCase;
import com.example.finca_hexagonal.domain.ports.out.UsuarioModelPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class FindUseCaseImpl implements FindUsuarioUseCase {

    private final UsuarioModelPort usuarioModelPort;

    public FindUseCaseImpl(UsuarioModelPort usuarioModelPort) {
        this.usuarioModelPort = usuarioModelPort;
    }

    @Override
    public List<Usuario> getAll() {
        return usuarioModelPort.findAll();
    }

    @Override
    public Usuario getById(Long id) {
        return usuarioModelPort.findById(id);
    }

    @Override
    public Usuario getByName(String username) {
        return usuarioModelPort.findByName(username);
    }
}
