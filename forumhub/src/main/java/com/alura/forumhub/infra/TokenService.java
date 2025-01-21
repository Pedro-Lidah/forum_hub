package com.alura.forumhub.infra;

import com.alura.forumhub.usuaio.Usuario;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.stereotype.Service;
import com.auth0.jwt.algorithms.Algorithm;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static org.springframework.security.config.Elements.JWT;

@Service
public class TokenService {

    public String gerarToken(Usuario usuario){
        try {
            var algoritimo = Algorithm.HMAC256("");
            return JWT.create()
                    .withIssuer("forumhub")
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(dataExpiracao())
                    .sign(algoritimo);
        } catch (JWTCreationException exception){
            throw new RuntimeException("erro ao gerar token jwt", exception);
        }
    }
    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));

    }

}
