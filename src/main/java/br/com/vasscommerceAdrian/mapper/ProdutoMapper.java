package br.com.vasscommerceAdrian.mapper;

import br.com.vasscommerceAdrian.dto.ProdutoRequestDto;
import br.com.vasscommerceAdrian.dto.ProdutoResponseDto;
import br.com.vasscommerceAdrian.entity.CategoriaEntity;
import br.com.vasscommerceAdrian.entity.ProdutoEntity;

public class ProdutoMapper {
    private ProdutoMapper() {
    }

    public static ProdutoEntity toEntity(ProdutoRequestDto dto , CategoriaEntity categoria){
        ProdutoEntity entity = new ProdutoEntity();

        entity.setNome(dto.getNome());
        entity.setDescricao(dto.getDescricao());
        entity.setFotoUrl(dto.getFotoUrl());
        entity.setValorUnitario(dto.getValorUnitario());
        entity.setCategoria(categoria);

        return entity;
    }

    public static ProdutoResponseDto toResponseDto(ProdutoEntity entity){
        ProdutoResponseDto responseDto = new ProdutoResponseDto();

        responseDto.setId(entity.getId());
        responseDto.setNome(entity.getNome());
        responseDto.setDescricao(entity.getDescricao());
        responseDto.setFotoUrl(entity.getFotoUrl());
        responseDto.setValorUnitario(entity.getValorUnitario());
        responseDto.setDataCadastro(entity.getDataCadastro());
        responseDto.setDataUltimaAtualizacao(entity.getDataUltimaAtualizacao());
        if(entity.getCategoria() != null) {
            responseDto.setCategoriaId(entity.getCategoria().getId());
            responseDto.setCategoriaNome(entity.getCategoria().getNome());
        }

        return responseDto;
    }

    public static void updateEntity(ProdutoEntity entity,ProdutoRequestDto dto,CategoriaEntity categoria){
        entity.setNome(dto.getNome());
        entity.setDescricao(dto.getDescricao());
        entity.setFotoUrl(dto.getFotoUrl());
        entity.setValorUnitario(dto.getValorUnitario());
        entity.setId(dto.getId());

        if(categoria != null) {
            entity.setCategoria(categoria);
        }
    }
}
