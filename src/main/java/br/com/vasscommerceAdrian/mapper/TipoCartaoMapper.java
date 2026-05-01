package br.com.vasscommerceAdrian.mapper;

import br.com.vasscommerceAdrian.dto.TipoCartaoRequestDto;
import br.com.vasscommerceAdrian.dto.TipoCartaoResponseDto;
import br.com.vasscommerceAdrian.entity.TipoCartaoEntity;

public class TipoCartaoMapper {
    private TipoCartaoMapper() {
    }

    public static TipoCartaoEntity toEntity(TipoCartaoRequestDto dto){
        TipoCartaoEntity entity = new TipoCartaoEntity();

        entity.setDescricao(dto.getDescricao());
        entity.setId(dto.getId());

        return entity;
    }

    public static TipoCartaoResponseDto toResponseDto(TipoCartaoEntity entity){
        TipoCartaoResponseDto responseDto = new TipoCartaoResponseDto();

        responseDto.setDescricao(entity.getDescricao());
        responseDto.setId(entity.getId());

        return responseDto;
    }

    public static void updateEntity(TipoCartaoEntity entity , TipoCartaoResponseDto responseDto){
        entity.setDescricao(responseDto.getDescricao());
    }
}
