package br.com.vasscommerceAdrian.service;

import br.com.vasscommerceAdrian.dto.EnderecoRequestDto;
import br.com.vasscommerceAdrian.dto.EnderecoResponseDto;
import br.com.vasscommerceAdrian.entity.CidadeEntity;
import br.com.vasscommerceAdrian.entity.ClienteEntity;
import br.com.vasscommerceAdrian.entity.EnderecoEntity;
import br.com.vasscommerceAdrian.mapper.EnderecoMapper;
import br.com.vasscommerceAdrian.repository.CidadeRepository;
import br.com.vasscommerceAdrian.repository.ClienteRepository;
import br.com.vasscommerceAdrian.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    public EnderecoResponseDto inserir(EnderecoRequestDto enderecoDto) {
        ClienteEntity cliente = clienteRepository.findById(enderecoDto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        CidadeEntity cidade = cidadeRepository.findById(enderecoDto.getCidadeId())
                .orElseThrow(() -> new RuntimeException("Cidade não encontrada"));

        EnderecoEntity endereco = EnderecoMapper.toEntity(enderecoDto , cliente ,cidade);

        return EnderecoMapper.toResponseDto(enderecoRepository.save(endereco));
    }

    public EnderecoResponseDto buscarPorId(Long id) {
        return enderecoRepository.findById(id).map(EnderecoMapper :: toResponseDto)
                .orElseThrow(() -> new RuntimeException("Endereço não encotrado"));
    }

    public List<EnderecoResponseDto> buscarTodos() {
        return enderecoRepository.findAll().stream()
                .map(EnderecoMapper :: toResponseDto)
                .collect(Collectors.toList());
    }

    public EnderecoResponseDto atualizarPorCliente(Long clienteId, Long id, EnderecoRequestDto enderecoDto) {
        EnderecoEntity endereco = enderecoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));

        if (!endereco.getCliente().getId().equals(clienteId))
            throw new RuntimeException("Endereço não pertence ao cliente");

        CidadeEntity cidade = null;
        if (enderecoDto.getCidadeId() != null) {
            cidade = cidadeRepository.findById(enderecoDto.getCidadeId())
                    .orElseThrow(() -> new RuntimeException("Cidade não encontrada"));
        }


        EnderecoMapper.updateEntityPorCLiente(endereco , enderecoDto , cidade);

        return EnderecoMapper.toResponseDto(enderecoRepository.save(endereco));
    }

    public EnderecoResponseDto atualizar(Long id, EnderecoRequestDto enderecoDto) {
        EnderecoEntity endereco = enderecoRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Endereco não encontrado"));

        ClienteEntity cliente = null;
        if (enderecoDto.getClienteId() != null) {
            cliente = clienteRepository.findById(enderecoDto.getClienteId()).orElseThrow( () -> new RuntimeException("Cliente não encontrado"));
        }

        CidadeEntity cidade = null;
        if (enderecoDto.getCidadeId() != null) {
            cidade = cidadeRepository.findById(enderecoDto.getCidadeId()).orElseThrow( () -> new RuntimeException("Cidade não encontrada"));
        }

        EnderecoMapper.updateEntity(endereco, enderecoDto , cliente , cidade);

        return EnderecoMapper.toResponseDto(enderecoRepository.save(endereco));
    }

    public List<EnderecoResponseDto> buscarPorCliente(Long clienteId) {
        return enderecoRepository.findByClienteId(clienteId).stream()
                .map(EnderecoMapper :: toResponseDto)
                .collect(Collectors.toList());
    }

    public void deletar(Long id) {
        enderecoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Endereco não encontrado"));

        enderecoRepository.deleteById(id);

    }
}
