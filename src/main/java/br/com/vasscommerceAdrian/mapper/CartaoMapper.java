package br.com.vasscommerceAdrian.mapper;

import br.com.vasscommerceAdrian.dto.CartaoRequestDto;
import br.com.vasscommerceAdrian.dto.CartaoResponseDto;
import br.com.vasscommerceAdrian.entity.CartaoEntity;
import br.com.vasscommerceAdrian.entity.ClienteEntity;
import br.com.vasscommerceAdrian.entity.TipoCartaoEntity;

public class CartaoMapper {

    private CartaoMapper() {
    }

    public static CartaoEntity toEntity(CartaoRequestDto cartao , ClienteEntity cliente , TipoCartaoEntity tipoCartao){
        CartaoEntity entity = new CartaoEntity();

        entity.setCliente(cliente);
        entity.setTipoCartao(tipoCartao);
        entity.setExcluido(cartao.isExcluido());

        return entity;
    }

    public static CartaoResponseDto toResponseDto(CartaoEntity cartao){
        CartaoResponseDto responseDto = new CartaoResponseDto();

        if(cartao.getCliente() != null) {
            responseDto.setClienteId(cartao.getCliente().getId());
        }

        if(cartao.getTipoCartao() != null){
            responseDto.setTipoCartaoId(cartao.getTipoCartao().getId());
            responseDto.setTipoCartaoDescricao(cartao.getTipoCartao().getDescricao());
        }

        responseDto.setId(cartao.getId());
        responseDto.setExcluido(cartao.isExcluido());
        responseDto.setDataCriacao(cartao.getDataCriacao());

        return responseDto;
    }

    public static void updateEntity(CartaoEntity entity , CartaoRequestDto dto,
    TipoCartaoEntity tipoCartao , ClienteEntity cliente){
        if(tipoCartao != null){
            entity.setTipoCartao(tipoCartao);
        }
        if(cliente != null){
            entity.setCliente(cliente);
        }

    }
}
