package br.com.vasscommerceAdrian.service;

import br.com.vasscommerceAdrian.dto.CidadeRequestDto;
import br.com.vasscommerceAdrian.dto.CidadeResponseDto;
import br.com.vasscommerceAdrian.entity.CidadeEntity;
import br.com.vasscommerceAdrian.entity.EstadoEntity;
import br.com.vasscommerceAdrian.mapper.CidadeMapper;
import br.com.vasscommerceAdrian.mapper.EstadoMapper;
import br.com.vasscommerceAdrian.repository.CidadeRepository;
import br.com.vasscommerceAdrian.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.EmptyStackException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    public CidadeResponseDto inserir(CidadeRequestDto cidadeDto) {
        EstadoEntity estado = estadoRepository.findById(cidadeDto.getEstadoId())
                .orElseThrow(() -> new RuntimeException("Estado não encontrado"));

        CidadeEntity cidade =  CidadeMapper.toEntity(cidadeDto ,estado);
        
        return CidadeMapper.toResponseDto(cidadeRepository.save(cidade));
    }

    public CidadeResponseDto buscarPorId(Long id) {

        return cidadeRepository.findById(id).map(CidadeMapper :: toResponseDto)
                .orElseThrow(() -> new RuntimeException("Cidade não encontrada"));
    }

    public List<CidadeResponseDto> buscarTodos() {
        return cidadeRepository.findAll().stream()
                .map(CidadeMapper :: toResponseDto)
                .collect(Collectors.toList());
    }

    public CidadeResponseDto atualizar(Long id, CidadeRequestDto cidadeDto) {
        CidadeEntity cidade = cidadeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cidade não existe"));

        EstadoEntity estado = null ;
        if (cidadeDto.getEstadoId() != null) {
            estado = estadoRepository.findById(cidadeDto.getEstadoId())
                    .orElseThrow(() -> new RuntimeException("Estado não existe"));

        }

        CidadeMapper.updateEntity(cidade , cidadeDto ,estado);

        CidadeEntity salvo =  cidadeRepository.save(cidade);

        return CidadeMapper.toResponseDto(salvo);


    }

    public List<CidadeResponseDto> buscarPorEstado(Long estadoId) {
        return cidadeRepository.findByEstadoId(estadoId).stream()
                .map(CidadeMapper :: toResponseDto)
                .collect(Collectors.toList());
    }

    public boolean deletar(Long id) {
        if (cidadeRepository.existsById(id)) {
            cidadeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
