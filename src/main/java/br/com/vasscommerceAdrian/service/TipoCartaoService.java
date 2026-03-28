package br.com.vasscommerceAdrian.service;

import br.com.vasscommerceAdrian.dto.TipoCartaoDto;
import br.com.vasscommerceAdrian.entity.TipoCartao;
import br.com.vasscommerceAdrian.repository.TipoCartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoCartaoService {

    @Autowired
    private TipoCartaoRepository tipoCartaoRepository;

    public TipoCartaoDto inserir(TipoCartaoDto dto) {
        TipoCartao tipoCartao = new TipoCartao();
        tipoCartao.setDescricao(dto.getDescricao());
        return new TipoCartaoDto(tipoCartaoRepository.save(tipoCartao));
    }

    public List<TipoCartaoDto> buscar() {
        return tipoCartaoRepository.findAll().stream()
                .map(TipoCartaoDto::new)
                .collect(Collectors.toList());
    }

    public TipoCartaoDto buscarPorId(Long id) {
        return new TipoCartaoDto(tipoCartaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TipoCartao não encontrado")));
    }

    public void deletar(Long id) {
        tipoCartaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TipoCartao não encontrado"));
        tipoCartaoRepository.deleteById(id);
    }
}
