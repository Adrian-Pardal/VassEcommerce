package br.com.vasscommerceAdrian.dto;

import jakarta.validation.constraints.NotBlank;

public class CidadeResponseDto {
    private Long id;
    private String nome;
    private Long estadoId;

    public CidadeResponseDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Long estadoId) {
        this.estadoId = estadoId;
    }
}
