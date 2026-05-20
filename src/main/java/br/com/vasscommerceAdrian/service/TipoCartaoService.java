package br.com.vasscommerceAdrian.service;

import br.com.vasscommerceAdrian.ServiceInterface.TipoCartaoServiceInterface;
import br.com.vasscommerceAdrian.dto.TipoCartaoRequestDto;
import br.com.vasscommerceAdrian.dto.TipoCartaoResponseDto;
import br.com.vasscommerceAdrian.mapper.TipoCartaoMapper;
import br.com.vasscommerceAdrian.repository.TipoCartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoCartaoService implements TipoCartaoServiceInterface {

    @Autowired
    private TipoCartaoRepository tipoCartaoRepository;

    @Override
    public TipoCartaoResponseDto inserir(TipoCartaoRequestDto dto) {

        return TipoCartaoMapper.toResponseDto(tipoCartaoRepository.save(TipoCartaoMapper.toEntity(dto)));
    }

    @Override
    public List<TipoCartaoResponseDto> buscar() {
        return tipoCartaoRepository.findAll().stream()
                .map(TipoCartaoMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public TipoCartaoResponseDto buscarPorId(Long id) {
        return tipoCartaoRepository.findById(id).map(TipoCartaoMapper :: toResponseDto)
                .orElseThrow(() -> new RuntimeException("TipoCartao não encontrado"));
    }

    @Override
    public void deletar(Long id) {
        tipoCartaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TipoCartao não encontrado"));
        tipoCartaoRepository.deleteById(id);
    }
}
