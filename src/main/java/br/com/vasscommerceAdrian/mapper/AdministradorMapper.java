package br.com.vasscommerceAdrian.mapper;

import br.com.vasscommerceAdrian.dto.AdministradorRequestDto;
import br.com.vasscommerceAdrian.dto.AdministradorResponseDto;
import br.com.vasscommerceAdrian.entity.AdministradorEntity;

import java.time.LocalDateTime;

public class AdministradorMapper {

    private AdministradorMapper() {}

    public static AdministradorEntity toEntity(AdministradorRequestDto adm){
        AdministradorEntity entity = new AdministradorEntity();
        entity.setNomeCompleto(adm.getNomeCompleto());
        entity.setEmail(adm.getEmail());
        entity.setSenha(adm.getSenha());
        entity.setFotoUrl(adm.getFotoUrl());

        return entity;
    }


    public static AdministradorResponseDto toResponseDto(AdministradorEntity adm){
        AdministradorResponseDto ResponseDto = new AdministradorResponseDto();
        ResponseDto.setNomeCompleto(adm.getNomeCompleto());
        ResponseDto.setEmail(adm.getEmail());
        ResponseDto.setFotoUrl(adm.getFotoUrl());
        ResponseDto.setId(adm.getId());

        return ResponseDto;
    }

    public static void updateEntity(AdministradorEntity entity , AdministradorRequestDto dto){
        entity.setNomeCompleto(dto.getNomeCompleto());
        entity.setEmail(dto.getEmail());
        entity.setSenha(dto.getSenha());
        entity.setFotoUrl(dto.getFotoUrl());
        entity.setDataUltimaAtualizacao(LocalDateTime.now());
    }

}
