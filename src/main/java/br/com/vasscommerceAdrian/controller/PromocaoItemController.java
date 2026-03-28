package br.com.vasscommerceAdrian.controller;

import br.com.vasscommerceAdrian.dto.PromocaoItemDto;
import br.com.vasscommerceAdrian.entity.PromocaoItem;
import br.com.vasscommerceAdrian.service.PromocaoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PromocaoItemController {

    @Autowired
    private PromocaoItemService promocaoItemService;

    @PostMapping(value = "/promocoes/{promocaoId}/produtos" , consumes = "application/json" , produces = "application/json")
    public ResponseEntity<PromocaoItem> inserir(@PathVariable Long promocaoId, @RequestBody PromocaoItemDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(promocaoItemService.inserir(promocaoId, dto));
    }

    @GetMapping(value = "/promocoes/{promocaoId}/produtos" , produces = "application/json")
    public ResponseEntity<List<PromocaoItem>> buscarPorPromocao(@PathVariable Long promocaoId) {
        return ResponseEntity.status(HttpStatus.OK).body(promocaoItemService.buscarPorPromocao(promocaoId));
    }

    @DeleteMapping(value = "/promocao-item/{id}" , produces = "application/json")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        promocaoItemService.deletar(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
