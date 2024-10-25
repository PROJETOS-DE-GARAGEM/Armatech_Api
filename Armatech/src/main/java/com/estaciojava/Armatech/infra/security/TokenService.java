package com.estaciojava.Armatech.infra.security;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.estaciojava.Armatech.model.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;

   //Método resposável por gerar um token JWT a partir dos dados de um usuário
    public String generateToken(Usuario usuario) {
        try{
            //Cria um algoritmo HMAC256 com a chave secreta. Esse algoritmo será usado para assinar o token.
            Algorithm algorithm = Algorithm.HMAC256(secret);

            //Cria um token JWT com o emissor, o e-mail do usuário e a data de expiração
            String token = JWT.create()
                    .withIssuer("Armatech")
                    .withSubject(usuario.getEmail())
                    .withExpiresAt(this.generateExpirationDate())
                    .sign(algorithm);
            return token;// Retorna o token gerado
        } catch (JWTCreationException exception){
            //Se houver algum erro na criação do token, lança uma exceção personalizada
            throw  new RuntimeException("Erro ao gerar token");
        }
    }

    //Método responsável por validar um token JWT e retornar o "Subject" (e-mail do usuário) se o token for válido
    public String validateToken(String token){
        try{
            // Cria o algoritmo HMAC256 novamente para verificar o token (usando a chave secreta)
            Algorithm algorithm = Algorithm.HMAC256(secret);
            // Valida o token e retorna o "subject" (e-mail do usuário) se o token for válido
            return JWT.require(algorithm)
                    .withIssuer("Armatech")
                    .build()
                    .verify(token)
                    .getSubject();

        } catch(JWTVerificationException exception){
            // Se houver algum erro na verificação (como token inválido ou expirado), retorna null
            return null;
        }

    }
    //Método resposável por gerar a data de expiração do token ( 2 horas após o momento atual)
    private Instant generateExpirationDate() {
        // Obtém o horário atual, adiciona 2 horas e converte para um Instant com o fuso horário "-03:00" (Horário de Brasília, por exemplo)
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}

