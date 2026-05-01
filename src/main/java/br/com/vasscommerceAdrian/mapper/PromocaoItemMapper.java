package br.com.vasscommerceAdrian.mapper;

import br.com.vasscommerceAdrian.dto.PromocaoItemRequestDto;
import br.com.vasscommerceAdrian.dto.PromocaoItemResponseDto;
import br.com.vasscommerceAdrian.entity.ProdutoEntity;
import br.com.vasscommerceAdrian.entity.PromocaoItem;
import br.com.vasscommerceAdrian.entity.TabelaPromocao;

public class PromocaoItemMapper {

    private PromocaoItemMapper() {}

    public static PromocaoItem toEntity(PromocaoItemRequestDto dto, ProdutoEntity produto, TabelaPromocao tabelaPromocao) {
        PromocaoItem entity = new PromocaoItem();
        entity.setProduto(produto);
        entity.setTabelaPromocao(tabelaPromocao);
        entity.setValorPromocao(dto.getValorPromocao());
        return entity;
    }

    public static PromocaoItemResponseDto toResponseDto(PromocaoItem entity) {
        PromocaoItemResponseDto responseDto = new PromocaoItemResponseDto();
        responseDto.setId(entity.getId());
        responseDto.setValorPromocao(entity.getValorPromocao());
        responseDto.setDataCadastro(entity.getDataCadastro());
        responseDto.setDataUltimaAtualizacao(entity.getDataUltimaAtualizacao());

        if (entity.getProduto() != null) {
            responseDto.setProdutoId(entity.getProduto().getId());
            responseDto.setProdutoNome(entity.getProduto().getNome());
        }

        if (entity.getTabelaPromocao() != null)
            responseDto.setTabelaPromocaoId(entity.getTabelaPromocao().getId());

        return responseDto;
    }
}
