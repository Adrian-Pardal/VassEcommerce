package br.com.vasscommerceAdrian.service;

import br.com.vasscommerceAdrian.dto.AdministradorDto;
import br.com.vasscommerceAdrian.dto.AdministradorResponseDto;
import br.com.vasscommerceAdrian.entity.Administrador;
import br.com.vasscommerceAdrian.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    public AdministradorResponseDto inserir(AdministradorDto dto) {
        return new AdministradorResponseDto(administradorRepository.save(new Administrador(dto)));
    }

    public List<AdministradorResponseDto> buscarTodos() {
        return administradorRepository.findAll().stream()
                .map(AdministradorResponseDto::new)
                .collect(Collectors.toList());
    }

    public AdministradorResponseDto buscarPorId(Long id) {
        return new AdministradorResponseDto(administradorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Administrador não encontrado")));
    }

    public AdministradorResponseDto atualizar(Long id, AdministradorDto dto) {
        Administrador administrador = administradorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Administrador não encontrado"));
        administrador.setNomeCompleto(dto.getNomeCompleto());
        administrador.setEmail(dto.getEmail());
        administrador.setFotoUrl(dto.getFotoUrl());
        return new AdministradorResponseDto(administradorRepository.save(administrador));
    }

    public void deletar(Long id) {
        administradorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Administrador não encontrado"));
        administradorRepository.deleteById(id);
    }
}
