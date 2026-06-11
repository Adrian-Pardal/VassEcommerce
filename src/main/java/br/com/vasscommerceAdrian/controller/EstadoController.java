package br.com.vasscommerceAdrian.controller;

import br.com.vasscommerceAdrian.ServiceInterface.EstadoServiceInterface;
import br.com.vasscommerceAdrian.dto.EstadoRequestDto;
import br.com.vasscommerceAdrian.dto.EstadoResponseDto;
import br.com.vasscommerceAdrian.entity.EstadoEntity;
import br.com.vasscommerceAdrian.service.EstadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
<<<<<<< HEAD
@RequestMapping(value = "/estado" , produces = "application/json")
=======
@RequestMapping(value = "/estado", consumes = "application/json" , produces = "application/json")
>>>>>>> dde5f9a0d26a2724f296c76d658568d103b5d696
public class EstadoController {

    @Autowired
    private EstadoServiceInterface estadoService;

<<<<<<< HEAD
    @PostMapping(consumes = "application/json")
=======
    @PostMapping
>>>>>>> dde5f9a0d26a2724f296c76d658568d103b5d696
    public ResponseEntity<EstadoResponseDto> inserir(@Valid  @RequestBody EstadoRequestDto estadoDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(estadoService.inserir(estadoDto));
    }

    @GetMapping(value = "/{id}" )
    public ResponseEntity<EstadoResponseDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(estadoService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<EstadoResponseDto>> buscarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(estadoService.buscarTodos());
    }

<<<<<<< HEAD
    @PutMapping(value = "/{id}" ,consumes = "application/json")
=======
    @PutMapping(value = "/{id}")
>>>>>>> dde5f9a0d26a2724f296c76d658568d103b5d696
    public ResponseEntity<EstadoResponseDto> atualizar(@Valid @PathVariable Long id, @RequestBody EstadoRequestDto estadoDto) {
        return ResponseEntity.status(HttpStatus.OK).body(estadoService.atualizar(id, estadoDto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        estadoService.deletar(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
