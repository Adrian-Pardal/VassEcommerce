package br.com.vasscommerceAdrian.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tabela_promocao")
public class TabelaPromocao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String descricao;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    @CreationTimestamp
    private LocalDateTime dataCadastro;
    @UpdateTimestamp
    private LocalDateTime dataUltimaAtualizacao;

    @OneToMany(mappedBy = "tabelaPromocao", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PromocaoItem> itens;

    public TabelaPromocao() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public LocalDateTime getDataInicio() { return dataInicio; }
    public void setDataInicio(LocalDateTime dataInicio) { this.dataInicio = dataInicio; }

    public LocalDateTime getDataFim() { return dataFim; }
    public void setDataFim(LocalDateTime dataFim) { this.dataFim = dataFim; }

    public LocalDateTime getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(LocalDateTime dataCadastro) { this.dataCadastro = dataCadastro; }

    public LocalDateTime getDataUltimaAtualizacao() { return dataUltimaAtualizacao; }
    public void setDataUltimaAtualizacao(LocalDateTime dataUltimaAtualizacao) { this.dataUltimaAtualizacao = dataUltimaAtualizacao; }



}
