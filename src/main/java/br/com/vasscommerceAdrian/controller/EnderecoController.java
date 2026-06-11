package br.com.vasscommerceAdrian.controller;

import br.com.vasscommerceAdrian.ServiceInterface.EnderecoServiceInterface;
import br.com.vasscommerceAdrian.dto.EnderecoRequestDto;
import br.com.vasscommerceAdrian.dto.EnderecoResponseDto;
import br.com.vasscommerceAdrian.entity.EnderecoEntity;
import br.com.vasscommerceAdrian.service.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EnderecoController {

    @Autowired
    private EnderecoServiceInterface enderecoService;

    @PostMapping(value = "/endereco" , produces = "application/json" , consumes = "application/json")
    public ResponseEntity<EnderecoResponseDto> inserir(@RequestBody EnderecoRequestDto enderecoDto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.inserir(enderecoDto));
    }

    @GetMapping(value = "/endereco/{id}", produces = "application/json")
    public ResponseEntity<EnderecoResponseDto> buscarPorId(@PathVariable Long id) {

        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.buscarPorId(id));
    }

    @GetMapping(value = "/endereco" , produces = "application/json")
    public ResponseEntity<List<EnderecoResponseDto>> buscarTodos() {

        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.buscarTodos());
    }

    @GetMapping(value = "/cliente/{clienteId}/endereco" , produces = "application/json")
    public ResponseEntity<List<EnderecoResponseDto>> buscarPorCliente(@PathVariable Long clienteId) {
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.buscarPorCliente(clienteId));
    }

    @PutMapping(value = "/cliente/{clienteId}/endereco/{id}" , consumes = "application/json" , produces = "application/json")
    public ResponseEntity<EnderecoResponseDto> atualizarPorCliente(@Valid  @PathVariable Long clienteId,
                                                                   @PathVariable Long id,
                                                                   @RequestBody EnderecoRequestDto enderecoDto) {

        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.atualizarPorCliente(clienteId, id, enderecoDto));
    }

    @PutMapping(value = "/endereco/{id}" , consumes = "application/json" , produces = "application/json")
    public ResponseEntity<EnderecoResponseDto> atualizar(@Valid @PathVariable Long id, @RequestBody EnderecoRequestDto enderecoDto) {

        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.atualizar(id, enderecoDto));
    }

    @DeleteMapping(value = "/endereco/{id}" , produces = "application/json")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        enderecoService.deletar(id);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
