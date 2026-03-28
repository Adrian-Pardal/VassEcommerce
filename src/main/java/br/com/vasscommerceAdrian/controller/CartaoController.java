package br.com.vasscommerceAdrian.controller;

import br.com.vasscommerceAdrian.dto.CartaoDto;
import br.com.vasscommerceAdrian.service.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(produces = "application/json")
public class CartaoController {

    @Autowired
    private CartaoService cartaoService;

    @PostMapping(value = "/cartao", consumes = "application/json")
    public ResponseEntity<CartaoDto> criar(@RequestBody CartaoDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cartaoService.criar(dto));
    }

    @GetMapping("/cliente/{clienteId}/cartao")
    public ResponseEntity<List<CartaoDto>> listarPorCliente(@PathVariable Long clienteId) {
        return ResponseEntity.status(HttpStatus.OK).body(cartaoService.listarPorCliente(clienteId));
    }

    @GetMapping("/cartao/{id}")
    public ResponseEntity<CartaoDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(cartaoService.buscarPorId(id));
    }

    @PutMapping(value = "/cartao/{id}", consumes = "application/json")
    public ResponseEntity<CartaoDto> atualizar(@PathVariable Long id, @RequestBody CartaoDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(cartaoService.atualizar(id, dto));
    }

    @DeleteMapping("/cartao/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        cartaoService.deletar(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
