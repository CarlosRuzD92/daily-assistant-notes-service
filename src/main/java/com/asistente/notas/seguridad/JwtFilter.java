package com.asistente.notas.seguridad;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.List;

@Slf4j
@Component
@Order(1)
@RequiredArgsConstructor
public class JwtFilter implements Filter {

    private final JWTUtil jwt_util;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        if (log.isDebugEnabled()) {
            log.debug("Filtro JWT (notas): procesando {} {}", req.getMethod(), req.getRequestURI());
        }

        String authHeader = req.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            log.warn("Petición sin token Bearer");
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            res.setContentType("application/json");
            res.getWriter().write("{\"error\":\"Falta token\"}");
            return;
        }

        String token = authHeader.substring(7);

        if (!jwt_util.isTokenValid(token)) {
            log.warn("Token inválido/expirado");
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            res.setContentType("application/json");
            res.getWriter().write("{\"error\":\"Token inválido\"}");
            return;
        }

        String username = jwt_util.extractClaims(token).getSubject();
        if (username != null && !username.isBlank()) {
            if (log.isDebugEnabled()) {
                log.debug("JWT válido para usuario='{}'", username);
            }
        }

        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                username, null, List.of(new SimpleGrantedAuthority("ROLE_USER"))
        );

        SecurityContextHolder.getContext().setAuthentication(auth);

        if (log.isDebugEnabled()) {
            log.debug("SecurityContext actualizado para usuario='{}'", username);
        }

        chain.doFilter(request, response);
    }
}
