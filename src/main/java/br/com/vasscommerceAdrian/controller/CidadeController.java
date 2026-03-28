package br.com.vasscommerceAdrian.controller;

import br.com.vasscommerceAdrian.dto.CidadeDto;
import br.com.vasscommerceAdrian.entity.CidadeEntity;
import br.com.vasscommerceAdrian.service.CidadeService;
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
    public ResponseEntity<CidadeEntity> inserir(@RequestBody CidadeDto cidadeDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cidadeService.inserir(cidadeDto));
    }

    @GetMapping(value = "/cidade/{id}" , produces = "application/json")
    public ResponseEntity<CidadeEntity> buscarPorId(@PathVariable Long id) {
        return cidadeService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(value = "/cidade" , produces = "application/json")
    public ResponseEntity<List<CidadeEntity>> buscarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(cidadeService.buscarTodos());
    }

    @GetMapping(value = "/estado/{estadoId}/cidade" , produces = "application/json")
    public ResponseEntity<List<CidadeEntity>> buscarPorEstado(@PathVariable Long estadoId) {
        return ResponseEntity.status(HttpStatus.OK).body(cidadeService.buscarPorEstado(estadoId));
    }

    @PutMapping(value = "/cidade/{id}" , consumes = "application/json" , produces = "application/json")
    public ResponseEntity<CidadeEntity> atualizar(@PathVariable Long id, @RequestBody CidadeDto cidadeDto) {
        CidadeEntity cidade = cidadeService.atualizar(id, cidadeDto);
        if (cidade != null) {
            return ResponseEntity.status(HttpStatus.OK).body(cidade);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping(value = "/cidade/{id}" , produces = "application/json")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean deletado = cidadeService.deletar(id);
        if (deletado) {
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
