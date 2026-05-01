package br.com.vasscommerceAdrian.dto;

import java.math.BigDecimal;

public class PromocaoItemRequestDto {

    private Long produtoId;
    private Long tabelaPromocaoId;
    private BigDecimal valorPromocao;

    public PromocaoItemRequestDto() {}

    public Long getProdutoId() { return produtoId; }
    public void setProdutoId(Long produtoId) { this.produtoId = produtoId; }

    public Long getTabelaPromocaoId() { return tabelaPromocaoId; }
    public void setTabelaPromocaoId(Long tabelaPromocaoId) { this.tabelaPromocaoId = tabelaPromocaoId; }

    public BigDecimal getValorPromocao() { return valorPromocao; }
    public void setValorPromocao(BigDecimal valorPromocao) { this.valorPromocao = valorPromocao; }
}
