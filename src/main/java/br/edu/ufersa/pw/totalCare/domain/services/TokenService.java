package br.edu.ufersa.pw.totalCare.domain.services;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import br.edu.ufersa.pw.totalCare.api.dtos.UsuarioDTO;

@Service
public class TokenService {
    
    @Value("${api.security.token.secret}")
    private String secret;
    public String generateToken(UsuarioDTO usuario) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            String token = JWT.create()
                .withIssuer("TotalCare")
                .withSubject(usuario.getEmail())
                .withExpiresAt(this.generateExpirationDate())
                .sign(algorithm);
            return token;
        } catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao gerar token");
        }
    }

    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
            .withIssuer("TotalCare")
            .build()
            .verify(token)
            .getSubject();
        } catch (JWTVerificationException exception){
            return null;
        }
    }

    private Date generateExpirationDate() {
        LocalDateTime localDateTime = LocalDateTime.now(ZoneOffset.of("-03:00")).plusHours(2);
        return Date.from(localDateTime.atZone(ZoneOffset.of("-03:00")).toInstant());
    }
}

