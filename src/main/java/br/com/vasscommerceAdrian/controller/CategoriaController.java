package br.com.vasscommerceAdrian.controller;

import br.com.vasscommerceAdrian.dto.CategoriaDto;
import br.com.vasscommerceAdrian.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(value = "/categoria", consumes = "application/json" , produces = "application/json")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

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
    public ResponseEntity<CategoriaDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Void> inserir(@RequestBody CategoriaDto categoria) {
        categoriaService.inserir(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(value = "/{id}" )
    public ResponseEntity<CategoriaDto> atualizar(@PathVariable Long id, @RequestBody CategoriaDto categoria) {
        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.atualizar(id, categoria));
    }

    @DeleteMapping(value = "/{id}" )
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        categoriaService.deletar(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
