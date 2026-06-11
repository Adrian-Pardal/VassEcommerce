package br.com.vasscommerceAdrian.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {

        response.setStatus(HttpServletResponse.SC_FORBIDDEN); // Status 403
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // JSON padronizado solicitado na Parte 7
        response.getWriter().write(
                "{\"error\": \"Forbidden\", \"message\": \"Voce nao possui permissao para acessar este recurso.\"}"
        );
    }
}