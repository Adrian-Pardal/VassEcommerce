package br.com.vasscommerceAdrian.controller;

import br.com.vasscommerceAdrian.dto.CidadeRequestDto;
import br.com.vasscommerceAdrian.dto.CidadeResponseDto;
import br.com.vasscommerceAdrian.entity.CidadeEntity;
import br.com.vasscommerceAdrian.service.CidadeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @PostMapping(value = "/cidade" , consumes = "application/json" , produces = "application/json")
    public ResponseEntity<CidadeResponseDto> inserir(@Valid  @RequestBody CidadeRequestDto cidadeDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cidadeService.inserir(cidadeDto));
    }

    @GetMapping(value = "/cidade/{id}" , produces = "application/json")
    public ResponseEntity<CidadeResponseDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(cidadeService.buscarPorId(id));

    }

    @GetMapping(value = "/cidade" , produces = "application/json")
    public ResponseEntity<List<CidadeResponseDto>> buscarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(cidadeService.buscarTodos());
    }

    @GetMapping(value = "/estado/{estadoId}/cidade" , produces = "application/json")
    public ResponseEntity<List<CidadeResponseDto>> buscarPorEstado(@PathVariable Long estadoId) {
        return ResponseEntity.status(HttpStatus.OK).body(cidadeService.buscarPorEstado(estadoId));
    }

    @PutMapping(value = "/cidade/{id}" , consumes = "application/json" , produces = "application/json")
    public ResponseEntity<CidadeResponseDto> atualizar(@Valid @PathVariable Long id, @RequestBody CidadeRequestDto cidadeDto) {

        return ResponseEntity.status(HttpStatus.OK).body(cidadeService.atualizar(id, cidadeDto));
    }

    @DeleteMapping(value = "/cidade/{id}" , produces = "application/json")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {

        cidadeService.deletar(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
