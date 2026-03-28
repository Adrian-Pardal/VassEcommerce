package br.com.vasscommerceAdrian.service;

import br.com.vasscommerceAdrian.dto.EnderecoDto;
import br.com.vasscommerceAdrian.entity.CidadeEntity;
import br.com.vasscommerceAdrian.entity.Cliente;
import br.com.vasscommerceAdrian.entity.EnderecoEntity;
import br.com.vasscommerceAdrian.repository.CidadeRepository;
import br.com.vasscommerceAdrian.repository.ClienteRepository;
import br.com.vasscommerceAdrian.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    public EnderecoEntity inserir(EnderecoDto enderecoDto) {
        EnderecoEntity endereco = new EnderecoEntity();
        endereco.setRua(enderecoDto.getRua());
        endereco.setNumero(enderecoDto.getNumero());
        endereco.setCep(enderecoDto.getCep());
        endereco.setComplemento(enderecoDto.getComplemento());
        endereco.setTelefone(enderecoDto.getTelefone());
        endereco.setBairro(enderecoDto.getBairro());
        endereco.setDataCadastro(LocalDateTime.now());
        endereco.setDataUltimaAtualizacao(LocalDateTime.now());

        if (enderecoDto.getClienteId() != null) {
            Optional<Cliente> cliente = clienteRepository.findById(enderecoDto.getClienteId());
            //cliente.ifPresent(endereco::setCliente);
            endereco.setCliente(cliente.get());
        }

        if (enderecoDto.getCidadeId() != null) {
            Optional<CidadeEntity> cidade = cidadeRepository.findById(enderecoDto.getCidadeId());
            //cidade.ifPresent(endereco::setCidade);
            endereco.setCidade(cidade.get());
        }

        return enderecoRepository.save(endereco);
    }

    public Optional<EnderecoEntity> buscarPorId(Long id) {
        return enderecoRepository.findById(id);
    }

    public List<EnderecoEntity> buscarTodos() {
        return enderecoRepository.findAll();
    }

    public EnderecoEntity atualizarPorCliente(Long clienteId, Long id, EnderecoDto enderecoDto) {
        EnderecoEntity endereco = enderecoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));

        if (!endereco.getCliente().getId().equals(clienteId))
            throw new RuntimeException("Endereço não pertence ao cliente");

        endereco.setRua(enderecoDto.getRua());
        endereco.setNumero(enderecoDto.getNumero());
        endereco.setCep(enderecoDto.getCep());
        endereco.setComplemento(enderecoDto.getComplemento());
        endereco.setTelefone(enderecoDto.getTelefone());
        endereco.setBairro(enderecoDto.getBairro());
        endereco.setDataUltimaAtualizacao(LocalDateTime.now());

        if (enderecoDto.getCidadeId() != null) {
            CidadeEntity cidade = cidadeRepository.findById(enderecoDto.getCidadeId())
                    .orElseThrow(() -> new RuntimeException("Cidade não encontrada"));
            endereco.setCidade(cidade);
        }

        return enderecoRepository.save(endereco);
    }

    public EnderecoEntity atualizar(Long id, EnderecoDto enderecoDto) {
        Optional<EnderecoEntity> enderecoOptional = enderecoRepository.findById(id);
        if (enderecoOptional.isPresent()) {
            EnderecoEntity endereco = enderecoOptional.get();
            endereco.setRua(enderecoDto.getRua());
            endereco.setNumero(enderecoDto.getNumero());
            endereco.setCep(enderecoDto.getCep());
            endereco.setComplemento(enderecoDto.getComplemento());
            endereco.setTelefone(enderecoDto.getTelefone());
            endereco.setBairro(enderecoDto.getBairro());
            endereco.setDataUltimaAtualizacao(LocalDateTime.now());

            if (enderecoDto.getClienteId() != null) {
                Optional<Cliente> cliente = clienteRepository.findById(enderecoDto.getClienteId());
                //cliente.ifPresent(endereco::setCliente);
                endereco.setCliente(cliente.get());
            }

            if (enderecoDto.getCidadeId() != null) {
                Optional<CidadeEntity> cidade = cidadeRepository.findById(enderecoDto.getCidadeId());
                //cidade.ifPresent(endereco::setCidade);
                endereco.setCidade(cidade.get());
            }

            return enderecoRepository.save(endereco);
        }
        return null;
    }

    public List<EnderecoEntity> buscarPorCliente(Long clienteId) {
        return enderecoRepository.findByClienteId(clienteId);
    }

    public boolean deletar(Long id) {
        if (enderecoRepository.existsById(id)) {
            enderecoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
