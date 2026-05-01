package br.com.vasscommerceAdrian.mapper;

import br.com.vasscommerceAdrian.dto.ClienteRequestDto;
import br.com.vasscommerceAdrian.dto.ClienteResponseDto;
import br.com.vasscommerceAdrian.entity.ClienteEntity;

import java.time.LocalDateTime;

public class ClienteMapper {
    private ClienteMapper() {
    }

    public static ClienteEntity toEntity(ClienteRequestDto dto){
        ClienteEntity entity = new ClienteEntity();

        entity.setCpf(dto.getCpf());
        entity.setDataNascimento(dto.getDataNascimento());
        entity.setEmail(dto.getEmail());
        entity.setSenha(dto.getSenha());
        entity.setNomeCompleto(dto.getNomeCompleto());
        entity.setFotoUrl(dto.getFotoUrl());
        entity.setId(dto.getId());

        return entity;
    }

    public static ClienteResponseDto toResponseDto(ClienteEntity entity){
        ClienteResponseDto responseDto = new ClienteResponseDto();

        responseDto.setId(entity.getId());
        responseDto.setEmail(entity.getEmail());
        responseDto.setNomeCompleto(entity.getNomeCompleto());
        responseDto.setFotoUrl(entity.getFotoUrl());
        responseDto.setCpf(entity.getCpf());
        responseDto.setDataNascimento(entity.getDataNascimento());
        responseDto.setDataCadastro(entity.getDataCadastro());

        return  responseDto;
    }

    public static void updateEntity(ClienteEntity entity , ClienteRequestDto dto){
        entity.setEmail(dto.getEmail());
        entity.setSenha(dto.getSenha());
        entity.setNomeCompleto(dto.getNomeCompleto());
        entity.setFotoUrl(dto.getFotoUrl());
        entity.setCpf(dto.getCpf());
        entity.setDataNascimento(dto.getDataNascimento());
        entity.setDataUltimaAtualizacao(LocalDateTime.now());
    }
}
