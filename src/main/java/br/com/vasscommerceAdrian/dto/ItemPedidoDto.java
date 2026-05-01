package br.com.vasscommerceAdrian.dto;

import br.com.vasscommerceAdrian.entity.ItemPedido;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class ItemPedidoRequestDto {

    @NotNull(message = "O campo produtoId é obrigatório")
    private Long produtoId;
    @NotNull(message = "O campo quantidade é obrigatório")
    private int quantidade;
    @N
    private BigDecimal valorUnitario;

    public ItemPedidoRequestDto() {}

    public ItemPedidoRequestDto(ItemPedido item) {
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
