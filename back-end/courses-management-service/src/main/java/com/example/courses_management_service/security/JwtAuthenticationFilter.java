package com.example.courses_management_service.security;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    
    @Autowired
    private JwtValidationService jwtValidationService;
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, 
                                  HttpServletResponse response, 
                                  FilterChain filterChain) 
            throws ServletException, IOException {
        
        String requestURI = request.getRequestURI();
        log.debug("Processing request: {} {}", request.getMethod(), requestURI);
        
        try {
            String jwt = extractJwtFromRequest(request);
            
            if (jwt == null) {
                log.debug("No JWT token found in request");
                SecurityContextHolder.clearContext();
            } else {
                log.debug("JWT token found in request, attempting validation");
                
                if (jwtValidationService.validateToken(jwt)) {
                    Claims claims = jwtValidationService.getClaimsFromToken(jwt);
                    log.debug("JWT token is valid. User: {}", claims.getSubject());
                    
                    List<SimpleGrantedAuthority> authorities = extractAuthorities(claims);
                    log.debug("Extracted authorities: {}", authorities);
                    
                    UsernamePasswordAuthenticationToken authentication = 
                        new UsernamePasswordAuthenticationToken(
                            claims.getSubject(),
                            null,
                            authorities
                        );
                    
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                    log.debug("Authentication set in SecurityContext");
                } else {
                    log.warn("Invalid JWT token");
                    SecurityContextHolder.clearContext();
                }
            }
        } catch (ExpiredJwtException e) {
            log.warn("JWT token has expired", e);
            SecurityContextHolder.clearContext();
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Token has expired");
            return;
        } catch (Exception e) {
            log.error("Could not process JWT token", e);
            SecurityContextHolder.clearContext();
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Invalid token");
            return;
        }
        
        log.debug("Continuing filter chain");
        filterChain.doFilter(request, response);
    }
    
    private List<SimpleGrantedAuthority> extractAuthorities(Claims claims) {
        List<String> roles = claims.get("roles", List.class);
        if (roles != null) {
            log.debug("Found roles in JWT: {}", roles);
            return roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        }
        log.debug("No roles found in JWT");
        return Collections.emptyList();
    }
    
    private String extractJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            String token = bearerToken.substring(7);
            log.debug("Extracted token from Authorization header");
            return token;
        }
        return null;
    }
}