package com.senai.eventsmanager.config;

import org.springframework.stereotype.Component;
import java.security.Key;
import java.sql.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
    private final String SEGREDO = "UmaChaveSuperSecretaDeNoMinimo32Caracteres!";

    private final Key key = Keys.hmacShaKeyFor(SEGREDO.getBytes());

    public String extrairEmail(String token) {
        return getClaims(token).getBody().getSubject();
    }

    private Jws<Claims> getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
    }
    public boolean verificarSeTokenEhValido(String token) {
        try {
            getClaims(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;   

        }
        
    }
     public String gerarToken(String email){
            return Jwts.builder()
            .setSubject(email)
            .setIssuedAt(new Date (System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 4))
            .signWith(key, SignatureAlgorithm.HS256)
            .compact();
        }       
}
