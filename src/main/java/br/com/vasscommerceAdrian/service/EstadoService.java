package br.com.vasscommerceAdrian.service;

import br.com.vasscommerceAdrian.ServiceInterface.EstadoServiceInterface;
import br.com.vasscommerceAdrian.dto.EstadoRequestDto;
import br.com.vasscommerceAdrian.dto.EstadoResponseDto;
import br.com.vasscommerceAdrian.entity.EstadoEntity;
import br.com.vasscommerceAdrian.mapper.EstadoMapper;
import br.com.vasscommerceAdrian.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstadoService implements EstadoServiceInterface {

    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public EstadoResponseDto inserir(EstadoRequestDto estadoDto) {
        return EstadoMapper.toResponseDto(estadoRepository.save(EstadoMapper.toEntity(estadoDto)));
    }

    @Override
    public EstadoResponseDto buscarPorId(Long id) {
        return estadoRepository.findById(id).map(EstadoMapper :: toResponseDto)
                .orElseThrow(() -> new RuntimeException("Estado não encontrado"));
    }

    @Override
    public List<EstadoResponseDto> buscarTodos() {
        return estadoRepository.findAll().stream()
                .map(EstadoMapper :: toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public EstadoResponseDto atualizar(Long id, EstadoRequestDto estadoDto) {
        Optional<EstadoEntity> estadoOptional = estadoRepository.findById(id);
        if (estadoOptional.isPresent()) {
            EstadoEntity estado = estadoOptional.get();
            EstadoMapper.updateEntity(estado , estadoDto);
            return EstadoMapper.toResponseDto(estadoRepository.save(estado));
        }else {
            throw new RuntimeException("Estado não encontrado");
        }
    }

    @Override
    public void deletar(Long id) {
        estadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estado não encontrado"));

        estadoRepository.deleteById(id);
    }
}
