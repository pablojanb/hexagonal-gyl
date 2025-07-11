package com.example.finca_hexagonal.infrastructure.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class JwtUtils {

    @Value("${security.jwt.private.key}")
    private String privateKey;

    @Value("${security.jwt.user.generator}")
    private String userGenerator;


    public String createToken(Authentication authentication) {

        //Algoritmo de encriptacion
        Algorithm algorithm = Algorithm.HMAC256(privateKey);

        String input = authentication.getPrincipal().toString();

        //Convertimos las autoridades en una unica string, donde cada authority esta separado por ","
        String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));


        //Le seteamos todo al token
        String token = JWT.create()
                .withIssuer(this.userGenerator) // Usuario generador del token
                .withSubject(input) //Usuario del token
                .withClaim("authorities",authorities) // Claims del token
                .withIssuedAt(new Date())  // Fecha de creacion del token
                .withExpiresAt(new Date(System.currentTimeMillis() + 3600000)) // Tiempo de Expiracion del Token
                .withJWTId(UUID.randomUUID().toString())
                .sign(algorithm); // Firmamos el algoritmo con la llave de enctiptacion

        return token;
    }

    public DecodedJWT validateToken(String token) {
        try{
            Algorithm algorithm = Algorithm.HMAC256(privateKey);
            JWTVerifier jwtVerifier = JWT
                    .require(algorithm)
                    .withIssuer(this.userGenerator)
                    .build();
            DecodedJWT decodedJWT = jwtVerifier.verify(token);
            //Si llega hasta aca quiere decir que no arrojo una excepcion, por lo cual el token es correcto.
            return decodedJWT;
        }catch (Exception e){
            throw new JWTVerificationException("Token invalido.");
        }
    }

    public String extractUsername(DecodedJWT token) {
        return token.getSubject().toString();
    }

    public Claim extractSpecificClaim(DecodedJWT token, String claim) {
        return token.getClaim(claim);
    }

    public Map<String,Claim> extractAllClaims(DecodedJWT token) {
        return token.getClaims();
    }

}
