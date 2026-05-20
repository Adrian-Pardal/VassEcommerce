package br.com.vasscommerceAdrian.service;

import br.com.vasscommerceAdrian.ServiceInterface.PromocaoItemServiceInterface;
import br.com.vasscommerceAdrian.dto.PromocaoItemRequestDto;
import br.com.vasscommerceAdrian.dto.PromocaoItemResponseDto;
import br.com.vasscommerceAdrian.entity.ProdutoEntity;
import br.com.vasscommerceAdrian.entity.TabelaPromocao;
import br.com.vasscommerceAdrian.mapper.PromocaoItemMapper;
import br.com.vasscommerceAdrian.repository.PromocaoItemRepository;
import br.com.vasscommerceAdrian.repository.ProdutoRepository;
import br.com.vasscommerceAdrian.repository.TabelaPromocaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PromocaoItemService implements PromocaoItemServiceInterface {

    @Autowired private PromocaoItemRepository promocaoItemRepository;
    @Autowired private ProdutoRepository produtoRepository;
    @Autowired private TabelaPromocaoRepository tabelaPromocaoRepository;

    @Override
    public PromocaoItemResponseDto inserir(Long promocaoId, PromocaoItemRequestDto dto) {
        ProdutoEntity produto = produtoRepository.findById(dto.getProdutoId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        TabelaPromocao promocao = tabelaPromocaoRepository.findById(promocaoId)
                .orElseThrow(() -> new RuntimeException("Promoção não encontrada"));

        return PromocaoItemMapper.toResponseDto(
                promocaoItemRepository.save(PromocaoItemMapper.toEntity(dto, produto, promocao)));
    }

    @Override
    public List<PromocaoItemResponseDto> buscarPorPromocao(Long promocaoId) {
        return promocaoItemRepository.findByTabelaPromocaoId(promocaoId).stream()
                .map(PromocaoItemMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deletar(Long id) {
        promocaoItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item de promoção não encontrado"));
        promocaoItemRepository.deleteById(id);
    }
}
