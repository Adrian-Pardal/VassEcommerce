package br.com.vasscommerceAdrian.mapper;

import br.com.vasscommerceAdrian.dto.CategoriaRequestDto;
import br.com.vasscommerceAdrian.dto.CategoriaResponseDto;
import br.com.vasscommerceAdrian.entity.CategoriaEntity;

public class CategoriaMapper {

    private CategoriaMapper() {
    }

    public static CategoriaEntity toEntity(CategoriaRequestDto dto){
        CategoriaEntity entity = new CategoriaEntity();
        entity.setDescricao(dto.getDescricao());
        entity.setNome(dto.getNome());
        entity.setId(dto.getId());
        entity.setImagemSimboloUM(dto.getImagemSimboloUM());

        return entity;
    }

    public static CategoriaResponseDto toResponseDto(CategoriaEntity entity){
        CategoriaResponseDto responseDto = new CategoriaResponseDto();
        responseDto.setNome(entity.getNome());
        responseDto.setDescricao(entity.getDescricao());
        responseDto.setImagemSimboloUM(entity.getImagemSimboloUM());
        responseDto.setId(entity.getId());

        return responseDto;
    }

    public static void updateEntity(CategoriaEntity entity , CategoriaRequestDto dto){
        entity.setNome(dto.getNome());
        entity.setImagemSimboloUM(dto.getImagemSimboloUM());
        entity.setDescricao(dto.getDescricao());

    }
}
