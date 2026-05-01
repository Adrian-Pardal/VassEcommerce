package br.com.vasscommerceAdrian.service;

import br.com.vasscommerceAdrian.dto.AdministradorRequestDto;
import br.com.vasscommerceAdrian.dto.AdministradorResponseDto;
import br.com.vasscommerceAdrian.entity.AdministradorEntity;
import br.com.vasscommerceAdrian.mapper.AdministradorMapper;
import br.com.vasscommerceAdrian.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    public AdministradorResponseDto inserir(AdministradorRequestDto dto) {
        return AdministradorMapper.toResponseDto(administradorRepository.save(AdministradorMapper.toEntity(dto)));
    }

    public List<AdministradorResponseDto> buscarTodos() {
        return administradorRepository.findAll().stream()
                .map(AdministradorMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public AdministradorResponseDto buscarPorId(Long id) {
        return administradorRepository.findById(id).map(AdministradorMapper :: toResponseDto)
                .orElseThrow(() -> new RuntimeException("Administrador não encontrado"));
    }

    public AdministradorResponseDto atualizar(Long id, AdministradorRequestDto dto) {
        AdministradorEntity administrador = administradorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Administrador não encontrado"));
        AdministradorMapper.updateEntity(administrador , dto);
        return AdministradorMapper.toResponseDto(administradorRepository.save(administrador));
    }

    public void deletar(Long id) {
        administradorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Administrador não encontrado"));
        administradorRepository.deleteById(id);
    }
}
