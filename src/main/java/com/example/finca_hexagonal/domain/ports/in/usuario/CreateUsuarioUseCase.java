package com.example.finca_hexagonal.domain.ports.in.usuario;
import com.example.finca_hexagonal.domain.models.Usuario;

public interface CreateUsuarioUseCase {
    Usuario createUsuario(Usuario usuario);
}
