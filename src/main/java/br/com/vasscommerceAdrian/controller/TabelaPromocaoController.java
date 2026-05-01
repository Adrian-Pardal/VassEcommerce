package br.com.vasscommerceAdrian.controller;

import br.com.vasscommerceAdrian.dto.TabelaPromocaoRequestDto;
import br.com.vasscommerceAdrian.dto.TabelaPromocaoResponseDto;
import br.com.vasscommerceAdrian.service.TabelaPromocaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/promocoes", consumes = "application/json", produces = "application/json")
public class TabelaPromocaoController {

    @Autowired
    private TabelaPromocaoService tabelaPromocaoService;

    @PostMapping
    public ResponseEntity<TabelaPromocaoResponseDto> inserir(@Valid @RequestBody TabelaPromocaoRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tabelaPromocaoService.inserir(dto));
    }

    @GetMapping
    public ResponseEntity<List<TabelaPromocaoResponseDto>> buscar() {
        return ResponseEntity.status(HttpStatus.OK).body(tabelaPromocaoService.buscar());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TabelaPromocaoResponseDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(tabelaPromocaoService.buscarPorId(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TabelaPromocaoResponseDto> atualizar(@Valid @PathVariable Long id,
                                                               @RequestBody TabelaPromocaoRequestDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(tabelaPromocaoService.atualizar(id, dto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        tabelaPromocaoService.deletar(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
