package br.com.vasscommerceAdrian.mapper;

import br.com.vasscommerceAdrian.dto.EnderecoRequestDto;
import br.com.vasscommerceAdrian.dto.EnderecoResponseDto;
import br.com.vasscommerceAdrian.entity.CidadeEntity;
import br.com.vasscommerceAdrian.entity.ClienteEntity;
import br.com.vasscommerceAdrian.entity.EnderecoEntity;

public class EnderecoMapper {
    private EnderecoMapper() {
    }

    public static EnderecoEntity toEntity(EnderecoRequestDto dto , ClienteEntity cliente , CidadeEntity cidade){
        EnderecoEntity entity = new EnderecoEntity();

        entity.setRua(dto.getRua());
        entity.setNumero(dto.getNumero());
        entity.setCep(dto.getCep());
        entity.setComplemento(dto.getComplemento());
        entity.setTelefone(dto.getTelefone());
        entity.setBairro(dto.getBairro());

        entity.setCliente(cliente);
        entity.setCidade(cidade);

        return entity;
    }

    public static EnderecoResponseDto toResponseDto(EnderecoEntity entity){
        EnderecoResponseDto responseDto = new EnderecoResponseDto();

        responseDto.setId(entity.getId());
        responseDto.setRua(entity.getRua());
        responseDto.setNumero(entity.getNumero());
        responseDto.setCep(entity.getCep());
        responseDto.setComplemento(entity.getComplemento());
        responseDto.setTelefone(entity.getTelefone());
        responseDto.setBairro(entity.getBairro());

        if(entity.getCliente().getId() != null){
            responseDto.setClienteId(entity.getCliente().getId());
        }

        if(entity.getCidade().getId() != null){
            responseDto.setCidadeId(entity.getCidade().getId());
        }

        return responseDto;
    }

    public static void updateEntity(EnderecoEntity entity ,EnderecoRequestDto dto ,ClienteEntity cliente , CidadeEntity cidade){
        entity.setRua(dto.getRua());
        entity.setNumero(dto.getNumero());
        entity.setCep(dto.getCep());
        entity.setComplemento(dto.getComplemento());
        entity.setTelefone(dto.getTelefone());
        entity.setBairro(dto.getBairro());

        if(cliente != null){
            entity.setCliente(cliente);
        }

        if(cidade != null){
            entity.setCidade(cidade);
        }
    }

    public static void updateEntityPorCLiente(EnderecoEntity entity ,EnderecoRequestDto dto  , CidadeEntity cidade){
        entity.setRua(dto.getRua());
        entity.setNumero(dto.getNumero());
        entity.setCep(dto.getCep());
        entity.setComplemento(dto.getComplemento());
        entity.setTelefone(dto.getTelefone());
        entity.setBairro(dto.getBairro());

        if(cidade != null){
            entity.setCidade(cidade);
        }
    }
}
