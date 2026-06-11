package br.com.vasscommerceAdrian.controller;

import br.com.vasscommerceAdrian.ServiceInterface.CategoriaServiceInterface;
import br.com.vasscommerceAdrian.dto.CategoriaRequestDto;
import br.com.vasscommerceAdrian.dto.CategoriaResponseDto;
import br.com.vasscommerceAdrian.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping(value = "/categoria" , produces = "application/json")
public class CategoriaController {

    @Autowired
    private CategoriaServiceInterface categoriaService;

    @GetMapping
    public ResponseEntity<?> buscarTodosOuPorNome(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false)BigDecimal valorMinimo,
            @RequestParam(required = false) BigDecimal valorMaximo){

        if (nome != null) {
            return ResponseEntity.status(HttpStatus.OK).body(categoriaService.buscarPorNome(nome));
        }
        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.buscarTodos());
    }

    @GetMapping(value = "/{id}" )
    public ResponseEntity<CategoriaResponseDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.buscarPorId(id));
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<CategoriaResponseDto> inserir(@Valid @RequestBody CategoriaRequestDto categoria) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.inserir(categoria));
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<CategoriaResponseDto> atualizar(@Valid  @PathVariable Long id, @RequestBody CategoriaRequestDto categoria) {
        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.atualizar(id, categoria));
    }

    @DeleteMapping(value = "/{id}" )
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        categoriaService.deletar(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
