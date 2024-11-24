package com.example.courses_management_service.security;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class JwtValidationService {
    
    @Value("${jwt.secret}")
    private String secretKey;
    
    public boolean validateToken(String token) {
        try {
            log.debug("Attempting to validate JWT token");
            Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8)))
                .build()
                .parseClaimsJws(token);
            log.debug("JWT token validation successful");
            return true;
        } catch (Exception e) {
            log.warn("JWT token validation failed: {}", e.getMessage());
            return false;
        }
    }
    
    public Claims getClaimsFromToken(String token) {
        log.debug("Extracting claims from JWT token");
        Claims claims = Jwts.parserBuilder()
            .setSigningKey(Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8)))
            .build()
            .parseClaimsJws(token)
            .getBody();
        log.debug("Claims extracted successfully. Subject: {}", claims.getSubject());
        return claims;
    }
}