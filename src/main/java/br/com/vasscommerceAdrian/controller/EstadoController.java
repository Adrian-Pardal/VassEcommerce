package br.com.vasscommerceAdrian.controller;

import br.com.vasscommerceAdrian.dto.EstadoDto;
import br.com.vasscommerceAdrian.entity.EstadoEntity;
import br.com.vasscommerceAdrian.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/estado", consumes = "application/json" , produces = "application/json")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @PostMapping
    public ResponseEntity<EstadoEntity> inserir(@RequestBody EstadoDto estadoDto) {
        EstadoEntity estado = estadoService.inserir(estadoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(estado);
    }

    @GetMapping(value = "/{id}" )
    public ResponseEntity<EstadoEntity> buscarPorId(@PathVariable Long id) {
        return estadoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }

    @GetMapping
    public ResponseEntity<List<EstadoEntity>> buscarTodos() {
        List<EstadoEntity> estados = estadoService.buscarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(estados);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<EstadoEntity> atualizar(@PathVariable Long id, @RequestBody EstadoDto estadoDto) {
        EstadoEntity estado = estadoService.atualizar(id, estadoDto);
        if (estado != null) {
            return ResponseEntity.status(HttpStatus.OK).body(estado);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean deleted = estadoService.deletar(id);
        if (deleted) {
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
