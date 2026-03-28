package br.com.vasscommerceAdrian.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

public class PromocaoItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double valorPromocao;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataUltimaAtualizacao;

    public PromocaoItemEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValorPromocao() {
        return valorPromocao;
    }

    public void setValorPromocao(double valorPromocao) {
        this.valorPromocao = valorPromocao;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDateTime getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public void setDataUltimaAtualizacao(LocalDateTime dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }



}
