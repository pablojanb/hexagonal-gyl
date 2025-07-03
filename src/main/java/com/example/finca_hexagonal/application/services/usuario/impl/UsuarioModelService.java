package com.example.finca_hexagonal.application.services.usuario.impl;


import com.example.finca_hexagonal.domain.models.Usuario;
import com.example.finca_hexagonal.domain.ports.in.usuario.CreateUsuarioUseCase;
import com.example.finca_hexagonal.domain.ports.in.usuario.DeleteUsuarioUseCase;
import com.example.finca_hexagonal.domain.ports.in.usuario.GetUsuarioUseCase;
import com.example.finca_hexagonal.domain.ports.in.usuario.UpdateUsuarioUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioModelService implements CreateUsuarioUseCase, GetUsuarioUseCase, UpdateUsuarioUseCase, DeleteUsuarioUseCase {

    private final CreateUsuarioUseCase createUsuarioUseCase;
    private final GetUsuarioUseCase getUsuarioUseCase;
    private final UpdateUsuarioUseCase updateUsuarioUseCase;
    private final DeleteUsuarioUseCase deleteUsuarioUseCase;

    public UsuarioModelService(CreateUsuarioUseCase createUsuarioUseCase, GetUsuarioUseCase getUsuarioUseCase, UpdateUsuarioUseCase updateUsuarioUseCase, DeleteUsuarioUseCase deleteUsuarioUseCase) {
        this.createUsuarioUseCase = createUsuarioUseCase;
        this.getUsuarioUseCase = getUsuarioUseCase;
        this.updateUsuarioUseCase = updateUsuarioUseCase;
        this.deleteUsuarioUseCase = deleteUsuarioUseCase;
    }

    @Override
    public Usuario createUsuario(Usuario usuario) {
        return createUsuarioUseCase.createUsuario(usuario);
    }

    @Override
    public boolean deleteUsuario(Long id) {
        return deleteUsuarioUseCase.deleteUsuario(id);
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return getUsuarioUseCase.getAllUsuarios();
    }

    @Override
    public Optional<Usuario> getById(Long id) {
        return getUsuarioUseCase.getById(id);
    }

    @Override
    public Optional<Usuario> updateUsuario(Long id, Usuario usuarioUpdate) {
        return updateUsuarioUseCase.updateUsuario(id, usuarioUpdate);
    }
}
