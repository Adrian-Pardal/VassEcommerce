package br.com.vasscommerceAdrian.mapper;

import br.com.vasscommerceAdrian.dto.CidadeRequestDto;
import br.com.vasscommerceAdrian.dto.CidadeResponseDto;
import br.com.vasscommerceAdrian.entity.CidadeEntity;
import br.com.vasscommerceAdrian.entity.EstadoEntity;

public class CidadeMapper {
    private CidadeMapper() {
    }

    public static CidadeEntity toEntity(CidadeRequestDto dto , EstadoEntity estado){
        CidadeEntity entity = new CidadeEntity();

        entity.setNome(dto.getNome());
        entity.setEstado(estado);
        entity.setId(dto.getId());

        return entity;
    }

    public static CidadeResponseDto toResponseDto(CidadeEntity entity){
        CidadeResponseDto responseDto = new CidadeResponseDto();

        if(entity.getEstado() != null){
            responseDto.setEstadoId(entity.getEstado().getId());
        }

        responseDto.setNome(entity.getNome());
        responseDto.setId(entity.getId());

        return responseDto;
    }

    public static void updateEntity(CidadeEntity entity , CidadeRequestDto dto , EstadoEntity estado){
        if(estado != null){
            entity.setEstado(estado);
        }
        entity.setNome(dto.getNome());
    }
}
