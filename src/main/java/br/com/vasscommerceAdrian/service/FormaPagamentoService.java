package br.com.vasscommerceAdrian.service;

import br.com.vasscommerceAdrian.dto.FormaPagamentoDto;
import br.com.vasscommerceAdrian.entity.*;
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

    public List<FormaPagamentoDto> listarPorCliente(Long clienteId) {
        return formaPagamentoRepository.findByClienteId(clienteId).stream()
                .filter(f -> !f.isExcluido())
                .map(FormaPagamentoDto::new)
                .collect(Collectors.toList());
    }

    public FormaPagamentoDto inserir(Long clienteId, FormaPagamentoDto dto) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        FormaPagamento forma = criarFormaPagamento(dto);
        forma.setCliente(cliente);
        return new FormaPagamentoDto(formaPagamentoRepository.save(forma));
    }

    public FormaPagamentoDto atualizar(Long clienteId, Long id, FormaPagamentoDto dto) {
        FormaPagamento forma = formaPagamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Forma de pagamento não encontrada"));

        if (!forma.getCliente().getId().equals(clienteId))
            throw new RuntimeException("Forma de pagamento não pertence ao cliente");

        if (forma instanceof Cartao c && dto.getTipoCartaoId() != null) {
            TipoCartao tipoCartao = tipoCartaoRepository.findById(dto.getTipoCartaoId())
                    .orElseThrow(() -> new RuntimeException("TipoCartao não encontrado"));
            c.setTipoCartao(tipoCartao);
        } else if (forma instanceof Pix p) {
            p.setChavePix(dto.getChavePix());
        } else if (forma instanceof Boleto b) {
            b.setCodigoBarras(dto.getCodigoBarras());
            b.setDataVencimento(dto.getDataVencimento());
        }

        return new FormaPagamentoDto(formaPagamentoRepository.save(forma));
    }

    public void deletar(Long clienteId, Long id) {
        FormaPagamento forma = formaPagamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Forma de pagamento não encontrada"));

        if (!forma.getCliente().getId().equals(clienteId))
            throw new RuntimeException("Forma de pagamento não pertence ao cliente");

        forma.setExcluido(true);
        formaPagamentoRepository.save(forma);
    }

    private FormaPagamento criarFormaPagamento(FormaPagamentoDto dto) {
        return switch (dto.getTipo()) {
            case CARTAO -> {
                Cartao c = new Cartao();
                if (dto.getTipoCartaoId() != null) {
                    TipoCartao tipoCartao = tipoCartaoRepository.findById(dto.getTipoCartaoId())
                            .orElseThrow(() -> new RuntimeException("TipoCartao não encontrado"));
                    c.setTipoCartao(tipoCartao);
                }
                yield c;
            }
            case PIX -> {
                Pix p = new Pix();
                p.setChavePix(dto.getChavePix());
                yield p;
            }
            case BOLETO -> {
                Boleto b = new Boleto();
                b.setCodigoBarras(dto.getCodigoBarras());
                b.setDataVencimento(dto.getDataVencimento());
                yield b;
            }
        };
    }
}
