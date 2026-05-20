package br.com.vasscommerceAdrian.controller;

import br.com.vasscommerceAdrian.ServiceInterface.FormaPagamentoServiceInterface;
import br.com.vasscommerceAdrian.dto.FormaPagamentoRequestDto;
import br.com.vasscommerceAdrian.dto.FormaPagamentoResponseDto;
import br.com.vasscommerceAdrian.service.FormaPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cliente/{clienteId}/formas-de-pagamento", produces = "application/json")
public class FormaPagamentoController {

    @Autowired
    private FormaPagamentoServiceInterface formaPagamentoService;

    @GetMapping
    public ResponseEntity<List<FormaPagamentoResponseDto>> listar(@PathVariable Long clienteId) {
        return ResponseEntity.status(HttpStatus.OK).body(formaPagamentoService.listarPorCliente(clienteId));
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<FormaPagamentoResponseDto> inserir(@PathVariable Long clienteId,
                                                            @RequestBody FormaPagamentoRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(formaPagamentoService.inserir(clienteId, dto));
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<FormaPagamentoResponseDto> atualizar(@PathVariable Long clienteId,
                                                              @PathVariable Long id,
                                                              @RequestBody FormaPagamentoRequestDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(formaPagamentoService.atualizar(clienteId, id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long clienteId, @PathVariable Long id) {
        formaPagamentoService.deletar(clienteId, id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
