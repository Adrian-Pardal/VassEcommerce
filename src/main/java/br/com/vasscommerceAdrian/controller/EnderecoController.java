package br.com.vasscommerceAdrian.controller;

import br.com.vasscommerceAdrian.dto.EnderecoDto;
import br.com.vasscommerceAdrian.entity.EnderecoEntity;
import br.com.vasscommerceAdrian.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping(value = "/endereco" , produces = "application/json" , consumes = "application/json")
    public ResponseEntity<EnderecoEntity> inserir(@RequestBody EnderecoDto enderecoDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.inserir(enderecoDto));
    }

    @GetMapping(value = "/endereco/{id}", produces = "application/json")
    public ResponseEntity<EnderecoEntity> buscarPorId(@PathVariable Long id) {
        return enderecoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }

    @GetMapping(value = "/endereco" , produces = "application/json")
    public ResponseEntity<List<EnderecoEntity>> buscarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.buscarTodos());
    }

    @GetMapping(value = "/cliente/{clienteId}/endereco" , produces = "application/json")
    public ResponseEntity<List<EnderecoEntity>> buscarPorCliente(@PathVariable Long clienteId) {
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.buscarPorCliente(clienteId));
    }

    @PutMapping(value = "/cliente/{clienteId}/endereco/{id}" , consumes = "application/json" , produces = "application/json")
    public ResponseEntity<EnderecoEntity> atualizarPorCliente(@PathVariable Long clienteId,
                                                              @PathVariable Long id,
                                                              @RequestBody EnderecoDto enderecoDto) {
        EnderecoEntity endereco = enderecoService.atualizarPorCliente(clienteId, id, enderecoDto);
        if (endereco != null) {
            return ResponseEntity.status(HttpStatus.OK).body(endereco);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping(value = "/endereco/{id}" , consumes = "application/json" , produces = "application/json")
    public ResponseEntity<EnderecoEntity> atualizar(@PathVariable Long id, @RequestBody EnderecoDto enderecoDto) {
        EnderecoEntity endereco = enderecoService.atualizar(id, enderecoDto);
        if (endereco != null) {
            return ResponseEntity.status(HttpStatus.OK).body(endereco);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping(value = "/endereco/{id}" , produces = "application/json")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean deleted = enderecoService.deletar(id);
        if (deleted) {
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
