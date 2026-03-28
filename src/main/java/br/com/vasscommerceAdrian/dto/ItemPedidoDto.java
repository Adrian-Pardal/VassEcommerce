package br.com.vasscommerceAdrian.dto;

import br.com.vasscommerceAdrian.entity.ItemPedido;

import java.math.BigDecimal;

public class ItemPedidoDto {

    private Long produtoId;
    private int quantidade;
    private BigDecimal valorUnitario;

    public ItemPedidoDto() {}

    public ItemPedidoDto(ItemPedido item) {
        this.produtoId = item.getProduto().getId();
        this.quantidade = item.getQuantidade();
        this.valorUnitario = item.getValorUnitario();
    }

    public Long getProdutoId() { return produtoId; }
    public void setProdutoId(Long produtoId) { this.produtoId = produtoId; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public BigDecimal getValorUnitario() { return valorUnitario; }
    public void setValorUnitario(BigDecimal valorUnitario) { this.valorUnitario = valorUnitario; }
}
