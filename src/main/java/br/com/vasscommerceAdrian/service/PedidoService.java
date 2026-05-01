package br.com.vasscommerceAdrian.service;

import br.com.vasscommerceAdrian.dto.PedidoRequestDto;
import br.com.vasscommerceAdrian.dto.PedidoResponseDto;
import br.com.vasscommerceAdrian.entity.*;
import br.com.vasscommerceAdrian.mapper.PedidoMapper;
import br.com.vasscommerceAdrian.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    @Autowired private PedidoRepository pedidoRepository;
    @Autowired private ClienteRepository clienteRepository;
    @Autowired private ProdutoRepository produtoRepository;
    @Autowired private FormaPagamentoRepository formaPagamentoRepository;

    public PedidoResponseDto criar(PedidoRequestDto dto) {
        ClienteEntity cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        List<ItemPedido> itens = new ArrayList<>();
        BigDecimal valorTotal = BigDecimal.ZERO;

        for (var itemDto : dto.getItens()) {
            ProdutoEntity produto = produtoRepository.findById(itemDto.getProdutoId())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado: " + itemDto.getProdutoId()));

            ItemPedido item = new ItemPedido();
            item.setProduto(produto);
            item.setQuantidade(itemDto.getQuantidade());
            item.setValorUnitario(produto.getValorUnitario());
            itens.add(item);

            valorTotal = valorTotal.add(produto.getValorUnitario()
                    .multiply(BigDecimal.valueOf(itemDto.getQuantidade())));
        }

        BigDecimal totalPago = dto.getPagamentos().stream()
                .map(p -> p.getValorPago())
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        if (totalPago.compareTo(valorTotal) < 0)
            throw new RuntimeException("Valor pago insuficiente. Total: " + valorTotal + ", Pago: " + totalPago);

        List<Pagamento> pagamentos = dto.getPagamentos().stream().map(p -> {
            FormaPagamentoEntity forma = formaPagamentoRepository.findById(p.getFormaPagamentoId())
                    .orElseThrow(() -> new RuntimeException("Forma de pagamento não encontrada"));

            if (!forma.getCliente().getId().equals(cliente.getId()))
                throw new RuntimeException("Forma de pagamento não pertence ao cliente");

            if (forma.isExcluido())
                throw new RuntimeException("Forma de pagamento inativa");

            Pagamento pagamento = new Pagamento();
            pagamento.setFormaPagamento(forma);
            pagamento.setValorPago(p.getValorPago());
            return pagamento;
        }).collect(Collectors.toList());

        dto.setValorTotal(valorTotal);

        Pedido salvo = pedidoRepository.save(PedidoMapper.toEntity(dto, cliente, itens, pagamentos));
        return PedidoMapper.toResponseDto(salvo);
    }

    public List<PedidoResponseDto> listarPorCliente(Long clienteId) {
        return pedidoRepository.findByClienteId(clienteId).stream()
                .map(PedidoMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public List<PedidoResponseDto> listarPorClienteEPeriodo(Long clienteId, LocalDateTime dataInicio, LocalDateTime dataFim) {
        return pedidoRepository.findByClienteIdAndDataCadastroBetween(clienteId, dataInicio, dataFim).stream()
                .map(PedidoMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public void atualizarStatus(Long pedidoId, PedidoStatus novoStatus) {
        Pedido pedido = pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        if (!pedido.getStatus().proximo().equals(novoStatus))
            throw new IllegalArgumentException(
                    "Transição inválida: " + pedido.getStatus() + " → " + novoStatus);

        PedidoMapper.updateEntity(pedido, novoStatus);
        pedidoRepository.save(pedido);
    }
}
