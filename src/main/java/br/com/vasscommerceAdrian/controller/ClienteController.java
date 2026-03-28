package br.com.vasscommerceAdrian.controller;

import br.com.vasscommerceAdrian.dto.ClienteDto;
import br.com.vasscommerceAdrian.dto.ClienteResponseDto;
import br.com.vasscommerceAdrian.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cliente", consumes = "application/json" , produces = "application/json")
public class ClienteController {

    @Autowired
    ClienteService clienteService;
    @PostMapping
    public ResponseEntity<ClienteResponseDto> inserir(@RequestBody ClienteDto clienteDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.inserir(clienteDto));
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDto>> buscarTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.buscarTodos());
    }

    @GetMapping(value = "/{id}" )
    public ResponseEntity<ClienteResponseDto> buscarPorId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.buscarPorId(id));
    }

    @PutMapping(value = "/{id}" )
    public ResponseEntity<ClienteResponseDto> atualizar(@PathVariable Long id, @RequestBody ClienteDto clienteDto){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.atualizar(id, clienteDto));
    }
    @DeleteMapping(value = "/{id}" )
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        clienteService.deletar(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
