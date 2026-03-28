package br.com.vasscommerceAdrian.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "promocao_item")
public class PromocaoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal valorPromocao;
    @CreationTimestamp
    private LocalDateTime dataCadastro;
    @UpdateTimestamp
    private LocalDateTime dataUltimaAtualizacao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "produto_id")
    private ProdutoEntity produto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tabela_promocao_id")
    private TabelaPromocao tabelaPromocao;

    public PromocaoItem() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public BigDecimal getValorPromocao() { return valorPromocao; }
    public void setValorPromocao(BigDecimal valorPromocao) { this.valorPromocao = valorPromocao; }

    public LocalDateTime getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(LocalDateTime dataCadastro) { this.dataCadastro = dataCadastro; }

    public LocalDateTime getDataUltimaAtualizacao() { return dataUltimaAtualizacao; }
    public void setDataUltimaAtualizacao(LocalDateTime dataUltimaAtualizacao) { this.dataUltimaAtualizacao = dataUltimaAtualizacao; }

    public ProdutoEntity getProduto() { return produto; }
    public void setProduto(ProdutoEntity produto) { this.produto = produto; }

    public TabelaPromocao getTabelaPromocao() { return tabelaPromocao; }
    public void setTabelaPromocao(TabelaPromocao tabelaPromocao) { this.tabelaPromocao = tabelaPromocao; }
}
