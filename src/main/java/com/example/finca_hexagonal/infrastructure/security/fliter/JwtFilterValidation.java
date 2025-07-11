package com.example.finca_hexagonal.infrastructure.security.fliter;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.finca_hexagonal.infrastructure.exceptions.dto.ErrorMessageDTO;
import com.example.finca_hexagonal.infrastructure.utils.JwtUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collection;

public class JwtFilterValidation extends OncePerRequestFilter {

    private final JwtUtils jwtUtils;

    public JwtFilterValidation(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        try {
            String token = request.getHeader(HttpHeaders.AUTHORIZATION);

            //Verifica que el token no sea nulo o que comience con Bearer
            if (token != null && token.startsWith("Bearer ")) {
                token = token.substring(7); // Le sacamos el "Bearer "

                //Decodificamos el Token
                DecodedJWT decodedJWT = jwtUtils.validateToken(token);
                //Traemos el username o Email
                String input = jwtUtils.extractUsername(decodedJWT);
                //Traemos todas las Authorities
                String authorities = jwtUtils.extractSpecificClaim(decodedJWT, "authorities").asString();

                //Armamos una Coleccion de authorities, con el metodo que convierte en authoritie por ","
                Collection authoritiesList = AuthorityUtils.commaSeparatedStringToAuthorityList(authorities);

                //Armamos la autenticacion, con el nombre y la lista de autoridades
                Authentication authentication = new UsernamePasswordAuthenticationToken(input, null, authoritiesList);

                //Seteamos la autenticacion en el contexto de spring security
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (JWTVerificationException e) {
            SecurityContextHolder.clearContext();
            logger.warn("Invalid token: " + e.getMessage()); // Log como advertencia

            // Enviar una respuesta personalizada
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            ErrorMessageDTO errorMessage = new ErrorMessageDTO(HttpStatus.UNAUTHORIZED, "Autenticacion fallida. Algo salio mal en la autenticacion.");
            new ObjectMapper().writeValue(response.getWriter(), errorMessage);

            return; // Detener la cadena de filtros
            //Devolvemos a la Cadena de Filtros
        }
        filterChain.doFilter(request, response);
    }
}
