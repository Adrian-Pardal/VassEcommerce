package br.com.vasscommerceAdrian.dto;

import br.com.vasscommerceAdrian.entity.Pedido;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class PedidoResponseDto {

    private Long id;
    private Long clienteId;
    private LocalDateTime dataCadastro;
    private BigDecimal valorTotal;
    private String status;
    private List<ItemPedidoDto> itens;
    private List<PagamentoDto> pagamentos;

    public PedidoResponseDto() {}

    public PedidoResponseDto(Pedido pedido) {
        this.id = pedido.getId();
        this.clienteId = pedido.getCliente().getId();
        this.dataCadastro = pedido.getDataCadastro();
        this.valorTotal = pedido.getValorTotal();
        this.status = pedido.getStatus().name();
        if (pedido.getItens() != null)
            this.itens = pedido.getItens().stream().map(ItemPedidoDto::new).collect(Collectors.toList());
        if (pedido.getPagamentos() != null)
            this.pagamentos = pedido.getPagamentos().stream().map(PagamentoDto::new).collect(Collectors.toList());
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }

    public LocalDateTime getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(LocalDateTime dataCadastro) { this.dataCadastro = dataCadastro; }

    public BigDecimal getValorTotal() { return valorTotal; }
    public void setValorTotal(BigDecimal valorTotal) { this.valorTotal = valorTotal; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public List<ItemPedidoDto> getItens() { return itens; }
    public void setItens(List<ItemPedidoDto> itens) { this.itens = itens; }

    public List<PagamentoDto> getPagamentos() { return pagamentos; }
    public void setPagamentos(List<PagamentoDto> pagamentos) { this.pagamentos = pagamentos; }
}
