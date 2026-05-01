package br.com.vasscommerceAdrian.service;

import br.com.vasscommerceAdrian.dto.TabelaPromocaoRequestDto;
import br.com.vasscommerceAdrian.dto.TabelaPromocaoResponseDto;
import br.com.vasscommerceAdrian.entity.TabelaPromocao;
import br.com.vasscommerceAdrian.mapper.TabelaPromocaoMapper;
import br.com.vasscommerceAdrian.repository.TabelaPromocaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TabelaPromocaoService {

    @Autowired
    private TabelaPromocaoRepository tabelaPromocaoRepository;

    public TabelaPromocaoResponseDto inserir(TabelaPromocaoRequestDto dto) {
        return TabelaPromocaoMapper.toResponseDto(
                tabelaPromocaoRepository.save(TabelaPromocaoMapper.toEntity(dto)));
    }

    public List<TabelaPromocaoResponseDto> buscar() {
        return tabelaPromocaoRepository.findAll().stream()
                .map(TabelaPromocaoMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public TabelaPromocaoResponseDto buscarPorId(Long id) {
        return tabelaPromocaoRepository.findById(id)
                .map(TabelaPromocaoMapper::toResponseDto)
                .orElseThrow(() -> new RuntimeException("Promoção não encontrada"));
    }

    public TabelaPromocaoResponseDto atualizar(Long id, TabelaPromocaoRequestDto dto) {
        TabelaPromocao promocao = tabelaPromocaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Promoção não encontrada"));
        TabelaPromocaoMapper.updateEntity(promocao, dto);
        return TabelaPromocaoMapper.toResponseDto(tabelaPromocaoRepository.save(promocao));
    }

    public void deletar(Long id) {
        tabelaPromocaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Promoção não encontrada"));
        tabelaPromocaoRepository.deleteById(id);
    }
}
