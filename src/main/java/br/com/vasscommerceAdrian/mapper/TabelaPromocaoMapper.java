package br.com.vasscommerceAdrian.mapper;

import br.com.vasscommerceAdrian.dto.TabelaPromocaoRequestDto;
import br.com.vasscommerceAdrian.dto.TabelaPromocaoResponseDto;
import br.com.vasscommerceAdrian.entity.TabelaPromocao;

public class TabelaPromocaoMapper {

    private TabelaPromocaoMapper() {}

    public static TabelaPromocao toEntity(TabelaPromocaoRequestDto dto) {
        TabelaPromocao entity = new TabelaPromocao();
        entity.setNome(dto.getNome());
        entity.setDescricao(dto.getDescricao());
        entity.setDataInicio(dto.getDataInicio());
        entity.setDataFim(dto.getDataFim());
        return entity;
    }

    public static TabelaPromocaoResponseDto toResponseDto(TabelaPromocao entity) {
        TabelaPromocaoResponseDto responseDto = new TabelaPromocaoResponseDto();
        responseDto.setId(entity.getId());
        responseDto.setNome(entity.getNome());
        responseDto.setDescricao(entity.getDescricao());
        responseDto.setDataInicio(entity.getDataInicio());
        responseDto.setDataFim(entity.getDataFim());
        responseDto.setDataCadastro(entity.getDataCadastro());
        responseDto.setDataUltimaAtualizacao(entity.getDataUltimaAtualizacao());
        return responseDto;
    }

    public static void updateEntity(TabelaPromocao entity, TabelaPromocaoRequestDto dto) {
        entity.setNome(dto.getNome());
        entity.setDescricao(dto.getDescricao());
        entity.setDataInicio(dto.getDataInicio());
        entity.setDataFim(dto.getDataFim());
    }
}
