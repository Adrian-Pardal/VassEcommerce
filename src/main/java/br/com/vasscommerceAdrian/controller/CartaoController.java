package br.com.vasscommerceAdrian.controller;

import br.com.vasscommerceAdrian.ServiceInterface.CartaoServiceInterface;
import br.com.vasscommerceAdrian.dto.CartaoRequestDto;
import br.com.vasscommerceAdrian.dto.CartaoResponseDto;
import br.com.vasscommerceAdrian.service.CartaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(produces = "application/json")
public class CartaoController {

    @Autowired
    private CartaoServiceInterface cartaoService;

    @PostMapping(value = "/cartao", consumes = "application/json")
    public ResponseEntity<CartaoResponseDto> criar( @RequestBody CartaoRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cartaoService.criar(dto));
    }

    @GetMapping("/cliente/{clienteId}/cartao")
    public ResponseEntity<List<CartaoResponseDto>> listarPorCliente( @PathVariable Long clienteId) {
        return ResponseEntity.status(HttpStatus.OK).body(cartaoService.listarPorCliente(clienteId));
    }

    @GetMapping("/cartao/{id}")
    public ResponseEntity<CartaoResponseDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(cartaoService.buscarPorId(id));
    }

    @PutMapping(value = "/cartao/{id}", consumes = "application/json")
    public ResponseEntity<CartaoResponseDto> atualizar(@PathVariable Long id, @RequestBody CartaoRequestDto requestDto) {
        CartaoResponseDto responseDto = cartaoService.atualizar(id , requestDto);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    @DeleteMapping("/cartao/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        cartaoService.deletar(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
