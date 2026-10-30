package br.com.vasscommerceAdrian.controller;

import br.com.vasscommerceAdrian.ServiceInterface.AdministradorServiceInterface;
import br.com.vasscommerceAdrian.dto.AdministradorRequestDto;
import br.com.vasscommerceAdrian.dto.AdministradorResponseDto;
import br.com.vasscommerceAdrian.service.AdministradorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/administrador"  , produces = "application/json")
public class AdministradorController {

    @Autowired
    private AdministradorServiceInterface administradorService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<AdministradorResponseDto> inserir(@Valid @RequestBody AdministradorRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(administradorService.inserir(dto));
    }

    @GetMapping
    public ResponseEntity<List<AdministradorResponseDto>> buscarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(administradorService.buscarTodos());
    }

    @GetMapping(value = "/{id}" )
    public ResponseEntity<AdministradorResponseDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(administradorService.buscarPorId(id));
    }

    @PutMapping(value ="/{id}" , consumes = "application/json")
    public ResponseEntity<AdministradorResponseDto> atualizar(@Valid @PathVariable Long id, @RequestBody AdministradorRequestDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(administradorService.atualizar(id, dto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        administradorService.deletar(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
