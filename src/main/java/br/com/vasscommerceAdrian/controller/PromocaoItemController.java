package br.com.vasscommerceAdrian.controller;

import br.com.vasscommerceAdrian.ServiceInterface.PromocaoItemServiceInterface;
import br.com.vasscommerceAdrian.dto.PromocaoItemRequestDto;
import br.com.vasscommerceAdrian.dto.PromocaoItemResponseDto;
import br.com.vasscommerceAdrian.service.PromocaoItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PromocaoItemController {

    @Autowired
    private PromocaoItemServiceInterface promocaoItemService;

    @PostMapping(value = "/promocoes/{promocaoId}/produtos", consumes = "application/json", produces = "application/json")
    public ResponseEntity<PromocaoItemResponseDto> inserir(@Valid @PathVariable Long promocaoId,
                                                           @RequestBody PromocaoItemRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(promocaoItemService.inserir(promocaoId, dto));
    }

    @GetMapping(value = "/promocoes/{promocaoId}/produtos", produces = "application/json")
    public ResponseEntity<List<PromocaoItemResponseDto>> buscarPorPromocao(@PathVariable Long promocaoId) {
        return ResponseEntity.status(HttpStatus.OK).body(promocaoItemService.buscarPorPromocao(promocaoId));
    }

    @DeleteMapping(value = "/promocao-item/{id}", produces = "application/json")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        promocaoItemService.deletar(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
