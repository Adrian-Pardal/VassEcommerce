package br.com.vasscommerceAdrian.service;

import br.com.vasscommerceAdrian.dto.ClienteDto;
import br.com.vasscommerceAdrian.dto.ClienteResponseDto;
import br.com.vasscommerceAdrian.entity.Cliente;
import br.com.vasscommerceAdrian.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {


    @Autowired
    ClienteRepository clienteRepository;

    public ClienteResponseDto inserir(ClienteDto clienteDto){
        Cliente cliente = clienteRepository.save(new Cliente(clienteDto));
        return new ClienteResponseDto(cliente);
    }

    public List<ClienteResponseDto> buscarTodos(){
        return clienteRepository.findAll().stream()
                .map(ClienteResponseDto::new)
                .collect(Collectors.toList());
    }

    public ClienteResponseDto buscarPorId(Long id){
        return new ClienteResponseDto(clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado")));
    }

    public void deletar(Long id){
        clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        clienteRepository.deleteById(id);
    }

    public ClienteResponseDto atualizar(Long id, ClienteDto clienteDto){
        Cliente cliente = clienteRepository.findById(id).orElseThrow();
        cliente.setCpf(clienteDto.getCpf());
        cliente.setDataNascimento(clienteDto.getDataNascimento());
        cliente.setNomeCompleto(clienteDto.getNomeCompleto());
        cliente.setEmail(clienteDto.getEmail());
        cliente.setFotoUrl(clienteDto.getFotoUrl());
        cliente.setSenha(clienteDto.getSenha());

        return new ClienteResponseDto(clienteRepository.save(cliente));
    }
}
