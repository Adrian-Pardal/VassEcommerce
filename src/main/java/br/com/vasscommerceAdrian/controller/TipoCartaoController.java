package br.com.vasscommerceAdrian.controller;

import br.com.vasscommerceAdrian.ServiceInterface.TipoCartaoServiceInterface;
import br.com.vasscommerceAdrian.dto.TipoCartaoRequestDto;
import br.com.vasscommerceAdrian.dto.TipoCartaoResponseDto;
import br.com.vasscommerceAdrian.service.TipoCartaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tipo-cartao"  , produces = "application/json")
public class TipoCartaoController {

    @Autowired
    private TipoCartaoServiceInterface tipoCartaoService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<TipoCartaoResponseDto> inserir(@Valid @RequestBody TipoCartaoRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoCartaoService.inserir(dto));
    }

    @GetMapping
    public ResponseEntity<List<TipoCartaoResponseDto>> buscar() {
        return ResponseEntity.status(HttpStatus.OK).body(tipoCartaoService.buscar());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TipoCartaoResponseDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(tipoCartaoService.buscarPorId(id));
    }

    @DeleteMapping(value = "/{id}" )
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        tipoCartaoService.deletar(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
