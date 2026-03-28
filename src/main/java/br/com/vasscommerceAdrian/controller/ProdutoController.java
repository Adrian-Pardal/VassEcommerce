package br.com.vasscommerceAdrian.controller;

import br.com.vasscommerceAdrian.dto.ProdutoDto;
import br.com.vasscommerceAdrian.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping(value = "/produto" , consumes = "application/json" , produces = "application/json")
    public ResponseEntity<ProdutoDto> inserir(@RequestBody ProdutoDto produtoDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.inserir(produtoDto));
    }

    @GetMapping(value = "/produto" ,produces = "application/json")
    public ResponseEntity<List<ProdutoDto>> buscarTodos(
            @RequestParam(required = false) String nome ,
            @RequestParam(required = false)BigDecimal valorMinimo ,
            @RequestParam(required = false) BigDecimal valorMaximo) {

        if(nome != null || valorMinimo != null || valorMaximo != null){
            return ResponseEntity.status(HttpStatus.OK).body(produtoService.buscarComFiltros(nome, valorMinimo, valorMaximo));
        }
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.buscarTodos());
    }

    @GetMapping(value = "/produto/{id}" , produces = "application/json")
    public ResponseEntity<ProdutoDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.buscarPorId(id));
    }

    @GetMapping(value = "/categoria/{categoriaId}/produto" , produces = "application/json")
    public ResponseEntity<List<ProdutoDto>> buscarPorCategoria(@PathVariable Long categoriaId ,
                                                               @RequestParam(required = false) String nome ,
                                                               @RequestParam(required = false)BigDecimal valorMinimo ,
                                                               @RequestParam(required = false) BigDecimal valorMaximo) {
        if(nome != null || valorMinimo != null || valorMaximo != null){
            return ResponseEntity.status(HttpStatus.OK).body(produtoService.buscarPorCategoriaComFiltros(categoriaId ,nome, valorMinimo, valorMaximo));
        }
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.buscarPorCategoria(categoriaId));
    }

    @PutMapping(value = "/produto/{id}" , consumes = "application/json" , produces = "application/json")
    public ResponseEntity<ProdutoDto> atualizar(@PathVariable Long id, @RequestBody ProdutoDto produtoDto) {
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.atualizar(id, produtoDto));
    }

    @DeleteMapping(value = "/produto/{id}" , produces = "applicatiom/json")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        produtoService.deletar(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
