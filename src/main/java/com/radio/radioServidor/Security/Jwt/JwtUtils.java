package com.radio.radioServidor.Security.Jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {

    public static final long JWT_MILLIS = 60000*60*24;
    public static final String JWT_SIGNATURE = "CGgT/WsXNAZMKQgOOMjawlWY8TvF9Bi+/GW/jGcZRyU=";

    //Metodo para crear el Token

    public String createToken(Authentication authentication) {
        String username = authentication.getName();
        Date currentDate = new Date();
        Date expireDate = new Date(currentDate.getTime() + JWT_MILLIS);
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS256, JWT_SIGNATURE)
                .compact();
    }

    //Metodo para extraer el username del token

    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(JWT_SIGNATURE)
                .build().parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    //Metodo para validar el token

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(JWT_SIGNATURE)
                    .build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            throw new AuthenticationCredentialsNotFoundException("Token invalido o expirado");
        }
    }
}
