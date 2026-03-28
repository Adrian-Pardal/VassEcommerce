package br.com.vasscommerceAdrian.controller;

import br.com.vasscommerceAdrian.dto.AtualizarStatusDto;
import br.com.vasscommerceAdrian.dto.PedidoDto;
import br.com.vasscommerceAdrian.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class PedidoController {

    @Autowired private PedidoService pedidoService;

    @PostMapping(value = "/pedido", consumes = "application/json", produces = "application/json")
    public ResponseEntity<PedidoDto> criar(@RequestBody PedidoDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.criar(dto));
    }

    @GetMapping(value = "/cliente/{clienteId}/pedido", produces = "application/json")
    public ResponseEntity<List<PedidoDto>> listarPorCliente(
            @PathVariable Long clienteId,
            @RequestParam(required = false) LocalDateTime dataInicio,
            @RequestParam(required = false) LocalDateTime dataFim) {
        if (dataInicio != null && dataFim != null)
            return ResponseEntity.status(HttpStatus.OK).body(pedidoService.listarPorClienteEPeriodo(clienteId, dataInicio, dataFim));
        return ResponseEntity.status(HttpStatus.OK).body(pedidoService.listarPorCliente(clienteId));
    }

    @PutMapping(value = "/pedido/{id}/status", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Void> atualizarStatus(@PathVariable Long id, @RequestBody AtualizarStatusDto dto) {
        pedidoService.atualizarStatus(id, dto.getStatus());
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
