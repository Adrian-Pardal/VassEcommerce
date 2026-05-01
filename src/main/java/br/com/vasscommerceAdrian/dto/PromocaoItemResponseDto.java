package br.com.vasscommerceAdrian.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PromocaoItemResponseDto {

    private Long id;
    private Long produtoId;
    private String produtoNome;
    private Long tabelaPromocaoId;
    private BigDecimal valorPromocao;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataUltimaAtualizacao;

    public PromocaoItemResponseDto() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getProdutoId() { return produtoId; }
    public void setProdutoId(Long produtoId) { this.produtoId = produtoId; }

    public String getProdutoNome() { return produtoNome; }
    public void setProdutoNome(String produtoNome) { this.produtoNome = produtoNome; }

    public Long getTabelaPromocaoId() { return tabelaPromocaoId; }
    public void setTabelaPromocaoId(Long tabelaPromocaoId) { this.tabelaPromocaoId = tabelaPromocaoId; }

    public BigDecimal getValorPromocao() { return valorPromocao; }
    public void setValorPromocao(BigDecimal valorPromocao) { this.valorPromocao = valorPromocao; }

    public LocalDateTime getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(LocalDateTime dataCadastro) { this.dataCadastro = dataCadastro; }

    public LocalDateTime getDataUltimaAtualizacao() { return dataUltimaAtualizacao; }
    public void setDataUltimaAtualizacao(LocalDateTime dataUltimaAtualizacao) { this.dataUltimaAtualizacao = dataUltimaAtualizacao; }
}
