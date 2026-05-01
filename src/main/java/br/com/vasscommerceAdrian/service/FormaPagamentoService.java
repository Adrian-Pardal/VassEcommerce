package br.com.vasscommerceAdrian.service;

import br.com.vasscommerceAdrian.dto.FormaPagamentoRequestDto;
import br.com.vasscommerceAdrian.dto.FormaPagamentoResponseDto;
import br.com.vasscommerceAdrian.entity.*;
import br.com.vasscommerceAdrian.mapper.FormaPagamentoMapper;
import br.com.vasscommerceAdrian.repository.ClienteRepository;
import br.com.vasscommerceAdrian.repository.FormaPagamentoRepository;
import br.com.vasscommerceAdrian.repository.TipoCartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FormaPagamentoService {

    @Autowired private FormaPagamentoRepository formaPagamentoRepository;
    @Autowired private ClienteRepository clienteRepository;
    @Autowired private TipoCartaoRepository tipoCartaoRepository;

    public List<FormaPagamentoResponseDto> listarPorCliente(Long clienteId) {
        return formaPagamentoRepository.findByClienteId(clienteId).stream()
                .filter(f -> !f.isExcluido())
                .map(FormaPagamentoMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public FormaPagamentoResponseDto inserir(Long clienteId, FormaPagamentoRequestDto dto) {
        ClienteEntity cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        TipoCartaoEntity tipoCartao = null;
        if (dto.getTipoCartaoId() != null) {
            tipoCartao = tipoCartaoRepository.findById(dto.getTipoCartaoId())
                    .orElseThrow(() -> new RuntimeException("TipoCartao não encontrado"));
        }

        FormaPagamentoEntity forma = FormaPagamentoMapper.toEntity(dto, cliente, tipoCartao);

        return FormaPagamentoMapper.toResponseDto(formaPagamentoRepository.save(forma)
        );
    }

    public FormaPagamentoResponseDto atualizar(Long clienteId, Long id, FormaPagamentoRequestDto dto) {
        FormaPagamentoEntity forma = formaPagamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Forma de pagamento não encontrada"));

        if (!forma.getCliente().getId().equals(clienteId))
            throw new RuntimeException("Forma de pagamento não pertence ao cliente");

        TipoCartaoEntity tipoCartao = null;
        if (dto.getTipoCartaoId() != null) {
            tipoCartao = tipoCartaoRepository.findById(dto.getTipoCartaoId())
                    .orElseThrow(() -> new RuntimeException("TipoCartao não encontrado"));
        }

        FormaPagamentoMapper.updateEntity(forma, dto, tipoCartao);

        return FormaPagamentoMapper.toResponseDto(formaPagamentoRepository.save(forma));
    }

    public void deletar(Long clienteId, Long id) {
        FormaPagamentoEntity forma = formaPagamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Forma de pagamento não encontrada"));

        if (!forma.getCliente().getId().equals(clienteId))
            throw new RuntimeException("Forma de pagamento não pertence ao cliente");

        forma.setExcluido(true);

        formaPagamentoRepository.save(forma);
    }

}
