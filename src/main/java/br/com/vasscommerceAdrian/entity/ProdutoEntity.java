package br.com.vasscommerceAdrian.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "produto")
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String descricao;
    private String fotoUrl;
    @CreationTimestamp
    private LocalDateTime dataCadastro;
    @UpdateTimestamp
    private LocalDateTime dataUltimaAtualizacao;
    private BigDecimal valorUnitario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria_id")
    private CategoriaEntity categoria;

    public ProdutoEntity() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getFotoUrl() { return fotoUrl; }
    public void setFotoUrl(String fotoUrl) { this.fotoUrl = fotoUrl; }

    public LocalDateTime getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(LocalDateTime dataCadastro) { this.dataCadastro = dataCadastro; }

    public LocalDateTime getDataUltimaAtualizacao() { return dataUltimaAtualizacao; }
    public void setDataUltimaAtualizacao(LocalDateTime dataUltimaAtualizacao) { this.dataUltimaAtualizacao = dataUltimaAtualizacao; }

    public BigDecimal getValorUnitario() { return valorUnitario; }
    public void setValorUnitario(BigDecimal valorUnitario) { this.valorUnitario = valorUnitario; }

    public CategoriaEntity getCategoria() { return categoria; }
    public void setCategoria(CategoriaEntity categoria) { this.categoria = categoria; }
}
