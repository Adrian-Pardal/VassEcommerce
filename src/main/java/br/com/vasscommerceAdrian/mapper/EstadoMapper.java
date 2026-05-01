package br.com.vasscommerceAdrian.mapper;

import br.com.vasscommerceAdrian.dto.CategoriaRequestDto;
import br.com.vasscommerceAdrian.dto.CidadeRequestDto;
import br.com.vasscommerceAdrian.dto.EstadoRequestDto;
import br.com.vasscommerceAdrian.dto.EstadoResponseDto;
import br.com.vasscommerceAdrian.entity.EstadoEntity;

public class EstadoMapper {
    private EstadoMapper() {
    }

    public static EstadoEntity toEntity(EstadoRequestDto dto){
        EstadoEntity entity = new EstadoEntity();
        entity.setNome(dto.getNome());
        entity.setSigla(dto.getSigla());
        entity.setId(dto.getId());

        return entity;
    }

    public static EstadoResponseDto toResponseDto(EstadoEntity entity){
        EstadoResponseDto responseDto = new EstadoResponseDto();

        responseDto.setNome(entity.getNome());
        responseDto.setSigla(entity.getSigla());
        responseDto.setId(entity.getId());

        return responseDto;
    }

    public static void updateEntity(EstadoEntity entity ,  EstadoRequestDto dto){
        entity.setNome(dto.getNome());
        entity.setSigla(dto.getSigla());
    }

}
