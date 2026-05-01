package br.com.vasscommerceAdrian.service;

import br.com.vasscommerceAdrian.dto.ClienteRequestDto;
import br.com.vasscommerceAdrian.dto.ClienteResponseDto;
import br.com.vasscommerceAdrian.entity.ClienteEntity;
import br.com.vasscommerceAdrian.mapper.ClienteMapper;
import br.com.vasscommerceAdrian.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {


    @Autowired
    ClienteRepository clienteRepository;

    public ClienteResponseDto inserir(ClienteRequestDto clienteDto){
        return ClienteMapper.toResponseDto(clienteRepository.save(ClienteMapper.toEntity(clienteDto)));
    }

    public List<ClienteResponseDto> buscarTodos(){
        return clienteRepository.findAll().stream()
                .map(ClienteMapper :: toResponseDto)
                .collect(Collectors.toList());
    }

    public ClienteResponseDto buscarPorId(Long id){
        return  clienteRepository.findById(id)
                .map(ClienteMapper :: toResponseDto)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public void deletar(Long id){
        clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        clienteRepository.deleteById(id);
    }

    public ClienteResponseDto atualizar(Long id, ClienteRequestDto clienteDto){
        ClienteEntity cliente = clienteRepository.findById(id).orElseThrow();

        ClienteMapper.updateEntity(cliente , clienteDto);
        return ClienteMapper.toResponseDto(clienteRepository.save(cliente));
    }
}
