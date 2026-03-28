package br.com.vasscommerceAdrian.controller;

import br.com.vasscommerceAdrian.dto.TipoCartaoDto;
import br.com.vasscommerceAdrian.service.TipoCartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tipo-cartao" , consumes = "application/json" , produces = "application/json")
public class TipoCartaoController {

    @Autowired
    private TipoCartaoService tipoCartaoService;

    @PostMapping
    public ResponseEntity<TipoCartaoDto> inserir(@RequestBody TipoCartaoDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoCartaoService.inserir(dto));
    }

    @GetMapping
    public ResponseEntity<List<TipoCartaoDto>> buscar() {
        return ResponseEntity.status(HttpStatus.OK).body(tipoCartaoService.buscar());
    }

    @GetMapping(value = "/{id}" )
    public ResponseEntity<TipoCartaoDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(tipoCartaoService.buscarPorId(id));
    }

    @DeleteMapping(value = "/{id}" )
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        tipoCartaoService.deletar(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
