package br.com.vasscommerceAdrian.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/admin/relatorios")
public class AdminController {

    @GetMapping
    public ResponseEntity<?> obterRelatorioFixo() {
        // Devolve um JSON simples e fixo simulando um relatório técnico
        return ResponseEntity.ok(Map.of(
                "status", "sucesso",
                "totalVendas", 15430.90,
                "novosClientes", 45,
                "descricao", "Relatório simplificado do laboratório de segurança"
        ));
    }
}