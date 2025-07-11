package com.example.finca_hexagonal.infrastructure.security.service;

import com.example.finca_hexagonal.application.dto.authentication.AuthLoginRequestDTO;
import com.example.finca_hexagonal.application.dto.authentication.AuthLoginResponseDTO;
import com.example.finca_hexagonal.infrastructure.entities.UsuarioEntity;
import com.example.finca_hexagonal.infrastructure.exceptions.EntityNotFoundException;
import com.example.finca_hexagonal.infrastructure.repositories.JpaUsuarioRepository;
import com.example.finca_hexagonal.infrastructure.utils.JwtUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final JwtUtils jwtUtil;
    private final PasswordEncoder passwordEncoder;
    private final JpaUsuarioRepository usuarioRepository;

    public UserDetailsServiceImpl(JpaUsuarioRepository usuarioRepository,
                                  JwtUtils jwtUtil, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String input) throws UsernameNotFoundException {

        //Buscar El usuario en la base de datos verificando si nos mandaron un Email o un Username
        Optional<UsuarioEntity> usuario;
        if(isEmail(input)){
            usuario = usuarioRepository.findByEmail(input);
        }else{
            usuario = usuarioRepository.findByUsername(input);
        }

        if(usuario.isEmpty()) throw new EntityNotFoundException("Error, no se encontro el usuario con identificador: ");

        //Convertir los roles en granted Authorities
        Set<GrantedAuthority> authorities = usuario.get().getRoles().stream()
                .map(rol -> new SimpleGrantedAuthority("ROLE_"+rol.getNombre()))
                .collect(Collectors.toSet());

        //Convertimos los permisos en granted Authorities
        Set<GrantedAuthority> permisosAuthorities = usuario.get().getRoles().stream()
                .flatMap(role ->role.getPermisos().stream())
                        .map(permiso -> new SimpleGrantedAuthority("PERMISSION_"+permiso.getNombre()))
                        .collect(Collectors.toSet());

        //Juntamos todos los Authorities en una unica lista
        //(Ahora tenemos Autoridades tanto por Rol como por permiso)
        authorities.addAll(permisosAuthorities);

        //Creamos el UserDetail
        return new User(
                usuario.get().getUsername(),
                usuario.get().getPassword(),
                usuario.get().isCuentaActiva(),
                true,
                true,
                true,
                authorities
                );
    }

    private boolean isEmail(String input) {
        return input.contains("@");
    }

    public Authentication authenticate(String username, String password) {

        UserDetails userDetails = loadUserByUsername(username);

        if(!passwordEncoder.matches(password,userDetails.getPassword())){
            throw new BadCredentialsException("Contraseña Incorrecta.");
        }

        return new UsernamePasswordAuthenticationToken(username, password, userDetails.getAuthorities());
    }

    public AuthLoginResponseDTO loginUser(AuthLoginRequestDTO authLoginRequestDTO){
        String input;
        if(authLoginRequestDTO.getUsername().isEmpty()){
            input = authLoginRequestDTO.getEmail();
        }else{
            input = authLoginRequestDTO.getUsername();
        }
        String password = authLoginRequestDTO.getPassword();

        Authentication authentication = authenticate(input, password);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String accesToken = jwtUtil.createToken(authentication);

        return new AuthLoginResponseDTO(input,"login ok",accesToken,true);
    }

}
